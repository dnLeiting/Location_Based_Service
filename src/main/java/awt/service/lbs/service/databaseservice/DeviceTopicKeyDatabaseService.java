package awt.service.lbs.service.databaseservice;

import awt.service.lbs.model.entity.DeviceTopicKey;
import awt.service.lbs.model.exceptions.EntityNotFoundExceptionById;
import awt.service.lbs.repository.DeviceRepository;
import awt.service.lbs.repository.DeviceTopicKeyRepository;
import awt.service.lbs.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeviceTopicKeyDatabaseService {

    private final DeviceTopicKeyRepository deviceTopicKeyRepository;

    public List<DeviceTopicKey> findByTopicId(String topicId) {
        return deviceTopicKeyRepository.findByTopicId(topicId);
    }

    public void deleteByDeviceId(String id) {
        List<DeviceTopicKey> deviceTopicKeyList = deviceTopicKeyRepository.findByDeviceId(id);

        if(deviceTopicKeyList.size()==0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");

        deviceTopicKeyList.stream().forEach(deviceTopicKey -> {
            deviceTopicKeyRepository.delete(deviceTopicKey);
        });
    }

    public List<DeviceTopicKey> findByDeviceId(String id) {
        return deviceTopicKeyRepository.findByDeviceId(id);
    }
}
