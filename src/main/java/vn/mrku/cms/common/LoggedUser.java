package vn.mrku.cms.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoggedUser {
    int userId;
    String username;
    int roleType;
}
