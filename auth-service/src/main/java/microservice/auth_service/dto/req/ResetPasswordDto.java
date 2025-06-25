package microservice.auth_service.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResetPasswordDto {
    @Schema(description = "Email address", example = "nguyenvana@gmail.com", required = true)
    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email format")
    private String email;

    @Schema(description = "Password must contain at least 1 lowercase, 1 uppercase, 1 digit, 1 special character and be at least 6 characters", example = "Abc123@", required = true)
    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{6,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and one special character"
    )
    private String newPassword;

    @Schema(description = "Confirm password", example = "Abc123@", required = true)
    @NotBlank(message = "Confirm password must not be blank")
    private String confirmNewPassword;
}
