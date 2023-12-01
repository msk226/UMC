package spring.umc.service.ReviewService;

import org.springframework.data.domain.Page;
import spring.umc.domain.Review;
import spring.umc.domain.Store;

import java.util.Optional;

public interface ReviewQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long StoreId, Integer page);
}
