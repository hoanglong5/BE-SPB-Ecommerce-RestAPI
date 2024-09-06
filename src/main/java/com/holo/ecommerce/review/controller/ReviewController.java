package com.holo.ecommerce.review.controller;


import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.review.entity.Review;
import com.holo.ecommerce.review.enums.ReviewMessageResponse;
import com.holo.ecommerce.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping
    public ResponseEntity<RestResponse<List<Review>>> GetAllReviews(){
        RestResponse<List<Review>> response = RestResponse.of(reviewService.GetAllReview());
        response.setMessages(ReviewMessageResponse.SUCCESSFULLY_FIND_ALL_REVIEW.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<RestResponse<Review>> GetReviewsById(Long reviewId){
        RestResponse<Review> response = RestResponse.of(reviewService.GetReviewById(reviewId));
        response.setMessages(ReviewMessageResponse.SUCCESSFULLY_FIND_REVIEW_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<RestResponse<Review>> DeleteReviews(Long reviewId){
        RestResponse<Review> response = RestResponse.of(reviewService.DeleteReview(reviewId));
        response.setMessages(ReviewMessageResponse.SUCCESSFULLY_FIND_REVIEW_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<Review>> CreateReviews(Review review){
        RestResponse<Review> response = RestResponse.of(reviewService.CreatingReview(review));
        response.setMessages(ReviewMessageResponse.SUCCESSFULLY_CREATED_REVIEW.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{reviewId}")
    public ResponseEntity<RestResponse<Review>> CreateReviews(Review review,Long reviewId){
        RestResponse<Review> response = RestResponse.of(reviewService.UpdateReview(reviewId,review));
        response.setMessages(ReviewMessageResponse.SUCCESSFULLY_UPDATED_REVIEW.getMessage());
        return ResponseEntity.ok(response);
    }
}
