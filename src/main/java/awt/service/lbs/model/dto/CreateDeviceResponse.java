package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateDeviceResponse extends BaseResponse{

    private String internalDeviceId;

    public CreateDeviceResponse(String statusCode, String statusMessage, String internalDeviceId){
        super(statusCode, statusMessage);
        this.internalDeviceId=internalDeviceId;
    }
}
