package com.yagmur.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_product_features")
@Entity
public class ProductFeatures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String color;
    private String size;
    private String material;
    private String pattern;
    private boolean recycle;
    private String sleeveType;
    private String skirtLength;
    private Integer waistSize;
    private Integer hipSize;
    private Integer length;
    private String description;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
