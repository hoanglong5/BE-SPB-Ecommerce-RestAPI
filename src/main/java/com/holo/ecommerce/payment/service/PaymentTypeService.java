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
    public PaymentType GetPaymentType(Long paymentTypeId){
        return paymentTypeEntityService.FindPaymentTypeById(paymentTypeId);
    }
    public List<PaymentType> GetAllPaymentType(){
        return paymentTypeEntityService.FindAllPaymentType();
    }
    @Transactional
    public PaymentType CreatePaymentType(PaymentType paymentTypeCreating){
        PaymentType paymentType = new PaymentType();
        paymentType.setType(paymentTypeCreating.getType());
        return paymentTypeEntityService.SavePaymentType(paymentType);
    }
    @Transactional
    public PaymentType DeletePaymentType(Long paymentTypeId){
        return paymentTypeEntityService.DeletePaymentType(paymentTypeId);
    }
}
