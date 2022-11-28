package awt.service.lbs.controller.api;

import awt.service.lbs.model.dto.*;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface LocationControllerApi {

    //Get the devices which are close to me
    @GetMapping("${endpoints.own.devicesLocation.path}")
    GetDevicesCloseToMeResponse getDevicesCloseToMe(@RequestBody @Validated @NonNull GetDeviceCloseToMeRequest getDeviceCloseToMeRequest);

    //Send own location to a topic
    @PutMapping("${endpoints.own.deviceLocation.path}")
    BaseResponse sendMyLocation(@RequestBody @Validated @NonNull DeviceIdLocationPair deviceIdLocationPair);

    //Get the location of my device (my UUID)
    @GetMapping("${endpoints.own.deviceLocation.path}" + "/{deviceId}")
    GetDeviceLocationResponse getDeviceLocation(@PathVariable @Validated @NonNull String deviceId);
}
