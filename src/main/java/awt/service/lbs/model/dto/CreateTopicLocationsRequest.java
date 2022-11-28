package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class CreateTopicLocationsRequest {

    CreateTopicLocationRequest createTopicLocationRequestList;
}
