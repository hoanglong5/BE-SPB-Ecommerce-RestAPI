package com.holo.ecommerce.category.entity;

import com.holo.ecommerce.product.entity.Product;
import com.holo.ecommerce.product.entity.Variation;
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
@Table(name = "product_category",schema = "public")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name")
    private String categoryName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private ProductCategory parentCategory;
    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL)
    private Set<ProductCategory> subCategories;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Variation> variations;

}
