package com.holo.ecommerce.customer.customer.service;

import com.holo.ecommerce.customer.address.entity.Address;
import com.holo.ecommerce.customer.address.service.AddressService;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.repository.UserRepository;
import com.holo.ecommerce.customer.customer.service.UserEntityService.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityService userEntityService;
    private final AddressService addressService;
    public List<User> GetAllUser(){
        return userEntityService.FindAllUser();
    }
    public User GetUser(Long userId){
        return userEntityService.FindUserById(userId);
    }
    @Transactional
    public User CreateUser(User userCreating){
        User user = new User();
        //Creating
        user.setEmailAddress(userCreating.getEmailAddress());
        user.setPassword(userCreating.getPassword());
        user.setPhoneNumber(userCreating.getPhoneNumber());
        user.setAddresses(new HashSet<>());
        //Find all addresses in updating user
        for (Address address : userCreating.getAddresses()){
            Address addressCreating = new Address();
            addressCreating.setUnitNumber(address.getUnitNumber());
            addressCreating.setStreetNumber(address.getStreetNumber());
            addressCreating.setAddressLine(address.getAddressLine());
            addressCreating.setCity(address.getCity());
            addressCreating.setRegion(address.getRegion());
            addressCreating = addressService.SaveAddress(addressCreating);
            user.getAddresses().add(addressCreating);
        }
//        Set<Address> processedAddresses = userCreating.getAddresses().stream()
//                .map(address -> {
//                    Address addressCreating = new Address();
//                    addressCreating.setUnitNumber(address.getUnitNumber());
//                    addressCreating.setStreetNumber(address.getStreetNumber());
//                    addressCreating.setAddressLine(address.getAddressLine());
//                    addressCreating.setCity(address.getCity());
//                    addressCreating.setRegion(address.getRegion());
//                    return addressService.SaveAddress(addressCreating);
//                })
//                .collect(Collectors.toSet());
        userEntityService.SaveUser(user);
        return user;
    }
    @Transactional
    public User UpdateOnlyAddress (Long userId, Long addressId, Address addressUpdating){
        User user = GetUser(userId);
        Address address = user.getAddresses()
                .stream()
                .filter(addr -> addr.getId().equals(addressId))
                .findFirst()
                .orElseThrow();
        //Update
        address.setUnitNumber(addressUpdating.getUnitNumber());
        address.setAddressLine(addressUpdating.getAddressLine());
        address.setRegion(addressUpdating.getRegion());
        address.setStreetNumber(addressUpdating.getStreetNumber());
        address.setCity(addressUpdating.getCity());
        addressService.SaveAddress(address);
        return user;
    }
    @Transactional
    public User DeleteUser(Long userId){
        userEntityService.DeleteUser(userId);
        return GetUser(userId);
    }
    @Transactional
    public User UpdateUser (Long userId, User userUpdating){
        User user = GetUser(userId);
        //Update
        user.setPassword(userUpdating.getPassword());
        user.setPhoneNumber(userUpdating.getPhoneNumber());
        user.setEmailAddress(userUpdating.getEmailAddress());
        userEntityService.SaveUser(user);
        return user;
    }
}
