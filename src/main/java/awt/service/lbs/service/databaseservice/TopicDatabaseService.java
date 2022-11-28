package awt.service.lbs.service.databaseservice;

import awt.service.lbs.model.entity.DeviceTopicKey;
import awt.service.lbs.model.entity.Topic;
import awt.service.lbs.repository.DeviceRepository;
import awt.service.lbs.repository.DeviceTopicKeyRepository;
import awt.service.lbs.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TopicDatabaseService {

    private final TopicRepository topicRepository;
    private final DeviceTopicKeyRepository deviceTopicKeyRepository;

    public void deleteTopic(String topicId) {
        Topic topic = topicRepository.findById(topicId).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        List<DeviceTopicKey> deviceTopicKeys = deviceTopicKeyRepository.findByTopicId(topicId);
        deviceTopicKeys.stream().forEach(deviceTopicKey -> {
            deviceTopicKeyRepository.delete(deviceTopicKey);
        });
        deviceTopicKeyRepository.deleteByTopicId(topicId);
        topicRepository.delete(topic);
    }

    public List<Topic> getTopicsOfDevice(String deviceId) {
        List<DeviceTopicKey> deviceTopicKeys = deviceTopicKeyRepository.findByDeviceId(deviceId);

        List<String> idList = deviceTopicKeys
                .stream()
                .map(DeviceTopicKey::getDeviceId)
                .collect(Collectors.toList());
        List<Topic> topicList = new ArrayList<Topic>();
        List<Optional<Topic>> topicListOptional = new ArrayList<Optional<Topic>>();
        deviceTopicKeys.stream().forEach(deviceTopicKey -> {
                    Topic topic = topicRepository.findById(deviceTopicKey.getTopicId()).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
                    topicList.add(topic);
                }
        );
        return topicList;
    }

    public Topic findById(String topicId) {
        Topic topic = topicRepository.findById(topicId).orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        return topic;
    }
}
