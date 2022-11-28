package awt.service.lbs.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="topics")
public class Topic {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    private String id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int transferTime;

    @JsonManagedReference
    @OneToMany(mappedBy ="topic")
    private Set<TopicLocation> topicLocations;
}
