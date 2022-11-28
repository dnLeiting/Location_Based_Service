package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetDeviceLocationResponse extends BaseResponse{

    private DeviceIdLocationPair deviceIdLocationPair;

    public GetDeviceLocationResponse(String statusCode, String statusMessage, DeviceIdLocationPair deviceIdLocationPair){
        super(statusCode, statusMessage);
        this.deviceIdLocationPair=deviceIdLocationPair;
    }
}
