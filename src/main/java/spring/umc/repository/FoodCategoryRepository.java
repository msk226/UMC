package spring.umc.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.umc.apiPayload.ApiResponse;
import spring.umc.converter.ReviewConverter;
import spring.umc.domain.FoodCategory;
import spring.umc.domain.Review;
import spring.umc.service.ReviewService.ReviewCommandService;
import spring.umc.web.dto.ReviewRequestDTO;
import spring.umc.web.dto.ReviewResponseDTO;


public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

}
