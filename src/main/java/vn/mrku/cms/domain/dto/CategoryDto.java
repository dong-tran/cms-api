package vn.mrku.cms.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;

@Getter
@Setter
@Entity
public class CategoryDto {
    int categoryId;
    Integer parentId;
    String name;
    int orderNumber;
    boolean isAvailable;
    String languageCode;
    String header;
    String title;
    String text;
}
