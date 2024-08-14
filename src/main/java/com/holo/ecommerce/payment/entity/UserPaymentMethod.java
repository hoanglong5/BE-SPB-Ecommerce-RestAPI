package com.holo.ecommerce.payment.entity;

import com.holo.ecommerce.customer.customer.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_payment_method", schema = "public")
public class UserPaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "provider")
    private String provider;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "expiry_date")
    private LocalDate expiryDate;
    @Column(name = "is_default")
    private Boolean isDefault;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")

    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_type_id")
    private PaymentType paymentType;
}
