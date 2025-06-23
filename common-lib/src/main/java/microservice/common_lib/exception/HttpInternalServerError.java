package microservice.common_lib.exception;

public class HttpInternalServerError extends RuntimeException{
    public HttpInternalServerError(String message) {
        super(message);
    }
}
