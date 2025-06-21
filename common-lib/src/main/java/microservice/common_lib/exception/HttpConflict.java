package microservice.common_lib.exception;

public class HttpConflict extends RuntimeException{
    public HttpConflict(String message) {
        super(message);
    }
}
