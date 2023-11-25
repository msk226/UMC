package spring.umc.service.UserService;

import spring.umc.domain.User;
import spring.umc.web.dto.UserRequestDTO;

import java.lang.reflect.Member;

public interface UserCommandService {

    User joinUser(UserRequestDTO.joinDTO request);

}
