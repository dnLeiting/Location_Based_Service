package awt.service.lbs.service.databaseservice;

import awt.service.lbs.model.entity.TopicLocation;
import awt.service.lbs.repository.TopicLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicLocationDatabaseService {

    private final TopicLocationRepository topicLocationRepository;

    public List<TopicLocation> findAllByTopicId(String topicId) {
        List<TopicLocation> topicLocationList = topicLocationRepository.findAllByTopicId(topicId);

        return topicLocationList;
    }
}
