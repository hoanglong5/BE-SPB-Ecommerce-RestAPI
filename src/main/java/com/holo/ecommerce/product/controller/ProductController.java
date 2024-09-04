package com.holo.ecommerce.product.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.enums.ProductMessageResponse;
import com.holo.ecommerce.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<RestResponse<List<Product>>> GetAllProduct(){
        RestResponse<List<Product>> response = RestResponse.of(productService.GetAllProduct());
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_ALL_PRODUCT.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<RestResponse<Product>> GetProductById(@PathVariable Long productId){
        RestResponse<Product> response = RestResponse.of(productService.GetProduct(productId));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_PRODUCT_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{productId}")
    public ResponseEntity<RestResponse<Product>> UpdateProduct(@RequestBody Product productUpdating,@PathVariable Long productId){
        RestResponse<Product> response = RestResponse.of(productService.UpdateProduct(productUpdating,productId));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_UPDATED_PRODUCT.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<RestResponse<Product>> DeleteProductById(@PathVariable Long productId){
        RestResponse<Product> response = RestResponse.of(productService.DeleteProduct(productId));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_DELETE_PRODUCT.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<Product>> CreateProduct(@RequestBody Product productCreating){
        RestResponse<Product> response = RestResponse.of(productService.CreateProduct(productCreating));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_CREATED_PRODUCT.getMessage());
        return ResponseEntity.ok(response);
    }
}
