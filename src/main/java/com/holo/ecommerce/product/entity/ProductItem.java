package com.holo.ecommerce.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.holo.ecommerce.cart.entity.Cart;
import com.holo.ecommerce.cart.entity.CartItem;
import com.holo.ecommerce.order.entity.OrderLine;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_item",schema = "public")
public class ProductItem {
    @Id
    private Long id;
    @Column(name = "sku")
    private String sku;
    @Column(name = "qty_in_stock")
    private Long quantity;
    @Column(name = "product_image")
    private String productItemImage;
    @Column(name = "price")
    private Long price;

    @JsonManagedReference
    @JsonIgnore
    @ManyToMany(mappedBy = "productItems",cascade = CascadeType.ALL)
    private Set<VariationOption> variationOptions;

    @JsonIgnore
    @OneToMany(mappedBy = "productItem",cascade = CascadeType.ALL)
    private Set<OrderLine> orderLines;

    @JsonIgnore
    @OneToMany(mappedBy = "productItem",cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
