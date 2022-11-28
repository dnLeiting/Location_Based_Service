package awt.service.lbs.model.dto;

import awt.service.lbs.model.entity.Device;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetDeviceResponse extends BaseResponse{

    private Device device;

    public GetDeviceResponse(String statusCode, String statusMessage, Device device){
        super(statusCode, statusMessage);
        this.device=device;
    }

}
