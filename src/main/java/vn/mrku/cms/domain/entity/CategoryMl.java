package vn.mrku.cms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Getter
@Setter
@Table(name = "cms_category_ml")
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class CategoryMl {
    @Id
    int categoryId;
    @Id
    String languageCode;
    String display;
}
