package com.holo.ecommerce.product.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.entity.ProductItem;
import com.holo.ecommerce.product.enums.ProductMessageResponse;
import com.holo.ecommerce.product.service.ProductItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/item")
@RequiredArgsConstructor
public class ProductItemController {
    private final ProductItemService productItemService;
    @GetMapping
    public ResponseEntity<RestResponse<List<ProductItem>>> GetAllProduct(){
        RestResponse<List<ProductItem>> response = RestResponse.of(productItemService.GetAllProduct());
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_ALL_PRODUCT_ITEM.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{productItemId}")
    public ResponseEntity<RestResponse<ProductItem>> GetProductItemById(@PathVariable Long productItemId){
        RestResponse<ProductItem> response = RestResponse.of(productItemService.GetProductItem(productItemId));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_PRODUCT_ITEM_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{productItemId}")
    public ResponseEntity<RestResponse<ProductItem>> UpdateProduct(@RequestBody ProductItem productCreating,@PathVariable Long productItemId){
        RestResponse<ProductItem> response = RestResponse.of(productItemService.UpdateProductItem(productCreating,productItemId));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_UPDATED_PRODUCT_ITEM.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{productItemId}")
    public ResponseEntity<RestResponse<ProductItem>> DeleteProductById(@PathVariable Long productItemId){
        RestResponse<ProductItem> response = RestResponse.of(productItemService.DeleteProductItem(productItemId));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_DELETE_PRODUCT_ITEM.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<ProductItem>> CreateProduct(@RequestBody ProductItem productItemCreating){
        RestResponse<ProductItem> response = RestResponse.of(productItemService.CreateProductItem(productItemCreating));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_CREATED_PRODUCT_ITEM.getMessage());
        return ResponseEntity.ok(response);
    }

}
