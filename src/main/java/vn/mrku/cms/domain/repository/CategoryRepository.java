package vn.mrku.cms.domain.repository;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import vn.mrku.cms.domain.dto.CategoryDto;
import vn.mrku.cms.domain.entity.Category;

import java.util.List;

@Dao
@ConfigAutowireable
public interface CategoryRepository {

    @Select
    List<CategoryDto> findAll();

    @Insert
    int insert(Category category);

    @Insert
    int update(Category category);
}
