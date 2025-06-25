package microservice.auth_service.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
@Component
public class SwaggerStartupListener {
    private static final String SWAGGER_URL = "http://localhost:9999/swagger-ui/index.html";
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        System.out.println("\n\n🚀 Swagger UI is available at: " + SWAGGER_URL + "\n");
    }
}
