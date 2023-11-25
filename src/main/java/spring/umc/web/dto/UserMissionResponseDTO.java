package spring.umc.web.dto;

import lombok.*;

import java.time.LocalDateTime;

public class UserMissionResponseDTO {

    @Builder @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class startMissionResultDTO{

        private Long userMissionId;

        private LocalDateTime createdAt;
    }
}
