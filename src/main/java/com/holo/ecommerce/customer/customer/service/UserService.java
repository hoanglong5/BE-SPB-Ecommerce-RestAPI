package com.holo.ecommerce.customer.customer.service;

import com.holo.ecommerce.customer.address.entity.Address;
import com.holo.ecommerce.customer.address.service.AddressService;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AddressService addressService;
    public List<User> GetAllUser(){
        return userRepository.findAll();
    }
    public User GetUser(Long userID){
        return userRepository.findById(userID).orElseThrow(RuntimeException::new);
    }
    public User CreateUser(User userCreating){
        User user = new User();
        user.setEmailAddress(userCreating.getEmailAddress());
        user.setPassword(userCreating.getPassword());
        user.setPhoneNumber(userCreating.getPhoneNumber());
        user.setAddresses(new HashSet<>());

        for (Address address : userCreating.getAddresses()){
            Address addressCreating = new Address();
            addressCreating.setUnitNumber(address.getUnitNumber());
            addressCreating.setStreetNumber(address.getStreetNumber());
            addressCreating.setAddressLine(address.getAddressLine());
            addressCreating.setCity(address.getCity());
            addressCreating.setRegion(address.getRegion());
            addressCreating = addressService.CreateAddress(addressCreating);
            user.getAddresses().add(addressCreating);
        }
        userRepository.save(user);
        return user;
    }
    public User UpdateOnlyAddress (Long userId, Long addressId, Address addressUpdating){
        User user = GetUser(userId);
        Address address = user.getAddresses()
                .stream()
                .filter(addr -> addr.getId().equals(addressId))
                .findFirst()
                .orElseThrow();
        address.setUnitNumber(addressUpdating.getUnitNumber());
        address.setAddressLine(addressUpdating.getAddressLine());
        address.setRegion(addressUpdating.getRegion());
        address.setStreetNumber(addressUpdating.getStreetNumber());
        address.setCity(addressUpdating.getCity());
        addressService.CreateAddress(address);
        return user;
    }
    public User DeleteUser(Long userID){
        userRepository.deleteById(userID);
        return GetUser(userID);
    }
    public User UpdateUser (Long userId, User userUpdating){
        User user = GetUser(userId);
        user.setPassword(userUpdating.getPassword());
        user.setPhoneNumber(userUpdating.getPhoneNumber());
        user.setEmailAddress(userUpdating.getEmailAddress());
        userRepository.save(user);
        return user;
    }
}
