package vn.mrku.cms.common;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Getter
@Setter
@Hidden
public class UserDetail extends User implements UserDetails {
    public UserDetail(int userId, int roleType, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.roleType = roleType;
    }

    int userId;
    int roleType;
}
