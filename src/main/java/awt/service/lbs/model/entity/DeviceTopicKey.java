package awt.service.lbs.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name="device_topic")
public class DeviceTopicKey implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", unique = true)
    private Integer id;

    @Column(name = "device_id")
    String deviceId;

    @Column(name = "topic_id")
    String topicId;
}
