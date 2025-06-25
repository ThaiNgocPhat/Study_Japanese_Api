package microservice.auth_service.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OtpForgotPasswordDto {
    @Schema(description = "OTP code", example = "123456")
    @NotBlank(message = "OTP is required")
    private String resetOtp;
}
