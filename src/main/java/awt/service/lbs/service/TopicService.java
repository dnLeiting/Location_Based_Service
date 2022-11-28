package awt.service.lbs.service;

import awt.service.lbs.model.dto.AssignDeviceToTopicRequest;
import awt.service.lbs.model.dto.CreateTopicRequest;
import awt.service.lbs.model.entity.Device;
import awt.service.lbs.model.entity.DeviceTopicKey;
import awt.service.lbs.model.entity.Topic;
import awt.service.lbs.repository.DeviceTopicKeyRepository;
import awt.service.lbs.repository.TopicRepository;
import awt.service.lbs.service.databaseservice.DeviceDatabaseService;
import awt.service.lbs.service.databaseservice.TopicDatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicDatabaseService topicDatabaseService;
    private final DeviceDatabaseService deviceDatabaseService;
    private final TopicRepository topicRepository;
    private final DeviceTopicKeyRepository deviceTopicKeyRepository;

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public String createTopics(CreateTopicRequest createTopicRequest) {
        Topic topic = Topic.builder().name(createTopicRequest.getName())
                .description(createTopicRequest.getDescription())
                .transferTime(createTopicRequest.getTransferTime()).build();
        topicRepository.save(topic);
        return topic.getId();
    }

    public List<Topic> getTopicsOfDevice(String deviceId) {
        return topicDatabaseService.getTopicsOfDevice(deviceId);
    }

    public void deleteTopic(String topicId) {
        topicDatabaseService.deleteTopic(topicId);
    }

    public void assignDeviceToTopic(AssignDeviceToTopicRequest assignDeviceToTopicRequest) {
        Topic topic = topicDatabaseService.findById(assignDeviceToTopicRequest.getTopicId());
        Device device = deviceDatabaseService.findById(assignDeviceToTopicRequest.getDeviceId());
        DeviceTopicKey deviceTopicKey = DeviceTopicKey.builder().deviceId(assignDeviceToTopicRequest.getDeviceId())
                .topicId(assignDeviceToTopicRequest.getTopicId()).build();
        deviceTopicKeyRepository.save(deviceTopicKey);
    }
}
