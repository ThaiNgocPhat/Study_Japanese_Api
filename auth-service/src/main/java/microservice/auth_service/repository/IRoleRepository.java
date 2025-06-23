package microservice.auth_service.repository;

import microservice.auth_service.entity.Role;
import microservice.auth_service.entity.contants.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRoleName(RoleEnum roleEnum);
}
