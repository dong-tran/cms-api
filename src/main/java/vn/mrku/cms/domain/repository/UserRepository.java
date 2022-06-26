package vn.mrku.cms.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import vn.mrku.cms.domain.entity.User;

import java.util.Optional;

@Dao
@ConfigAutowireable
public interface UserRepository {
    @Select
    User findById(int userId);

    @Select
    Optional<User> findByUsername(String username);
}
