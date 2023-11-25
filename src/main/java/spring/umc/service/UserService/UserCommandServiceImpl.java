package spring.umc.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc.apiPayload.code.status.ErrorStatus;
import spring.umc.apiPayload.exception.handler.FoodCategoryHandler;
import spring.umc.apiPayload.repository.FoodCategoryRepository;
import spring.umc.apiPayload.repository.UserRepository;
import spring.umc.converter.UserConverter;
import spring.umc.converter.UserPreferConverter;
import spring.umc.domain.FoodCategory;
import spring.umc.domain.User;
import spring.umc.domain.mapping.UserPrefer;
import spring.umc.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.joinDTO request) {
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);

        userPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
