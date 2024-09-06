package com.holo.ecommerce.review.service.ReviewEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.review.entity.Review;
import com.holo.ecommerce.review.enums.ReviewExceptionResponse;
import com.holo.ecommerce.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewEntityService extends BaseService<Review,ReviewRepository> {
    public ReviewEntityService(ReviewRepository dao) {
        super(dao);
    }
    public List<Review> GetAllReview() {
        return getDao().findAll();
    }
    public Review GetReviewById(Long reviewId){
        return getDao().findById(reviewId).orElseThrow(() -> new ItemNotFoundException(ReviewExceptionResponse.REVIEW_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public Review SaveReview(Review review){
        return getDao().save(review);
    }
    public Review DeleteReview(Long reviewId){
        Review review = GetReviewById(reviewId);
        getDao().deleteById(reviewId);
        return review;
    }
}
