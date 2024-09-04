package com.holo.ecommerce.product.service;

import com.holo.ecommerce.product.entity.Variation;
import com.holo.ecommerce.product.entity.VariationOption;
import com.holo.ecommerce.product.service.entityservice.VariationEntityService;
import com.holo.ecommerce.product.service.entityservice.VariationOptionEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VariationOptionService {
    private final VariationOptionEntityService optionEntityService;
    private final VariationService variationService;
    public List<VariationOption> GetAllVariationOption(){
        return optionEntityService.GetAllVariationOption();
    }
    public VariationOption GetVariationOption(Long variationOptionId){
        return optionEntityService.GetVariationOption(variationOptionId);
    }
    public VariationOption CreateVariationOption(VariationOption variationOptionCreating){
        //TEST
        Variation variation = variationService.GetVariation(variationOptionCreating.getVariation().getId());
        VariationOption variationOption = new VariationOption();
        variationOption.setVariation(variation);
        variationOption.setValue(variationOptionCreating.getValue());
        return optionEntityService.SaveVariationOption(variationOption);
    }
    public VariationOption UpdateVariationOption(VariationOption variationOptionUpdating,Long variationOptionId){
        VariationOption variationOption = optionEntityService.GetVariationOption(variationOptionId);
        Variation variation = variationService.GetVariation(variationOptionUpdating.getVariation().getId());
        variationOption.setValue(variationOptionUpdating.getValue());
        variationOption.setVariation(variation);
        return optionEntityService.SaveVariationOption(variationOption);
    }
    public VariationOption DeleteVariationOption(Long variationOption){
        return optionEntityService.DeleteVariationOption(variationOption);
    }
}
