package com.holo.ecommerce.customer.address.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address", schema = "public")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "unit_number")
    private String unitNumber;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "address_line")
    private String addressLine;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
}
