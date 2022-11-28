package awt.service.lbs.controller.api;

import awt.service.lbs.model.dto.*;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface DeviceControllerApi {

    @DeleteMapping("${endpoints.own.deviceEndpoint.path}")
    BaseResponse deleteDevice(@RequestBody @Validated @NonNull DeleteDeviceObject deleteDeviceObject);

    @PostMapping ("${endpoints.own.deviceEndpoint.path}")
    BaseResponse createDevice(@RequestBody @Validated @NonNull CreateDeviceRequest createDeviceRequest);

    @GetMapping("${endpoints.own.deviceEndpoint.path}"+"/{deviceId}")
    GetDeviceResponse getDevice(@PathVariable String deviceId);

    @PutMapping("${endpoints.own.deviceEndpoint.path}")
    BaseResponse updateDevice(@RequestBody @Validated @NonNull UpdateDeviceRequest updateDeviceRequest);
}
