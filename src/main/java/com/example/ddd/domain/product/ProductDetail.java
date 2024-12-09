package com.example.ddd.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id")
    private Long id;

    @Column(name = "retail_price")
    private Long retailPrice;

    @Column(name = "supply_price")
    private Long supplyPrice;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
