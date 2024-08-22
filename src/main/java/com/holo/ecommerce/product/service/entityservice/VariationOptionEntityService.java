package com.holo.ecommerce.product.service.entityservice;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.product.entity.Variation;
import com.holo.ecommerce.product.entity.VariationOption;
import com.holo.ecommerce.product.enums.ProductExceptionResponse;
import com.holo.ecommerce.product.repository.VariationOptionRepository;
import com.holo.ecommerce.product.service.VariationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariationOptionEntityService extends BaseService<VariationOption, VariationOptionRepository> {
    public VariationOptionEntityService(VariationOptionRepository dao) {
        super(dao);
    }
    public List<VariationOption> GetAllVariationOption(){
        return getDao().findAll();
    }
    public VariationOption GetVariationOption(Long variationOptionId){
        return getDao().findById(variationOptionId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.VARIATION_OPTION_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }

    public VariationOption DeleteVariationOption(Long variationOptionId){
        getDao().deleteById(variationOptionId);
        VariationOption variation = getDao().findById(variationOptionId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.VARIATION_OPTION_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
        return variation;
    }

    public VariationOption SaveVariationOption(VariationOption variationOption){
        return getDao().save(variationOption);
    }
}
