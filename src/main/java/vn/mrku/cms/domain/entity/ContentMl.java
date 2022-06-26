package vn.mrku.cms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Getter
@Setter
@Table(name = "cms_content_ml")
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class ContentMl {
    @Id
    int contentId;
    @Id
    String languageCode;
    String title;
    String content;
}
