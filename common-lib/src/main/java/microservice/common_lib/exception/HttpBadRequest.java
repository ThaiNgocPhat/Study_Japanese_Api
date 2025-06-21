package microservice.common_lib.exception;

public class HttpBadRequest extends RuntimeException{
    public HttpBadRequest(String message) {
        super(message);
    }
}
