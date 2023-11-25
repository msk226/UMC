package spring.umc.converter;

import spring.umc.domain.User;
import spring.umc.web.dto.UserRequestDTO;
import spring.umc.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.joinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.joinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.joinDTO request){

        return User.builder()
                .name(request.getName())
                .gender(request.getGender())
                .birth(request.getBirth())
                .email(request.getEmail())
                .phone(request.getPhone())
                .address(request.getAddress())
                .userPreferList(new ArrayList<>())
                .build();
    }

}
