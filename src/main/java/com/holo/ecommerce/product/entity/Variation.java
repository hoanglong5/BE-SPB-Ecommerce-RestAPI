package com.holo.ecommerce.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.holo.ecommerce.category.entity.ProductCategory;
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
@Table(name = "variation",schema = "public")
public class Variation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "variation", cascade = CascadeType.ALL)
    private Set<VariationOption> options;
}
