package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateTopicResponse extends BaseResponse {

    private String topicId;

    public CreateTopicResponse(String statusCode, String statusMessage, String topicId){
            super(statusCode, statusMessage);
            this.topicId=topicId;
            }
}
