package spring.umc.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc.apiPayload.code.status.ErrorStatus;
import spring.umc.apiPayload.exception.handler.ReviewHandler;
import spring.umc.apiPayload.exception.handler.UserMissionHandler;
import spring.umc.converter.UserMissionConverter;
import spring.umc.domain.Mission;
import spring.umc.domain.Store;
import spring.umc.domain.User;
import spring.umc.domain.UserMission;
import spring.umc.repository.MissionRepository;
import spring.umc.repository.UserMissionRepository;
import spring.umc.repository.UserRepository;
import spring.umc.web.dto.UserMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;
    @Override
    @Transactional
    public UserMission startMission(UserMissionRequestDTO.startMissionDTO request, Long user_id, Long mission_id) {
        User user = userRepository.findById(user_id).orElseThrow(() -> new UserMissionHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(mission_id).orElseThrow(() -> new UserMissionHandler(ErrorStatus._BAD_REQUEST));
        UserMission newUserMission = UserMissionConverter.toUserMission(user, mission);
        user.addUserMission(newUserMission);
        mission.addUserMission(newUserMission);
        return userMissionRepository.save(newUserMission);
    }
}
