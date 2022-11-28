package awt.service.lbs.model.dto;

import awt.service.lbs.model.entity.Topic;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetAllTopicsResponse extends  BaseResponse{

    private List<Topic> topicList;

    public GetAllTopicsResponse(String statusCode, String statusMessage, List<Topic> topicList){
        super(statusCode, statusMessage);
        this.topicList = topicList;
    }
}
