package com.example.ddd.domain.repository;

import com.example.ddd.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// TODO: 기존 프로젝트 방식
public interface ProductRepository extends JpaRepository<Product, Long> {
}
