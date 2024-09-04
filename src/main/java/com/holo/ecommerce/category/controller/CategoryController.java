package com.holo.ecommerce.category.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.category.entity.ProductCategory;
import com.holo.ecommerce.category.enums.CategoryMessageResponse;
import com.holo.ecommerce.category.service.ProductCategoryService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final ProductCategoryService categoryService;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductCategory>>> GetAllCategory(){
        RestResponse<List<ProductCategory>> response = RestResponse.of(categoryService.GetAllCategory());
        response.setMessages(CategoryMessageResponse.SUCCESSFULLY_FIND_ALL_CATEGORY.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{productCategoryId}")
    public ResponseEntity<RestResponse<ProductCategory>> GetCategoryById(@PathVariable Long productCategoryId){
        RestResponse<ProductCategory> response = RestResponse.of(categoryService.GetProductCategory(productCategoryId));
        response.setMessages(CategoryMessageResponse.SUCCESSFULLY_FIND_CATEGORY_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{productCategoryId}")
    public ResponseEntity<RestResponse<ProductCategory>> UpdateCategory(@RequestBody ProductCategory productCategoryUpdating,@PathVariable Long productCategoryId){
        RestResponse<ProductCategory> response = RestResponse.of(categoryService.UpdateCategory(productCategoryUpdating,productCategoryId));
        response.setMessages(CategoryMessageResponse.SUCCESSFULLY_UPDATED_CATEGORY.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{productCategoryId}")
    public ResponseEntity<RestResponse<ProductCategory>> DeleteCategoryById(@PathVariable Long productCategoryId){
        RestResponse<ProductCategory> response = RestResponse.of(categoryService.DeleteCategory(productCategoryId));
        response.setMessages(CategoryMessageResponse.SUCCESSFULLY_UPDATED_CATEGORY.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<ProductCategory>> CreateCategory(@RequestBody ProductCategory productCategoryCreating){
        RestResponse<ProductCategory> response = RestResponse.of(categoryService.CreateCategory(productCategoryCreating));
        response.setMessages(CategoryMessageResponse.SUCCESSFULLY_UPDATED_CATEGORY.getMessage());
        return ResponseEntity.ok(response);
    }
}
