package microservice.common_lib.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseWrapper <T>{
    private HttpStatus status;
    private int code;
    private T data;
}
