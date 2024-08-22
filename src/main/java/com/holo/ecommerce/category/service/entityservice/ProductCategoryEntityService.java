package com.holo.ecommerce.category.service.entityservice;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.enums.CategoryExceptionResponse;
import com.holo.ecommerce.category.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryEntityService extends BaseService<ProductCategory, ProductCategoryRepository> {
    public ProductCategoryEntityService(ProductCategoryRepository dao) {
        super(dao);
    }
    public List<ProductCategory> GetAllProductCategory(){
        return getDao().findAll();
    }
    public ProductCategory GetProductCategory(Long categoryId){
        return getDao().findById(categoryId).orElseThrow(() -> new ItemNotFoundException(CategoryExceptionResponse.CATEGORY_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }
    public ProductCategory DeleteProductCategory(Long categoryId){
        ProductCategory category = getDao().findById(categoryId).orElseThrow(()-> new ItemNotFoundException(CategoryExceptionResponse.CATEGORY_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
        getDao().deleteById(categoryId);
        return category;
    }
    public ProductCategory SaveProductCategory(ProductCategory categorySaving){
        return getDao().save(categorySaving);
    }
}
