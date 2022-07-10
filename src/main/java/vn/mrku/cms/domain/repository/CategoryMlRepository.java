package vn.mrku.cms.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import vn.mrku.cms.domain.entity.CategoryMl;

@Dao
@ConfigAutowireable
public interface CategoryMlRepository {
    @Insert
    int insert(CategoryMl categoryMl);

    @Update
    int update(CategoryMl categoryMl);
}
