package awt.service.lbs.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignDeviceToTopicRequest {

    private String deviceId;
    private String topicId;
}
