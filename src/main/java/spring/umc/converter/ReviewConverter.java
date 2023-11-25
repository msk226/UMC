package spring.umc.converter;

import spring.umc.domain.Review;
import spring.umc.domain.Store;
import spring.umc.domain.User;
import spring.umc.web.dto.ReviewRequestDTO;
import spring.umc.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.makeReviewResultDTO toMakeReviewResultDTO(Review review){
        return ReviewResponseDTO.makeReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }



    public static Review toReview(ReviewRequestDTO.makeReviewDTO request, User user, Store store){
        return Review.builder()
                .rate(request.getRate())
                .text(request.getText())
                .user(user)
                .store(store)
                .build();
    }


}
