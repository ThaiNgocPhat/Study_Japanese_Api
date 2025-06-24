package microservice.auth_service.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import io.swagger.v3.oas.annotations.media.Schema;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "DTO used for registering a new user account")
public class RegisterDto {

    @Schema(description = "Full name of the user", example = "Nguyen Van A", required = true)
    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Schema(description = "Username", example = "nguyenvana", required = true)
    @NotBlank(message = "Username must not be blank")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

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
    private String password;

    @Schema(description = "Confirm password", example = "Abc123@", required = true)
    @NotBlank(message = "Confirm password must not be blank")
    private String confirmPassword;

    @Schema(description = "Phone number (starts with +84 or 0)", example = "0901234567", required = true)
    @NotBlank(message = "Phone number must not be blank")
    @Pattern(regexp = "^(\\+84|0)[1-9][0-9]{8}$", message = "Invalid phone number format")
    private String phone;

    @Schema(description = "User address", example = "123 Le Loi, District 1, HCMC", required = true)
    @NotBlank(message = "Address must not be blank")
    private String address;

    @Schema(description = "Gender", example = "Male", allowableValues = {"Male", "Female", "Other"}, required = true)
    @NotBlank(message = "Gender must not be blank")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @Schema(description = "Date of birth (format yyyy-MM-dd)", example = "2000-01-01", required = true)
    @NotBlank(message = "Birthday must not be blank")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birthday must be in the format yyyy-MM-dd")
    private String birthday;
}
