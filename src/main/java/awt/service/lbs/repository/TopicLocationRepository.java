package awt.service.lbs.repository;

import awt.service.lbs.model.entity.DeviceTopicKey;
import awt.service.lbs.model.entity.TopicLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicLocationRepository extends JpaRepository<TopicLocation, String> {

    List<TopicLocation> findAllByTopicId(String topicId);

    List<TopicLocation> findByTopicId(String topicId);
}
