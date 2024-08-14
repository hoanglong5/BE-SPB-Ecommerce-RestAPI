package com.holo.ecommerce.payment.service.PaymentEntityService;

import com.holo.ecommerce.base.enums.ExceptionMessageResponse;
import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.payment.entity.UserPaymentMethod;
import com.holo.ecommerce.payment.enums.PaymentExceptionMessage;
import com.holo.ecommerce.payment.repository.UserPaymentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPaymentMethodEntityService extends BaseService<UserPaymentMethod, UserPaymentTypeRepository> {

    public UserPaymentMethodEntityService(UserPaymentTypeRepository dao) {
        super(dao);
    }
    public List<UserPaymentMethod> FindAllUserPaymentType() {
        return getDao().findAll();
    }

    public UserPaymentMethod FindUserPaymentTypeById(Long userPaymentMethodId) {
        return getDao().findById(userPaymentMethodId).orElseThrow(() -> new ItemNotFoundException(PaymentExceptionMessage.PAYMENT_METHOD_NOT_FOUND.getMessage()));
    }

    public UserPaymentMethod SaveUserPaymentType(UserPaymentMethod userPaymentType) {
        return getDao().save(userPaymentType);
    }

    public UserPaymentMethod DeleteUserPaymentType(Long userPaymentMethodId) {
        UserPaymentMethod userPaymentType = getDao().findById(userPaymentMethodId).orElseThrow(() -> new ItemNotFoundException(PaymentExceptionMessage.PAYMENT_METHOD_NOT_FOUND.getMessage()));
        getDao().deleteById(userPaymentMethodId);
        return userPaymentType;
    }
}
