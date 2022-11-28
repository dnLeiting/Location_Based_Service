package awt.service.lbs.client;

import awt.service.lbs.model.dto.BaseResponse;
import awt.service.lbs.model.dto.SendPushMessageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "pushService", url = "http://localhost:8080")
public interface PushServiceClient {

    @PostMapping("projects/{projectId}/notifications")
    BaseResponse sendMessage(@PathVariable("projectId") String projectId, @RequestBody SendPushMessageRequest sendPushMessageRequest);
}
