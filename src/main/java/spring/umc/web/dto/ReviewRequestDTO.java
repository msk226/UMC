package spring.umc.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class makeReviewDTO{
        String text;
        float rate;
    }
}
