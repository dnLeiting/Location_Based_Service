package awt.service.lbs.controller;

import awt.service.lbs.controller.api.TopicLocationControllerApi;
import awt.service.lbs.model.dto.*;
import awt.service.lbs.model.entity.TopicLocation;
import awt.service.lbs.service.TopicLocationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TopicLocationController implements TopicLocationControllerApi {

    private final TopicLocationService topicLocationService;

    @Override
    public GetAllTopicLocationsResponse getAllTopicLocations(@PathVariable @NonNull String topicId) {
        List<TopicLocation> topicLocationList = topicLocationService.getAllTopics(topicId);
        return new GetAllTopicLocationsResponse("200", "Successfully executed", topicLocationList);
    }

    @Override
    public CreateTopicLocationResponse createTopicLocations(@NonNull CreateTopicLocationRequest createTopicLocationRequest) {
        String topicLocationId = topicLocationService.createTopicLocation(createTopicLocationRequest);
        return new CreateTopicLocationResponse("200", "Successfully executed", topicLocationId);
    }

    @Override
    public BaseResponse deleteTopicLocation(@PathVariable @NonNull String topicLocationId) {
        topicLocationService.deleteTopicLocation(topicLocationId);
        return BaseResponse.okResponse("Successfully executed");
    }
}
