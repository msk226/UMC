package spring.umc.converter;

import spring.umc.domain.Mission;
import spring.umc.domain.User;
import spring.umc.domain.UserMission;
import spring.umc.domain.enums.MissionStatus;
import spring.umc.web.dto.UserMissionRequestDTO;
import spring.umc.web.dto.UserMissionResponseDTO;
import spring.umc.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class UserMissionConverter {

    public static UserMissionResponseDTO.startMissionResultDTO toUserMissionResponseResultDTO(UserMission userMission){
        return UserMissionResponseDTO.startMissionResultDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserMission toUserMission(User user, Mission mission){
        return UserMission.builder()
                .missionStatus(MissionStatus.ONGOING)
                .user(user)
                .mission(mission)
                .build();
    }
}
