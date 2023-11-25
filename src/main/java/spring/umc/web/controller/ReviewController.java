package spring.umc.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.umc.apiPayload.ApiResponse;
import spring.umc.converter.ReviewConverter;
import spring.umc.domain.Review;
import spring.umc.service.ReviewService.ReviewCommandService;
import spring.umc.web.dto.ReviewRequestDTO;
import spring.umc.web.dto.ReviewResponseDTO;
@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    @PostMapping("/{store_id}/user/{user_id}/review")
    public ApiResponse<ReviewResponseDTO.makeReviewResultDTO> makeReview(@RequestBody @Valid ReviewRequestDTO.makeReviewDTO request,
                                                                         @PathVariable Long user_id,
                                                                         @PathVariable Long store_id ){
        Review review = reviewCommandService.makeReview(request, user_id, store_id);
        return ApiResponse.onSuccess(ReviewConverter.toMakeReviewResultDTO(review));
    }

}

