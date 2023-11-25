package spring.umc.web.dto;

import lombok.Getter;
import spring.umc.domain.enums.MissionStatus;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class makeMissionDTO{

        MissionStatus missionStatus;
        Integer point;
        String missionSpec;
        LocalDate deadline;

    }
}
