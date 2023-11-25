package spring.umc.web.dto;

import lombok.Getter;
import spring.umc.domain.Address;
import spring.umc.domain.enums.Gender;
import spring.umc.validation.annotation.ExistCategories;

import java.time.LocalDateTime;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class joinDTO{
        String name;
        Gender gender;
        LocalDateTime birth;
        String email;
        String phone;
        Address address;
        @ExistCategories
        List<Long> preferCategory;

    }
}
