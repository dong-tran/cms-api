package vn.mrku.cms.controller.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "User")
public class UserDetailDto {
    int userId;
    String username;
    String fullName;
    int roleType;
}
