package com.holo.ecommerce.customer.address.service;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.customer.address.entity.Address;
import com.holo.ecommerce.customer.address.enums.AddressMessageResponse;
import com.holo.ecommerce.customer.address.repository.AddressRepository;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    public List<Address> GetAllAddress(){
        return addressRepository.findAll();
    }
    public Address GetAddress(Long addressId){
        return addressRepository.findById(addressId).orElseThrow(()->new ItemNotFoundException(AddressMessageResponse.ADDRESS_ENUMS_NOT_FOUND.getMessage()));
    }
    public Address SaveAddress(Address addressSaving){
        return addressRepository.save(addressSaving);
   }
    public Address DeleteAddress(Long addressId){
         addressRepository.deleteById(addressId);
        return GetAddress(addressId);
    }
}
