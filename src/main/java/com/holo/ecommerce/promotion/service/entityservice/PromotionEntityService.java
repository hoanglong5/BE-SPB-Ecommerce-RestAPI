package com.holo.ecommerce.promotion.service.entityservice;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.promotion.entity.Promotion;
import com.holo.ecommerce.promotion.enums.PromotionExceptionResponse;
import com.holo.ecommerce.promotion.repository.PromotionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PromotionEntityService extends BaseService<Promotion, PromotionRepository> {
    public PromotionEntityService(PromotionRepository dao) {
        super(dao);
    }
    public List<Promotion> GetAllPromotion(){
        return getDao().findAll();
    }
    public Promotion GetPromotion(Long promotionId){
        return getDao().findById(promotionId).orElseThrow(() -> new ItemNotFoundException(PromotionExceptionResponse.PROMOTION_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public Promotion DeletePromotion(Long promotionId){
        Promotion promotion = getDao().findById(promotionId).orElseThrow(()-> new ItemNotFoundException(PromotionExceptionResponse.PROMOTION_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
        getDao().deleteById(promotionId);
        return promotion;
    }
    public Promotion SavePromotion(Promotion promotionSaving){
        return getDao().save(promotionSaving);
    }
}
