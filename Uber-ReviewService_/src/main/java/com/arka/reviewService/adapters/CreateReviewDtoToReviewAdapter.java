package com.arka.reviewService.adapters;

import com.arka.reviewService.Models.Review;
import com.arka.reviewService.dto.CreateReviewDto;

public interface CreateReviewDtoToReviewAdapter {
    public Review convertDto(CreateReviewDto createReviewDto);
}
