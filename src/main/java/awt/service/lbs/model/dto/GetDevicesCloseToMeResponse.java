package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetDevicesCloseToMeResponse extends BaseResponse{

    private List<DeviceIdLocationPair> deviceIdLocationPairList;

    public GetDevicesCloseToMeResponse(String statusCode, String statusMessage, List<DeviceIdLocationPair> deviceIdLocationPairList){
        super(statusCode, statusMessage);
        this.deviceIdLocationPairList=deviceIdLocationPairList;
    }
}
