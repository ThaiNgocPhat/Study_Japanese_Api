package microservice.common_lib.exception;

public class HttpUnAuthorized extends RuntimeException{
    public HttpUnAuthorized (String message){
        super(message);
    }
}
