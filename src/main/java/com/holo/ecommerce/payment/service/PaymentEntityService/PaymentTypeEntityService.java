package com.holo.ecommerce.payment.service.PaymentEntityService;

import com.holo.ecommerce.base.exception.ItemNotFoundException;
import com.holo.ecommerce.base.service.BaseService;
import com.holo.ecommerce.payment.entity.PaymentType;
import com.holo.ecommerce.payment.enums.PaymentExceptionResponse;
import com.holo.ecommerce.payment.repository.PaymentTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeEntityService extends BaseService<PaymentType, PaymentTypeRepository> {
    public PaymentTypeEntityService(PaymentTypeRepository dao) {
        super(dao);
    }
    public List<PaymentType> FindAllPaymentType() {
        return getDao().findAll();
    }

    public PaymentType FindPaymentTypeById(Long paymentTypeId) {
        return getDao().findById(paymentTypeId).orElseThrow(() -> new ItemNotFoundException(PaymentExceptionResponse.PAYMENT_TYPE_NOT_FOUND.getMessage()));
    }
    public PaymentType SavePaymentType(PaymentType paymentType) {
        return getDao().save(paymentType);
    }
    public PaymentType DeletePaymentType(Long paymentTypeId) {
        PaymentType paymentType = getDao().findById(paymentTypeId).orElseThrow(() -> new ItemNotFoundException(PaymentExceptionResponse.PAYMENT_TYPE_NOT_FOUND.getMessage()));
        getDao().deleteById(paymentTypeId);
        return paymentType;
    }
}
