package com.holo.ecommerce.customer.address.controller;

import com.holo.ecommerce.customer.address.entity.Address;
import com.holo.ecommerce.customer.address.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/addresses")
@RequiredArgsConstructor
public class ServiceController {
    private final AddressService addressService;
    @GetMapping
    public ResponseEntity<List<Address>> GetAllAddress(){
        return ResponseEntity.ok(addressService.GetAllAddress());
    }
    @GetMapping("/{addressID}")
    public ResponseEntity<Address> GetAddress(@PathVariable Long addressId){
        return ResponseEntity.ok(addressService.GetAddress(addressId));
    }
    @PostMapping
    public ResponseEntity<Address> CreatingAddress(@RequestBody Address address){
        return ResponseEntity.ok(addressService.SaveAddress(address));
    }
    @DeleteMapping("/{addressID}")
    public ResponseEntity<Address> DeleteAddress(@PathVariable Long addressId){
        return ResponseEntity.ok(addressService.DeleteAddress(addressId));
    }
}
