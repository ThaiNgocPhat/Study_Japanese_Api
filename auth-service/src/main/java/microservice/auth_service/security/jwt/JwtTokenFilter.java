//package microservice.auth_service.security.jwt;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import microservice.auth_service.security.principle.MyUserDetailsService;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class JwtTokenFilter extends OncePerRequestFilter
//{
//    private final MyUserDetailsService userDetailsService;
//    private final JwtProvider jwtProvider;
//
//    private static final List<String> EXCLUDED_PATHS = List.of(
//            "/swagger-ui", "/swagger-ui.html", "/v3/api-docs", "/api-docs", "/docs", "/webjars", "/auth"
//    );
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException, IOException {
//
//        String path = request.getServletPath(); // <- DÙNG getServletPath() CHÍNH XÁC
//        for (String prefix : EXCLUDED_PATHS) {
//            if (path.startsWith(prefix)) {
//                log.info("Bypassing JWT filter for: {}", path);
//                filterChain.doFilter(request, response);
//                return;
//            }
//        }
//
//        try {
//            String token = getTokenFromRequest(request);
//            if (token != null) {
//                String username = jwtProvider.extractUsername(token);
//                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                if (jwtProvider.validateToken(token, userDetails)) {
//                    Authentication authentication = new UsernamePasswordAuthenticationToken(
//                            userDetails, null, userDetails.getAuthorities());
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        } catch (Exception ex) {
//            log.error("JWT Filter Error: {}", ex.getMessage());
//        }
//
//        filterChain.doFilter(request, response);
//    }
//
//
//    private String getTokenFromRequest(HttpServletRequest request) {
//        String bearer = request.getHeader("Authorization");
//        if (bearer != null && bearer.startsWith("Bearer ")) {
//            return bearer.substring(7);
//        }
//        return null;
//    }
//}
//


package microservice.auth_service.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservice.auth_service.security.principle.MyUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {
    private final MyUserDetailsService userDetailsService;
    private final JwtProvider jwtProvider;

    private static final List<String> EXCLUDED_PATH_PREFIXES = List.of(
            "/swagger-ui", "/swagger-ui.html", "/v3/api-docs", "/api-docs", "/docs", "/webjars", "/auth"
    );

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getServletPath();
        for (String prefix : EXCLUDED_PATH_PREFIXES) {
            if (pathMatcher.match(prefix, path)) {
                log.info("Bypassing JWT filter for: {}", path);
                filterChain.doFilter(request, response);
                return;
            }
        }

        try {
            String token = getTokenFromRequest(request);
            if (token != null) {
                String username = jwtProvider.extractUsername(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (jwtProvider.validateToken(token, userDetails)) {
                    Authentication authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception ex) {
            log.error("JWT Filter Error: {}", ex.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader("Authorization");
        return (bearer != null && bearer.startsWith("Bearer ")) ? bearer.substring(7) : null;
    }
}
