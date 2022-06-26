package vn.mrku.cms.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "cms_user")
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class User {
    @Id
    @SequenceGenerator(sequence = "cms_user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int userId;
    String username;
    String password;
    String fullName;
    int roleType;
    boolean isAvailable;
    @Column(updatable = false)
    int createdBy;
    @Column(updatable = false)
    LocalDateTime createdAt;
    int updatedBy;
    LocalDateTime updatedAt;
    boolean isVerifyEmail;
}
