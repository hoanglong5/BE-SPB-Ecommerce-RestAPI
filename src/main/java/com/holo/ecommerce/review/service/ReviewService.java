package com.holo.ecommerce.review.service;

import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.service.UserService;
import com.holo.ecommerce.order.entity.OrderLine;
import com.holo.ecommerce.order.service.OrderLineService;
import com.holo.ecommerce.review.entity.Review;
import com.holo.ecommerce.review.service.ReviewEntityService.ReviewEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewEntityService reviewEntityService;
    private final OrderLineService orderLineService;
    private final UserService userService;

    public Review GetReviewById(Long reviewId){
        return reviewEntityService.GetReviewById(reviewId);
    }
    public List<Review> GetAllReview(){
        return reviewEntityService.GetAllReview();
    }
    @Transactional
    public Review DeleteReview(Long reviewId){
        return reviewEntityService.DeleteReview(reviewId);
    }
    @Transactional
    public Review CreatingReview(Review reviewCreating){
        User user = userService.GetUser(reviewCreating.getUser().getId());
        OrderLine orderLine = orderLineService.GetOrderLineById(reviewCreating.getOrderLine().getId());
        return reviewEntityService.SaveReview(reviewCreating);
    }
    @Transactional
    public Review UpdateReview(Long reviewId,Review reviewUpdating){
        Review review = reviewEntityService.GetReviewById(reviewId);
        OrderLine orderLine = orderLineService.GetOrderLineById(reviewUpdating.getOrderLine().getId());
        review.setComment(reviewUpdating.getComment());
        review.setRatingValue(reviewUpdating.getRatingValue());
        return reviewEntityService.SaveReview(review);
    }
}
