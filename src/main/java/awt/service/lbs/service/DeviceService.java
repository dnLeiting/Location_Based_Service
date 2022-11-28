package awt.service.lbs.service;

import awt.service.lbs.model.dto.CreateDeviceRequest;
import awt.service.lbs.model.dto.UpdateDeviceRequest;
import awt.service.lbs.model.entity.Device;
import awt.service.lbs.repository.DeviceRepository;
import awt.service.lbs.repository.DeviceTopicKeyRepository;
import awt.service.lbs.service.databaseservice.DeviceDatabaseService;
import awt.service.lbs.service.databaseservice.DeviceTopicKeyDatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceDatabaseService deviceDatabaseService;

    public void deleteDevice(String id) {
        deviceDatabaseService.deleteDevice(id);
    }

    public String createDevice(CreateDeviceRequest createDeviceRequest) {
        Device device = new Device();
        device.setDeviceOSId(createDeviceRequest.getDeviceOSId());
        device.setOperatingSystem(createDeviceRequest.getOperatingSystem());
        deviceRepository.save(device);
        return device.getId();
    }

    public Device getDevice(String deviceId) {
        return deviceDatabaseService.getDevice(deviceId);
    }

    public void updateDevice(UpdateDeviceRequest updateDeviceRequest) {
        Device device = deviceDatabaseService.findById(updateDeviceRequest.getId());
        device.setDeviceOSId(updateDeviceRequest.getDeviceOSId());
        deviceRepository.save(device);
    }
}
