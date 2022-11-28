package awt.service.lbs.controller;

import awt.service.lbs.controller.api.DeviceControllerApi;
import awt.service.lbs.model.dto.*;
import awt.service.lbs.model.entity.Device;
import awt.service.lbs.service.DeviceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeviceController implements DeviceControllerApi {

    private final DeviceService deviceService;

    @Override
    public BaseResponse deleteDevice(@RequestBody @Validated @NonNull DeleteDeviceObject deleteDeviceObject){
        deviceService.deleteDevice(deleteDeviceObject.getId());
        return BaseResponse.okResponse("Successfully executed");
    }

    @Override
    public BaseResponse createDevice(@RequestBody @Validated @NonNull CreateDeviceRequest createDeviceRequest){
        String id = deviceService.createDevice(createDeviceRequest);
        return new CreateDeviceResponse("200", "Successfully executed", id);
    }

    @Override
    public GetDeviceResponse getDevice(@PathVariable String deviceId){
        Device device = deviceService.getDevice(deviceId);
        return new GetDeviceResponse("200", "Successfully executed", device);
    }

    @Override
    public BaseResponse updateDevice(@RequestBody @Validated @NonNull UpdateDeviceRequest updateDeviceRequest){
        deviceService.updateDevice(updateDeviceRequest);
        return BaseResponse.okResponse("Successfully executed");
    }
}
