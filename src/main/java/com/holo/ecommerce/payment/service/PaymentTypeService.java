package com.holo.ecommerce.payment.service;

import com.holo.ecommerce.payment.entity.PaymentType;
import com.holo.ecommerce.payment.service.PaymentEntityService.PaymentTypeEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentTypeService {
    private final PaymentTypeEntityService paymentTypeEntityService;

    public List<PaymentType> GetAllPaymentType(){
        return paymentTypeEntityService.FindAllPaymentType();
    }

    public PaymentType GetPaymentType(Long paymentTypeId){
        return paymentTypeEntityService.FindPaymentTypeById(paymentTypeId);
    }

    @Transactional
    public PaymentType CreatePaymentType(PaymentType paymentTypeCreating){
        return paymentTypeEntityService.SavePaymentType(paymentTypeCreating);
    }

    @Transactional
    public PaymentType DeletePaymentType(Long paymentTypeId){
        return paymentTypeEntityService.DeletePaymentType(paymentTypeId);
    }
}
