package vn.mrku.cms.controller.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "LoginRequest")
public class LoginDto {
    @Schema(required = true, name = "username", description = "Email")
    String username;
    @Schema(required = true, name = "password", description = "Password")
    String password;
}
