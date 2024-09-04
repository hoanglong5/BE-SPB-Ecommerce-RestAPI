package com.holo.ecommerce.product.service;

import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.service.ProductCategoryService;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.service.entityservice.ProductEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductEntityService productEntityService;
    private final ProductCategoryService productCategoryService;
    public List<Product> GetAllProduct(){
        return productEntityService.GetAllProduct();
    }
    public Product GetProduct(Long productId){
        return productEntityService.GetProduct(productId);
    }
    public Product DeleteProduct(Long productId){
        return productEntityService.DeleteProduct(productId);
    }
    public Product CreateProduct(Product productCreating){
        ProductCategory category = productCategoryService.GetProductCategory(productCreating.getCategory().getId());
        return productEntityService.SaveProduct(productCreating);
    }
    public Product UpdateProduct(Product productUpdating, Long productId){
        Product product = productEntityService.GetProduct(productId);
        ProductCategory productCategory = productCategoryService.GetProductCategory(productUpdating.getCategory().getId());
        product.setName(productUpdating.getName());
        product.setDescription(productUpdating.getDescription());
        product.setProductImage(productUpdating.getProductImage());
        product.setCategory(productCategory);
        return productEntityService.SaveProduct(product);
    }
}
