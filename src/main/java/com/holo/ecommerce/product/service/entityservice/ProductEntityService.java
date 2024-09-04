package com.holo.ecommerce.product.service.entityservice;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.service.ProductCategoryService;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.enums.ProductExceptionResponse;
import com.holo.ecommerce.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductEntityService extends BaseService<Product, ProductRepository> {
    public ProductEntityService(ProductRepository dao) {
        super(dao);
    }
    public List<Product> GetAllProduct(){
        return getDao().findAll();
    }
    public List<Product> GetAllProductById(Set<Long> ids ){
        return getDao().findAllById(ids);
    }
    public Product GetProduct(Long productId){
        return getDao().findById(productId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.PRODUCT_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
    }

    public Product DeleteProduct(Long productId){
        getDao().deleteById(productId);
        Product product = getDao().findById(productId).orElseThrow(() -> new ItemNotFoundException(ProductExceptionResponse.PRODUCT_EXCEPTION_RESPONSE_NOT_FOUND.getMessage()));
        return product;
    }

    public Product SaveProduct(Product productCreating){
        return getDao().save(productCreating);
    }
}
