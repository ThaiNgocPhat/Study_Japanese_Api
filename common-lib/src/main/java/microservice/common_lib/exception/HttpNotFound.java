package microservice.common_lib.exception;

public class HttpNotFound extends RuntimeException{
    public HttpNotFound (String message) {
        super(message);
    }
}
