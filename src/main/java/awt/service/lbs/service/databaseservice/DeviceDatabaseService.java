package awt.service.lbs.service.databaseservice;

import awt.service.lbs.model.dto.DeviceIdLocationPair;
import awt.service.lbs.model.entity.Device;
import awt.service.lbs.model.entity.DeviceTopicKey;
import awt.service.lbs.repository.DeviceRepository;
import awt.service.lbs.repository.DeviceTopicKeyRepository;
import awt.service.lbs.repository.TopicLocationRepository;
import awt.service.lbs.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DeviceDatabaseService {

    private final DeviceRepository deviceRepository;
    private final DeviceTopicKeyDatabaseService deviceTopicKeyDatabaseService;
    private final DeviceTopicKeyRepository deviceTopicKeyRepository;

    public void deleteDevice(String id) {
        Device device = deviceRepository.findById(id).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        List<DeviceTopicKey> deviceTopicKeyList = deviceTopicKeyRepository.findByDeviceId(id);

        deviceTopicKeyList.stream().forEach(deviceTopicKey -> {
            deviceTopicKeyRepository.delete(deviceTopicKey);
        });

        deviceRepository.delete(device);
    }

    public Device getDevice(String deviceId) {
        return deviceRepository.findById(deviceId).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }

    public void saveLocationOfDevice(DeviceIdLocationPair deviceIdLocationPair) {
        Device device = deviceRepository.findById(deviceIdLocationPair.getDeviceId()).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        device.setLatitudeLocation(deviceIdLocationPair.getLatitudeLocation());
        device.setLognitudeLocation(deviceIdLocationPair.getLognitudeLocation());
        deviceRepository.save(device);
    }

    public Device findById(String deviceId) {
        return deviceRepository.findById(deviceId).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
    }
}
