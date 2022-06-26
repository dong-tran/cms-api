package vn.mrku.cms.common;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.mrku.cms.domain.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    private static final Map<Integer, List<GrantedAuthority>> ROLE_MAP = new HashMap<>();

    static {
        ROLE_MAP.put(1, AuthorityUtils.createAuthorityList("ROOT"));
        ROLE_MAP.put(2, AuthorityUtils.createAuthorityList("ADMIN"));
    }

    @Override
    public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        return user.map(it -> new UserDetail(it.getUserId(), it.getRoleType(), it.getUsername(), it.getPassword(), ROLE_MAP.get(it.getRoleType()))).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
