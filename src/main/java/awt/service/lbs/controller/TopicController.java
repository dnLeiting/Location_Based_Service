package awt.service.lbs.controller;

import awt.service.lbs.controller.api.TopicControllerApi;
import awt.service.lbs.model.dto.*;
import awt.service.lbs.model.entity.Topic;
import awt.service.lbs.service.TopicService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TopicController implements TopicControllerApi {

    private final TopicService topicService;

    @Override
    public GetAllTopicsResponse getAllTopics(){
        List<Topic> topicList = topicService.getAllTopics();
        return new GetAllTopicsResponse("200", "Successfully executed", topicList);
    }

    @Override
    public CreateTopicResponse createTopics(@RequestBody @Validated @NonNull CreateTopicRequest createTopicRequest){
        String topicId = topicService.createTopics(createTopicRequest);
        return new CreateTopicResponse("200", "Successfully executed", topicId);
    }

    @Override
    public BaseResponse deleteTopic(@RequestBody @Validated @NonNull DeleteTopicRequest deleteTopicRequest){
        topicService.deleteTopic(deleteTopicRequest.getId());
        return BaseResponse.okResponse("Successfully executed");
    }

    @Override
    public GetTopicOfDeviceResponse getTopicsOfDevice(@PathVariable String deviceId){
        List<Topic> topicList = topicService.getTopicsOfDevice(deviceId);
        return new GetTopicOfDeviceResponse("200", "Successfully executed", topicList);
    }

    @Override
    public BaseResponse assignDeviceToTopic(@RequestBody @Validated @NonNull AssignDeviceToTopicRequest assignDeviceToTopicRequest){
        topicService.assignDeviceToTopic(assignDeviceToTopicRequest);
        return BaseResponse.okResponse("Successfully executed");
    }
}
