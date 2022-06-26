package vn.mrku.cms.controller.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "UserUpdate")
public class UserUpdateDto {
    int userId;
    String fullName;
}
