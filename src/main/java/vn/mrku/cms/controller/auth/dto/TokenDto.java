package vn.mrku.cms.controller.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "TokenResponse")
public class TokenDto {
    String tokenType;
    String token;
    String role;
}
