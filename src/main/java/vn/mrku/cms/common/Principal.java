package vn.mrku.cms.common;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class Principal {

    @ModelAttribute
    LoggedUser getLoggedUser(@AuthenticationPrincipal Jwt user) {
        if (user != null) {
            return new LoggedUser(Integer.parseInt(user.getClaim("userId")), user.getSubject(), Integer.parseInt(user.getClaim("roleType")));
        }
        return null;
    }
}
