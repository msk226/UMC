package spring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.umc.apiPayload.ApiResponse;
import spring.umc.converter.UserConverter;
import spring.umc.domain.User;
import spring.umc.service.UserService.UserCommandService;
import spring.umc.web.dto.UserRequestDTO;
import spring.umc.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.joinResultDTO> join(@RequestBody @Valid UserRequestDTO.joinDTO request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }



}
