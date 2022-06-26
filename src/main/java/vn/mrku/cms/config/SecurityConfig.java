package vn.mrku.cms.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import vn.mrku.cms.common.AccessDenied;
import vn.mrku.cms.common.AuthenticationFailure;
import vn.mrku.cms.common.AuthenticationSuccess;
import vn.mrku.cms.common.UserDetailService;
import vn.mrku.cms.domain.repository.UserRepository;

import java.security.interfaces.RSAPublicKey;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    @Value("${jwt.public.key}")
    RSAPublicKey publicKey;
    private final UserRepository userRepository;
    private final AuthenticationFailure authenticationFailure;
    private final AuthenticationSuccess authenticationSuccess;

    private final AccessDenied accessDenied;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/open/**").permitAll()
                // Swagger
                .antMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**")
                .permitAll()
//                .antMatchers("/admin/**").hasAuthority("SCOPE_ADMIN")
                .antMatchers("/admin/user/**").hasAuthority("SCOPE_ROOT")
                .anyRequest().authenticated().and()
                .formLogin()
                .loginProcessingUrl("/auth/login")
                .successHandler(authenticationSuccess)
                .failureHandler(authenticationFailure).and()
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .exceptionHandling().accessDeniedHandler(accessDenied).and()
                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.publicKey).build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailService userDetailService() {
        return new UserDetailService(userRepository);
    }

}