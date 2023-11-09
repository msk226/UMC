package spring.umc.domain;

import jakarta.persistence.*;
import lombok.*;
import spring.umc.domain.base.BaseEntity;
import spring.umc.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mission_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;

    private Integer point;

    @Column(nullable = false)
    private String MissionSpec;

    @Column(nullable = false)
    private LocalDate deadline;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<UserMission> userMissions;



}
