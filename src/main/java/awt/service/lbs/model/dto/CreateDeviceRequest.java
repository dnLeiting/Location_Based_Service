package awt.service.lbs.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDeviceRequest {

    private String deviceOSId;
    private String operatingSystem;
}
