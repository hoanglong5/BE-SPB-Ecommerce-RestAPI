package com.holo.ecommerce.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "variation_option",schema = "public")
public class VariationOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variation_id")
    private Variation variation;

    @JsonBackReference
    @ManyToMany
    @JoinTable(
            name = "product_configuration",
            joinColumns = @JoinColumn(name = "variation_option_id"),
            inverseJoinColumns = @JoinColumn(name = "product_item_id")
    )
    private Set<ProductItem> productItems;
}
