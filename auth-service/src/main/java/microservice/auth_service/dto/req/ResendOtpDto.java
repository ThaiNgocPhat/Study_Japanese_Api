package microservice.auth_service.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "DTO used for resending the OTP via username")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResendOtpDto {
    @Schema(description = "Email", example = "example@gmail.com")
    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;
}
