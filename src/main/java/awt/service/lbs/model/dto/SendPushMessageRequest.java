package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class SendPushMessageRequest {

    private String title;
    private String body;
    private List<SendPushMessageRequestDevice> devices;
}
