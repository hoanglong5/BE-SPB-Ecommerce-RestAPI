package com.holo.ecommerce.product.service.entityservice;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.product.entity.Variation;
import com.holo.ecommerce.product.enums.ProductExceptionResponse;
import com.holo.ecommerce.product.repository.VariationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariationEntityService extends BaseService<Variation, VariationRepository> {
    public VariationEntityService(VariationRepository dao) {
        super(dao);
    }
    public List<Variation> GetAllVariation(){
        return getDao().findAll();
    }
    public Variation GetVariation(Long variationId){
        return getDao().findById(variationId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.VARIATION_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }

    public Variation DeleteVariation(Long variationId){
        getDao().deleteById(variationId);
        Variation variation = getDao().findById(variationId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.VARIATION_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
        return variation;
    }

    public Variation SaveVariation(Variation productSaving){
        return getDao().save(productSaving);
    }
}
