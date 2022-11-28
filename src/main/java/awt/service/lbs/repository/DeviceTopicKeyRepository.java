package awt.service.lbs.repository;

import awt.service.lbs.model.entity.DeviceTopicKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceTopicKeyRepository extends JpaRepository<DeviceTopicKey, String> {

    List<DeviceTopicKey> findByDeviceId(String deviceId);

    List<DeviceTopicKey> findByTopicId(String topicId);

    void deleteByTopicId(String topicId);
}
