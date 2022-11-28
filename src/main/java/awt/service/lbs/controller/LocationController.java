package awt.service.lbs.controller;

import awt.service.lbs.controller.api.LocationControllerApi;
import awt.service.lbs.model.dto.*;
import awt.service.lbs.service.LocationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LocationController implements LocationControllerApi{

    private final LocationService locationService;

    @Override
    public GetDevicesCloseToMeResponse getDevicesCloseToMe(@RequestBody @Validated @NonNull GetDeviceCloseToMeRequest getDeviceCloseToMeRequest){
        List<DeviceIdLocationPair> deviceIdLocationPairList = locationService.getDevicesCloseToMe(getDeviceCloseToMeRequest);
        return new GetDevicesCloseToMeResponse("200", "Successfully executed", deviceIdLocationPairList);
    }

    @Override
    public BaseResponse sendMyLocation(@RequestBody @Validated @NonNull DeviceIdLocationPair deviceIdLocationPair){
        locationService.saveLocationOfDevice(deviceIdLocationPair);
        return BaseResponse.okResponse("Successfully executed");
    }

    @Override
    public GetDeviceLocationResponse getDeviceLocation(@PathVariable String deviceId){
        DeviceIdLocationPair deviceIdLocationPair = locationService.getDeviceMyLocation(deviceId);
        return new GetDeviceLocationResponse("200", "Successfully executed", deviceIdLocationPair);
    }


}
