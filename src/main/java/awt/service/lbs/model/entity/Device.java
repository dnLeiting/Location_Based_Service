package awt.service.lbs.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="devices")
public class Device implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    private String id;

    @Column
    private String latitudeLocation;

    @Column
    private String lognitudeLocation;

    @Column(name="device_OS_id")
    private String deviceOSId;

    @Column(name="operating_system")
    private String operatingSystem;
}
