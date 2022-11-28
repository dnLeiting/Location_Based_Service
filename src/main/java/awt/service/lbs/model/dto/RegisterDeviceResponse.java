package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RegisterDeviceResponse extends BaseResponse{

    private String deviceId;

    public RegisterDeviceResponse(String statusCode, String statusMessage, String deviceId){
        super(statusCode, statusMessage);
        this.deviceId=deviceId;
    }
}
