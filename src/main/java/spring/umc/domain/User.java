package spring.umc.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.umc.domain.base.BaseEntity;
import spring.umc.domain.enums.Gender;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Date birth;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 15)
    private String phone;

    @Embedded
    private Address address;

    private Integer point;

    @Column(nullable = false, length = 15)
    private String status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserMission> userMissions;

    private LocalDate inactivatedAt;

}

