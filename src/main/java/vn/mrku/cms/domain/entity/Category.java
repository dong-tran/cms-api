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
    @SequenceGenerator(sequence = "cms_category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int categoryId;
    String name;
    int orderNumber;
    boolean isAvailable;
    @Column(updatable = false)
    int createdBy;
    @Column(updatable = false)
    LocalDateTime createdAt;
    int updatedBy;
    LocalDateTime updatedAt;
}
