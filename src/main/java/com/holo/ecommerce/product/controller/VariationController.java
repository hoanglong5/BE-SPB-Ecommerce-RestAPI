package com.holo.ecommerce.product.controller;

import com.holo.ecommerce.base.controller.RestResponse;
import com.holo.ecommerce.product.entity.Variation;
import com.holo.ecommerce.product.enums.ProductMessageResponse;
import com.holo.ecommerce.product.service.VariationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/variation")
@RequiredArgsConstructor
public class VariationController {
    private final VariationService variationService;

    @GetMapping
    public ResponseEntity<RestResponse<List<Variation>>> GetAllVariation(){
        RestResponse<List<Variation>> response = RestResponse.of(variationService.GetAllVariation());
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_ALL_VARIATION.getMessage());
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{variationID}")
    public ResponseEntity<RestResponse<Variation>> GetVariationById(@PathVariable Long variationID){
        RestResponse<Variation> response = RestResponse.of(variationService.GetVariation(variationID));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_FIND_VARIATION_BY_ID.getMessage());
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{variationID}")
    public ResponseEntity<RestResponse<Variation>> UpdateVariation(@RequestBody Variation variationUpdating,@PathVariable Long variationID){
        RestResponse<Variation> response = RestResponse.of(variationService.UpdateVariation(variationID,variationUpdating));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_UPDATED_VARIATION.getMessage());
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{variationID}")
    public ResponseEntity<RestResponse<Variation>> DeleteVariationById(@PathVariable Long variationID){
        RestResponse<Variation> response = RestResponse.of(variationService.DeleteVariation(variationID));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_DELETE_VARIATION.getMessage());
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<RestResponse<Variation>> CreateVariation(@RequestBody Variation variationCreating){
        RestResponse<Variation> response = RestResponse.of(variationService.CreateVariation(variationCreating));
        response.setMessages(ProductMessageResponse.SUCCESSFULLY_CREATED_VARIATION.getMessage());
        return ResponseEntity.ok(response);
    }
}
