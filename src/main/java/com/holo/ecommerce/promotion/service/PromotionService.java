package com.holo.ecommerce.promotion.service;

import com.holo.ecommerce.promotion.entity.Promotion;
import com.holo.ecommerce.promotion.service.entityservice.PromotionEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromotionService {
    private final PromotionEntityService promotionEntityService;
    public List<Promotion> GetAllPromotion(){
        return promotionEntityService.GetAllPromotion();
    }
    public Promotion GetPromotion(Long promotionId){
        return promotionEntityService.GetPromotion(promotionId);
    }
    @Transactional
    public Promotion CreatePromotion(Promotion promotionCreating){
        return promotionEntityService.SavePromotion(promotionCreating);
    }
    @Transactional
    public Promotion DeletePromotion(Long promotionId){
        return promotionEntityService.DeletePromotion(promotionId);
    }
}
