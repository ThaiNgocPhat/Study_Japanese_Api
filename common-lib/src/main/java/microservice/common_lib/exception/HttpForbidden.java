package microservice.common_lib.exception;

public class HttpForbidden extends RuntimeException{
    public HttpForbidden (String message) {
        super(message);
    }
}
