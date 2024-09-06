package com.holo.ecommerce.product.service;

import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.service.ProductCategoryService;
import com.holo.ecommerce.product.entity.Variation;
import com.holo.ecommerce.product.service.entityservice.VariationEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VariationService {
    private final VariationEntityService variationEntityService;
    private final ProductCategoryService categoryService;
    public List<Variation> GetAllVariation(){
        return variationEntityService.GetAllVariation();
    }
    public Variation GetVariation(Long variationId){
        return variationEntityService.GetVariation(variationId);
    }
    public Variation DeleteVariation(Long variationId){
        return variationEntityService.DeleteVariation(variationId);
    }
    public Variation CreateVariation(Variation variationCreating){
        ProductCategory productCategory = categoryService.GetProductCategory(variationCreating.getCategory().getId());
        return variationEntityService.SaveVariation(variationCreating);
    }
    public Variation UpdateVariation(Long variationId,Variation variationUpdating){
        ProductCategory productCategory = categoryService.GetProductCategory(variationUpdating.getCategory().getId());
        Variation variation = variationEntityService.GetVariation(variationId);
        variation.setCategory(productCategory);
        variation.setName(variationUpdating.getName());
        return variationEntityService.SaveVariation(variation);
    }
}
