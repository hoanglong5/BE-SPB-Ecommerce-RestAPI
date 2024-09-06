package com.holo.ecommerce.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.holo.ecommerce.customer.address.entity.Address;
import com.holo.ecommerce.customer.customer.entity.User;
import com.holo.ecommerce.payment.entity.UserPaymentMethod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "shop_order",schema = "public")
public class ShopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    private Long orderTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id")
    private UserPaymentMethod userPaymentMethod;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_method_id")
    private ShippingMethod shippingMethod;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "shopOrder",cascade = CascadeType.ALL)
    private Set<OrderLine> orderLines;


}
