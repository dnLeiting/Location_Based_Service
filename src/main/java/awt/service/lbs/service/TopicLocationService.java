package awt.service.lbs.service;

import awt.service.lbs.model.dto.CreateTopicLocationRequest;
import awt.service.lbs.model.entity.Topic;
import awt.service.lbs.model.entity.TopicLocation;
import awt.service.lbs.model.exceptions.ResourceNotFoundException;
import awt.service.lbs.repository.TopicLocationRepository;
import awt.service.lbs.repository.TopicRepository;
import awt.service.lbs.service.databaseservice.TopicDatabaseService;
import awt.service.lbs.service.databaseservice.TopicLocationDatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicLocationService {

    private final TopicLocationRepository topicLocationRepository;
    private final TopicDatabaseService topicDatabaseService;

    public List<TopicLocation> getAllTopics(String topicId) {
        return topicLocationRepository.findByTopicId(topicId);
    }

    public String createTopicLocation(CreateTopicLocationRequest createTopicLocationRequest) {
        Topic topic =topicDatabaseService.findById(createTopicLocationRequest.getTopicId());
        TopicLocation topicLocation = TopicLocation.builder().topic(topic).latitudeLocation(createTopicLocationRequest.getLatitudeLocation())
                .lognitudeLocation(createTopicLocationRequest.getLongitudeLocation())
                .alarmRadius(createTopicLocationRequest.getAlarmRadius())
                .messageTitle(createTopicLocationRequest.getMessageTitle())
                .messageBody(createTopicLocationRequest.getMessageBody())
                .projectId(createTopicLocationRequest.getProjectId())
                .build();
        topicLocationRepository.save(topicLocation);
        return topicLocation.getId();
    }

    public void deleteTopicLocation(String idTopicLocation) {
        TopicLocation topicLocation = topicLocationRepository.findById(idTopicLocation).orElseThrow(
                () -> new ResourceNotFoundException("Topic Location not found with topicLocationId " + idTopicLocation)
        );
        topicLocationRepository.delete(topicLocation);
    }
}
