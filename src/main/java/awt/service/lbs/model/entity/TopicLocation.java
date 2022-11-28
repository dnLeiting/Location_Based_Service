package awt.service.lbs.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="topic_locations")
public class TopicLocation {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    private String id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column
    private String latitudeLocation;

    @Column
    private String lognitudeLocation;

    @Column
    private long alarmRadius;

    @Column
    private String messageTitle;

    @Column
    private String messageBody;

    @Column
    private String projectId;
}
