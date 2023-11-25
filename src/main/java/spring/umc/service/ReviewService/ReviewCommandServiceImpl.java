package spring.umc.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc.apiPayload.code.status.ErrorStatus;
import spring.umc.apiPayload.exception.handler.ReviewHandler;
import spring.umc.apiPayload.repository.ReviewRepository;
import spring.umc.apiPayload.repository.StoreRepository;
import spring.umc.apiPayload.repository.UserRepository;
import spring.umc.converter.ReviewConverter;
import spring.umc.domain.Review;
import spring.umc.domain.Store;
import spring.umc.domain.User;
import spring.umc.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review makeReview(ReviewRequestDTO.makeReviewDTO request, Long userId, Long storeId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ReviewHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new ReviewHandler(ErrorStatus._BAD_REQUEST));
        Review newReview = ReviewConverter.toReview(request, user, store);
        return reviewRepository.save(newReview);

    }
}
