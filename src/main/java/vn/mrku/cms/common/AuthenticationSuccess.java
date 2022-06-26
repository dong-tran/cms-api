package vn.mrku.cms.common;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccess implements AuthenticationSuccessHandler {

    @Value("${jwt.public.key}")
    RSAPublicKey publicKey;

    @Value("${jwt.private.key}")
    RSAPrivateKey privateKey;

    private static final Long EXPIRATION_TIME = 1000L * 60L * 60L * 24L; // 24h

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        var user = (UserDetail) authentication.getPrincipal();
        var auth = user.getAuthorities();
        var role = auth.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        var token = generateToken(user, role);
        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.getOutputStream().println("{\"tokenType\": \"Bearer\",\"token\":\"" + token + "\",\"role\":\"" + role + "\"}");
    }

    private String generateToken(UserDetail user, String role) {
        Date issuedAt = new Date();
        Date notBefore = new Date(issuedAt.getTime());
        Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);
        return jwtEncoder().encode(JwtEncoderParameters.from(
                JwtClaimsSet.builder()
                        .subject(user.getUsername())
                        .claim("scope", role)
                        .claim("userId", Objects.toString(user.getUserId()))
                        .claim("roleType", Objects.toString(user.getRoleType()))
                        .issuer("CMS")
                        .issuedAt(issuedAt.toInstant())
                        .notBefore(notBefore.toInstant())
                        .expiresAt(expiresAt.toInstant())
                        .build())).getTokenValue();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(this.publicKey).privateKey(this.privateKey).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }
}
