package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateTopicLocationResponse extends BaseResponse{

    private String topicLocationId;

    public CreateTopicLocationResponse(String statusCode, String statusMessage, String topicLocationId){
        super(statusCode, statusMessage);
        this.topicLocationId=topicLocationId;
    }
}
