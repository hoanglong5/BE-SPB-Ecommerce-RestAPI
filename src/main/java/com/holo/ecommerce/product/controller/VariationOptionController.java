package com.holo.ecommerce.product.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.product.entity.VariationOption;
import com.holo.ecommerce.product.enums.ProductMessageResponse;
import com.holo.ecommerce.product.service.VariationOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/option")
@RequiredArgsConstructor
public class VariationOptionController {
    private final VariationOptionService variationOptionService;

    @GetMapping
    public ResponseEntity<RestResponse<List<VariationOption>>> GetAllVariationOption(){
        RestResponse<List<VariationOption>> response = RestResponse.of(variationOptionService.GetAllVariationOption());
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_ALL_VARIATION_OPTION.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{variationOptionID}")
    public ResponseEntity<RestResponse<VariationOption>> GetVariationOptionById(@PathVariable Long variationOptionID){
        RestResponse<VariationOption> response = RestResponse.of(variationOptionService.GetVariationOption(variationOptionID));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_VARIATION_OPTION_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{variationOptionID}")
    public ResponseEntity<RestResponse<VariationOption>> UpdateVariationOption(@RequestBody VariationOption VariationOptionUpdating,@PathVariable Long variationOptionID){
        RestResponse<VariationOption> response = RestResponse.of(variationOptionService.UpdateVariationOption(VariationOptionUpdating,variationOptionID));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_UPDATED_VARIATION_OPTION.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{variationOptionID}")
    public ResponseEntity<RestResponse<VariationOption>> DeleteVariationOptionById(@PathVariable Long variationOptionID){
        RestResponse<VariationOption> response = RestResponse.of(variationOptionService.DeleteVariationOption(variationOptionID));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_DELETE_VARIATION.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<VariationOption>> CreateVariationOption(@RequestBody VariationOption VariationOptionCreating){
        RestResponse<VariationOption> response = RestResponse.of(variationOptionService.CreateVariationOption(VariationOptionCreating));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_CREATED_VARIATION_OPTION.getMessage());
        return ResponseEntity.ok(response);
    }
}
