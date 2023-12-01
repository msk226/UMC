package spring.umc.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import spring.umc.apiPayload.ApiResponse;
import spring.umc.converter.ReviewConverter;
import spring.umc.domain.Review;
import spring.umc.service.ReviewService.ReviewCommandService;
import spring.umc.service.ReviewService.ReviewQueryService;
import spring.umc.web.dto.ReviewRequestDTO;
import spring.umc.web.dto.ReviewResponseDTO;
@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;
    @PostMapping("/{store_id}/user/{user_id}/review")
    public ApiResponse<ReviewResponseDTO.makeReviewResultDTO> makeReview(@RequestBody @Valid ReviewRequestDTO.makeReviewDTO request,
                                                                         @PathVariable Long user_id,
                                                                         @PathVariable Long store_id ){
        Review review = reviewCommandService.makeReview(request, user_id, store_id);
        return ApiResponse.onSuccess(ReviewConverter.toMakeReviewResultDTO(review));
    }

    @PostMapping("/{store_id}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "store_id", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<ReviewResponseDTO.reviewPreviewListDTO> getReviewList(@PathVariable Long store_id,
                                                                             @RequestParam(name = "page") Integer page){
        Page<Review> reviews = reviewQueryService.getReviewList(store_id, page);

        return ApiResponse.onSuccess(ReviewConverter.reviewPreviewListDTO(reviews));
    }

}

