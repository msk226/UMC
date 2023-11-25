package spring.umc.service.ReviewService;

import org.springframework.transaction.annotation.Transactional;
import spring.umc.domain.Review;
import spring.umc.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review makeReview(ReviewRequestDTO.makeReviewDTO request, Long userId, Long storeId);

}
