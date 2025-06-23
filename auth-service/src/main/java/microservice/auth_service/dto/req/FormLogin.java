package microservice.auth_service.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Login request data")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FormLogin {

    @Schema(description = "Username", example = "phat123")
    @NotBlank(message = "Username must not be blank")
    private String username;

    @Schema(description = "Password", example = "123456")
    @NotBlank(message = "Password must not be blank")
    private String password;
}
