package spring.umc.converter;

import spring.umc.domain.Mission;
import spring.umc.domain.Store;
import spring.umc.web.dto.MissionRequestDTO;
import spring.umc.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO.makeMissionDTO request, Store store){
        return Mission.builder()
                .missionStatus(request.getMissionStatus())
                .MissionSpec(request.getMissionSpec())
                .point(request.getPoint())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.makeMissionResultDTO toMissionResultDTO(Mission mission){
        return MissionResponseDTO.makeMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
