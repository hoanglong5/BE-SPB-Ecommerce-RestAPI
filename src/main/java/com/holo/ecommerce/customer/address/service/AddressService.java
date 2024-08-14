package com.holo.ecommerce.customer.address.service;

import com.holo.ecommerce.customer.address.entity.Address;
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
        return addressRepository.findById(addressId).orElseThrow();
    }
    public Address CreateAddress(Address addressCreating){
        addressRepository.save(addressCreating);
        return addressCreating;
   }
    public Address DeleteAddress(Long addressId){
         addressRepository.deleteById(addressId);
        return GetAddress(addressId);
    }
}
