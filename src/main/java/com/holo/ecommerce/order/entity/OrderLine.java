package com.holo.ecommerce.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.holo.ecommerce.product.entity.ProductItem;
import com.holo.ecommerce.review.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order_line",schema = "public")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "qty")
    private Long quantity;
    private Long price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private ShopOrder shopOrder;

    @JsonIgnore
    @OneToMany(mappedBy = "orderLine",cascade = CascadeType.ALL)
    private Set<Review> reviews;
}
