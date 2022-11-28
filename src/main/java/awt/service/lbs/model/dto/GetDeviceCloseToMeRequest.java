package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class GetDeviceCloseToMeRequest {

    private String deviceIds;
    private String latitudeLocation;
    private String lognitudeLocation;
    private String topicId;
    private String radius;
}
