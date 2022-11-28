package awt.service.lbs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseResponse {

    ResponseHeader responseHeader;

    public BaseResponse(String statusCode, String statusMessage){
        this.responseHeader = new ResponseHeader(statusCode, statusMessage);
    }

    public static BaseResponse okResponse(String statusMessage) {return  new BaseResponse("200", statusMessage);}
}
