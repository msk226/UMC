package spring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.umc.apiPayload.ApiResponse;
import spring.umc.converter.UserConverter;
import spring.umc.converter.UserMissionConverter;
import spring.umc.domain.UserMission;
import spring.umc.service.UserMissionService.UserMissionCommandService;
import spring.umc.web.dto.UserMissionRequestDTO;
import spring.umc.web.dto.UserMissionResponseDTO;
import spring.umc.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class UserMissionController {

    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/user/{user_id}/mission/{mission_id}")
    public ApiResponse<UserMissionResponseDTO.startMissionResultDTO> startMission(@RequestBody @Valid UserMissionRequestDTO.startMissionDTO request,
                                                    @PathVariable Long user_id,
                                                    @PathVariable Long mission_id){
        UserMission userMission = userMissionCommandService.startMission(request, user_id, mission_id);
        return ApiResponse.onSuccess(UserMissionConverter.toUserMissionResponseResultDTO(userMission));
    }
}
