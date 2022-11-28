package awt.service.lbs.model.dto;

import awt.service.lbs.model.entity.Device;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTopicRequest {

        private String name;
        private String description;
        private int transferTime;
}
