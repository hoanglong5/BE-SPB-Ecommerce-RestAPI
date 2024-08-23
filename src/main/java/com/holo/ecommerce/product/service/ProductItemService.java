package com.holo.ecommerce.product.service;

import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.service.ProductCategoryService;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.entity.ProductItem;
import com.holo.ecommerce.product.service.entityservice.ProductEntityService;
import com.holo.ecommerce.product.service.entityservice.ProductItemEntityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductItemService {
    private final ProductItemEntityService productItemEntityService;
    private final ProductService productService;
    public List<ProductItem> GetAllProduct(){
        return productItemEntityService.GetAllProductItem();
    }
    public ProductItem GetProduct(Long productItemId){
        return productItemEntityService.GetProductItem(productItemId);
    }
    public ProductItem DeleteProduct(Long productItemId){
        return productItemEntityService.DeleteProductItem(productItemId);
    }
    public ProductItem CreateProduct(ProductItem productItem){
        return productItemEntityService.SaveProductItem(productItem);
    }
    public ProductItem UpdateProductItem(ProductItem productItemUpdating,Long productItemId){
        Product product = productService.GetProduct(productItemUpdating.getProduct().getId());
        ProductItem productItem = productItemEntityService.GetProductItem(productItemId);
        productItem.setSku(productItemUpdating.getSku());
        productItem.setPrice(productItemUpdating.getPrice());
        productItem.setQuantity(productItemUpdating.getQuantity());
        productItem.setProductItemImage(productItemUpdating.getProductItemImage());
        productItem.setProduct(product);
        return productItemEntityService.SaveProductItem(productItem);
    }
}
