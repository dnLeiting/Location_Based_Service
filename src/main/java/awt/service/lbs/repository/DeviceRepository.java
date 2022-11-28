package awt.service.lbs.repository;

import awt.service.lbs.model.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, String> {

}
