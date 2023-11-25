package spring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.umc.apiPayload.ApiResponse;
import spring.umc.converter.MissionConverter;
import spring.umc.domain.Mission;
import spring.umc.service.MissionService.MissionCommandService;
import spring.umc.web.dto.MissionRequestDTO;
import spring.umc.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/store/{store_id}/mission")
    public ApiResponse<MissionResponseDTO.makeMissionResultDTO> makeMission(@RequestBody @Valid MissionRequestDTO.makeMissionDTO request,
                                                                            @PathVariable Long store_id){
        Mission mission = missionCommandService.makeMission(request, store_id);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDTO(mission));
    }
}
