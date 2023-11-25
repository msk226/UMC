package spring.umc.service.UserMissionService;

import spring.umc.domain.UserMission;
import spring.umc.web.dto.UserMissionRequestDTO;

public interface UserMissionCommandService {

    UserMission startMission(UserMissionRequestDTO.startMissionDTO request, Long user_id, Long mission_id);
}
