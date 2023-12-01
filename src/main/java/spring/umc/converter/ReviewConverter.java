package spring.umc.converter;

import org.springframework.data.domain.Page;
import spring.umc.domain.Review;
import spring.umc.domain.Store;
import spring.umc.domain.User;
import spring.umc.web.dto.ReviewRequestDTO;
import spring.umc.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static ReviewResponseDTO.reviewPreviewDTO reviewPreviewDTO(Review review){
        return ReviewResponseDTO.reviewPreviewDTO.builder()
                .nickname(review.getUser().getName())
                .text(review.getText())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static ReviewResponseDTO.reviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviews){
        List<ReviewResponseDTO.reviewPreviewDTO> reviewPreviewDTOList = reviews.stream().map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());
        return ReviewResponseDTO.reviewPreviewListDTO.builder()
                .isLast(reviews.isLast())
                .isFirst(reviews.isFirst())
                .totalPage(reviews.getTotalPages())
                .listSize(reviewPreviewDTOList.size())
                .totalElements(reviews.getTotalElements())
                .reviewList(reviewPreviewDTOList)
                .build();
    }


}
