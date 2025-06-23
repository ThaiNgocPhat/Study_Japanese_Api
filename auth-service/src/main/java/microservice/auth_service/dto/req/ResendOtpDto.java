package microservice.auth_service.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO used for resending the OTP via username")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResendOtpDto {

    @Schema(description = "Username", example = "phat123")
    @NotBlank(message = "Username is required")
    private String username;
}
