package spring.umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc.domain.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
