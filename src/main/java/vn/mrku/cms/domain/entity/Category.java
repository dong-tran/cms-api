package vn.mrku.cms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "cms_category")
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;
    Integer parentId;
    String name;
    int orderNumber;
    boolean isAvailable;
    boolean isPublic;
    @Column(updatable = false)
    int createdBy;
    @Column(updatable = false)
    LocalDateTime createdAt;
    int updatedBy;
    LocalDateTime updatedAt;
}
