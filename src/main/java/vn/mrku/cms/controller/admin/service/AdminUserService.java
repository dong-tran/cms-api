package vn.mrku.cms.controller.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.mrku.cms.controller.admin.dto.UserDetailDto;
import vn.mrku.cms.domain.entity.User;
import vn.mrku.cms.domain.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminUserService {
    private final UserRepository userRepository;

    List<UserDetailDto> findActiveUsers() {
        return null;
    }

    User findById(int userId) {
        return userRepository.findById(userId);
    }
}
