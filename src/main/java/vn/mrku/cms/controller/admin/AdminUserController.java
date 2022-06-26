package vn.mrku.cms.controller.admin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.mrku.cms.controller.admin.dto.UserCreateDto;
import vn.mrku.cms.controller.admin.dto.UserDetailDto;
import vn.mrku.cms.controller.admin.dto.UserPasswordDto;
import vn.mrku.cms.controller.admin.dto.UserUpdateDto;

@RestController
@RequestMapping("/admin/user")
//@PreAuthorize("hasAuthority('SCOPE_ROOT')")
public class AdminUserController {
    @GetMapping
    Page<UserDetailDto> list(Pageable page) {
        return null;
    }

    @PostMapping
    UserDetailDto create(@RequestBody @Validated UserCreateDto dto) {
        return null;
    }

    @PutMapping
    UserDetailDto update(@RequestBody @Validated UserUpdateDto dto) {
        return null;
    }

    @PutMapping("/password")
    UserDetailDto changePass(@RequestBody @Validated UserPasswordDto dto) {
        return null;
    }

    @PutMapping("/reset")
    UserDetailDto resetPass(@RequestBody @Validated UserPasswordDto dto) {
        return null;
    }
}
