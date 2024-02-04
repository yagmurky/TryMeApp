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
@Table(name = "tbl_product_images")
@Entity
public class ProductImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Lob
    private String image;
    private String name;
    private String type;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
