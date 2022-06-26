package vn.mrku.cms.controller.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Schema(name = "UserCreate")
public class UserCreateDto {
    @NotNull
    String username;
    @NotNull
    String fullName;
    @NotNull
    String password;
}
