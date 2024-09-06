package com.holo.ecommerce.promotion.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.promotion.entity.Promotion;
import com.holo.ecommerce.promotion.enums.PromotionMessageResponse;
import com.holo.ecommerce.promotion.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promotion")
@RequiredArgsConstructor
public class PromotionController {
    private final PromotionService promotionService;
    @GetMapping
    public ResponseEntity<RestResponse<List<Promotion>>> GetAllPromotion(){
        RestResponse<List<Promotion>> response = RestResponse.of(promotionService.GetAllPromotion());
        response.setMessages(PromotionMessageResponse.SUCCESSFULLY_FIND_ALL_PROMOTION.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{promotionId}")
    public ResponseEntity<RestResponse<Promotion>> GetPromotion(@PathVariable Long promotionId){
        RestResponse<Promotion> response = RestResponse.of(promotionService.GetPromotion(promotionId));
        response.setMessages(PromotionMessageResponse.SUCCESSFULLY_FIND_PROMOTION_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{promotionId}")
    public ResponseEntity<RestResponse<Promotion>> DeletePromotion(@PathVariable Long promotionId){
        RestResponse<Promotion> response = RestResponse.of(promotionService.DeletePromotion(promotionId));
        response.setMessages(PromotionMessageResponse.SUCCESSFULLY_DELETE_PROMOTION.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping()
    public ResponseEntity<RestResponse<Promotion>> CreatePromotion(@RequestBody Promotion promotionCreating) {
        RestResponse<Promotion> response = RestResponse.of(promotionService.CreatePromotion(promotionCreating));
        response.setMessages(PromotionMessageResponse.SUCCESSFULLY_CREATED_PROMOTION.getMessage());
        return ResponseEntity.ok(response);
    }
}
