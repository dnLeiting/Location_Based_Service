package awt.service.lbs.controller.api;

import awt.service.lbs.model.dto.*;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface TopicControllerApi {

    //Get all public topics
    @GetMapping("${endpoints.own.topicEndpoint.path}")
    GetAllTopicsResponse getAllTopics();

    //Create Topic
    @PostMapping("${endpoints.own.topicEndpoint.path}")
    CreateTopicResponse createTopics(@RequestBody @Validated @NonNull CreateTopicRequest createTopicRequest);

    //Delete Topic
    @DeleteMapping("${endpoints.own.topicEndpoint.path}")
    BaseResponse deleteTopic(@RequestBody @Validated @NonNull DeleteTopicRequest deleteTopicRequest);

    //Get all topics i subscribed to
    @GetMapping("${endpoints.own.myTopicEndpoint.path}"+"/{deviceId}")
    GetTopicOfDeviceResponse getTopicsOfDevice(@PathVariable String deviceId);

    //Add my device to a topic
    @PostMapping("${endpoints.own.myTopicEndpoint.path}")
    BaseResponse assignDeviceToTopic(@RequestBody AssignDeviceToTopicRequest assignDeviceToTopicRequest);
}
