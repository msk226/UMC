package spring.umc.service.MissionService;

import spring.umc.domain.Mission;
import spring.umc.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Mission makeMission(MissionRequestDTO.makeMissionDTO request, Long storeId);
}
