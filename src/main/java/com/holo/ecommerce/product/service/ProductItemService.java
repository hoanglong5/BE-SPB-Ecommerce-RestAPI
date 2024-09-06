package com.holo.ecommerce.product.service;

import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.service.ProductCategoryService;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.entity.ProductItem;
import com.holo.ecommerce.product.entity.VariationOption;
import com.holo.ecommerce.product.service.entityservice.ProductEntityService;
import com.holo.ecommerce.product.service.entityservice.ProductItemEntityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductItemService {
    private final ProductItemEntityService productItemEntityService;
    private final ProductService productService;
    private final VariationOptionService variationOptionService;
    public List<ProductItem> GetAllProduct(){
        return productItemEntityService.GetAllProductItem();
    }
    public ProductItem GetProductItem(Long productItemId){
        return productItemEntityService.GetProductItem(productItemId);
    }
    public ProductItem DeleteProductItem(Long productItemId){
        return productItemEntityService.DeleteProductItem(productItemId);
    }
    public ProductItem CreateProductItem(ProductItem productItemCreating){
        Product product = productService.GetProduct(productItemCreating.getProduct().getId());
        ProductItem productItem = new ProductItem();
        productItem.setProduct(product);
        productItem.setSku(productItemCreating.getSku());
        productItem.setPrice(productItemCreating.getPrice());
        productItem.setQuantity(productItemCreating.getQuantity());
        productItem.setProductItemImage(productItemCreating.getProductItemImage());
        productItem.setVariationOptions(new HashSet<>());
        Set<VariationOption> variationOptions = productItemCreating.getVariationOptions().stream()
                .map(variationOption -> {
                    VariationOption option = new VariationOption();
                    option.setVariation(variationOption.getVariation());
                    option.setValue(variationOption.getValue());
                    return variationOptionService.CreateVariationOption(option);
                }).collect(Collectors.toSet());
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
