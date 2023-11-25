package spring.umc.apiPayload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
