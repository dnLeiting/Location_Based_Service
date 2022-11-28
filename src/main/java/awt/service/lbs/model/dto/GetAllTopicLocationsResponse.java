package awt.service.lbs.model.dto;

import awt.service.lbs.model.entity.TopicLocation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetAllTopicLocationsResponse extends BaseResponse{

    List<TopicLocation> topicLocationList;

    public GetAllTopicLocationsResponse(String statusCode, String statusMessage,List<TopicLocation> topicLocationList) {
        super(statusCode, statusMessage);
        this.topicLocationList=topicLocationList;
    }
}
