package com.holo.ecommerce.product.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToMany(mappedBy = "productItems")
    private Set<VariationOption> variationOptions;
}
