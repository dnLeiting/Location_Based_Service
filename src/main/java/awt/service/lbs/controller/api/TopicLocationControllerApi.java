package awt.service.lbs.controller.api;

import awt.service.lbs.model.dto.*;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

public interface TopicLocationControllerApi {

    //Get all locations registered for a topic
    @GetMapping("${endpoints.own.topicLocation.path}" + "/{topicId}")
    GetAllTopicLocationsResponse getAllTopicLocations(@PathVariable @Validated @NonNull String topicId);

    //Create new key location of a topic
    @PostMapping("${endpoints.own.topicLocation.path}")
    CreateTopicLocationResponse createTopicLocations(@RequestBody @Validated @NonNull CreateTopicLocationRequest createTopicLocationRequest);

    //Delete key location of a topic
    @DeleteMapping("${endpoints.own.topicLocation.path}" + "/{topicLocationId}")
    BaseResponse deleteTopicLocation(@PathVariable @Validated @NonNull String topicLocationId);
}
