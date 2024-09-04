package com.holo.ecommerce.category.service;

import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.service.entityservice.ProductCategoryEntityService;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.service.ProductService;
import com.holo.ecommerce.promotion.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductCategoryService {
    private final ProductCategoryEntityService categoryEntityService;
    private final PromotionService promotionService;

    public ProductCategory GetProductCategory(Long categoryId){
        return categoryEntityService.GetProductCategory(categoryId);
    }
    public List<ProductCategory> GetAllCategory(){
        return categoryEntityService.GetAllProductCategory();
    }
    @Transactional
    public ProductCategory CreateCategory(ProductCategory categoryCreating){
        ProductCategory productCategory = new ProductCategory();
        ProductCategory category = categoryEntityService.GetProductCategory(categoryCreating.getParentCategory().getId());
        //create
        productCategory.setCategoryName(categoryCreating.getCategoryName());
        productCategory.setParentCategory(category);
        //FIX : add promotion
        return categoryEntityService.SaveProductCategory(categoryCreating);
    }
    @Transactional
    public ProductCategory UpdateCategory(ProductCategory categoryUpdating,Long categoryId){
        ProductCategory productCategory =  categoryEntityService.GetProductCategory(categoryId);
        ProductCategory category = categoryEntityService.GetProductCategory(categoryUpdating.getParentCategory().getId());
        productCategory.setCategoryName(categoryUpdating.getCategoryName());
        productCategory.setParentCategory(category);
        //FIX : add promotion
        return categoryEntityService.SaveProductCategory(productCategory);
    }
    @Transactional
    public ProductCategory DeleteCategory(Long categoryId){
        return categoryEntityService.DeleteProductCategory(categoryId);
    }
}
