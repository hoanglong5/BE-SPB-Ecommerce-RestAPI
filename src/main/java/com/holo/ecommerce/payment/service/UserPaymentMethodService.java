package com.holo.ecommerce.payment.service;

import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.customer.customer.service.UserService;
import com.holo.ecommerce.payment.entity.PaymentType;
import com.holo.ecommerce.payment.entity.UserPaymentMethod;
import com.holo.ecommerce.payment.service.PaymentEntityService.UserPaymentMethodEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPaymentMethodService {
    private final UserPaymentMethodEntityService userPaymentMethodEntityService;
    private final UserService userService;
    private final PaymentTypeService paymentTypeService;
    public List<UserPaymentMethod> GetAllUserPaymentMethod(){
        return userPaymentMethodEntityService.FindAllUserPaymentType();
    }
    public UserPaymentMethod GetUserPaymentMethod(Long userPaymentMethodId){
        return userPaymentMethodEntityService.FindUserPaymentTypeById(userPaymentMethodId);
    }
    @Transactional
    public UserPaymentMethod CreateUserPaymentMethod(UserPaymentMethod userPaymentMethodCreating){
        User user = userService.GetUser(userPaymentMethodCreating.getUser().getId());
        PaymentType paymentType = paymentTypeService.GetPaymentType(userPaymentMethodCreating.getPaymentType().getId());
        UserPaymentMethod userPaymentMethod = new UserPaymentMethod();
        //Create
        userPaymentMethod.setUser(user);
        userPaymentMethod.setPaymentType(paymentType);
        userPaymentMethod.setProvider(userPaymentMethodCreating.getProvider());
        userPaymentMethod.setExpiryDate(userPaymentMethodCreating.getExpiryDate());
        userPaymentMethod.setAccountNumber(userPaymentMethodCreating.getAccountNumber());
        userPaymentMethod.setIsDefault(userPaymentMethodCreating.getIsDefault());
        return userPaymentMethodEntityService.SaveUserPaymentType(userPaymentMethod);
    }
    @Transactional
    public UserPaymentMethod UpdateUserPaymentMethod(Long userPaymentMethodId,UserPaymentMethod userPaymentMethodUpdating){
        UserPaymentMethod userPaymentMethod = userPaymentMethodEntityService.FindUserPaymentTypeById(userPaymentMethodId);
        User user = userService.GetUser(userPaymentMethodUpdating.getUser().getId());
        PaymentType paymentType = paymentTypeService.GetPaymentType(userPaymentMethodUpdating.getPaymentType().getId());
        //Update
        userPaymentMethod.setPaymentType(paymentType);
        userPaymentMethod.setProvider(userPaymentMethodUpdating.getProvider());
        userPaymentMethod.setExpiryDate(userPaymentMethodUpdating.getExpiryDate());
        userPaymentMethod.setAccountNumber(userPaymentMethodUpdating.getAccountNumber());
        userPaymentMethod.setIsDefault(userPaymentMethodUpdating.getIsDefault());
        return userPaymentMethodEntityService.SaveUserPaymentType(userPaymentMethod);
    }
    @Transactional
    public UserPaymentMethod DeleteUserPaymentMethod(Long userPaymentMethodId){
        return userPaymentMethodEntityService.DeleteUserPaymentType(userPaymentMethodId);
    }

}
