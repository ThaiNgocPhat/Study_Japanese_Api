package microservice.auth_service.repository;

import microservice.auth_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    Optional<User> findByOtpAndIsVerifiedFalse(String otp);
    Optional<User> findByResetOtp(String resetOtp);
}
