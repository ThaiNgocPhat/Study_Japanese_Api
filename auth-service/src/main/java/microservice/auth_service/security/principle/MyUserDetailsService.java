package microservice.auth_service.security.principle;
import lombok.RequiredArgsConstructor;
import microservice.auth_service.entity.User;
import microservice.auth_service.repository.IUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));


        return MyUserDetails.builder()
                .user(user)
                .authorities(user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().toString())).toList())
                .build();
    }
}
