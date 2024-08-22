package com.holo.ecommerce.category.service;

import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.service.entityservice.ProductCategoryEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryEntityService categoryEntityService;

    public ProductCategory GetProductCategory(Long categoryId){
        return categoryEntityService.GetProductCategory(categoryId);
    }
    public List<ProductCategory> GetAllCategory(){
        return categoryEntityService.GetAllProductCategory();
    }
    @Transactional
    public ProductCategory CreateCategory(ProductCategory categorySaving){
        return categoryEntityService.SaveProductCategory(categorySaving);
    }
    @Transactional
    public ProductCategory DeleteCategory(Long categoryId){
        return categoryEntityService.DeleteProductCategory(categoryId);
    }
}
