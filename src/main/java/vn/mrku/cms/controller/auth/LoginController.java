package vn.mrku.cms.controller.auth;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.mrku.cms.common.CmsException;
import vn.mrku.cms.common.LoggedUser;
import vn.mrku.cms.controller.auth.dto.LoginDto;
import vn.mrku.cms.controller.auth.dto.TokenDto;

@RestController
public class LoginController {
    @PostMapping(value = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    TokenDto login(@RequestBody LoginDto dto) {
        throw new CmsException("401", "/auth/login should not be called");
    }

    @GetMapping("/auth/me")
    LoggedUser me(@ModelAttribute LoggedUser loggedUser) {
        return loggedUser;
    }
}
