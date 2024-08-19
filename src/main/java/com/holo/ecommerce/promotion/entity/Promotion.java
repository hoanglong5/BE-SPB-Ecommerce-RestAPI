package com.holo.ecommerce.promotion.entity;

import com.holo.ecommerce.category.entity.ProductCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "promotion",schema = "public")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "discount_rate")
    private int discountRate;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "promotion_category",
            joinColumns = @JoinColumn(name = "promotion_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<ProductCategory> categories;

}
