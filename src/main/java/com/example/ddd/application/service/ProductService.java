package com.example.ddd.application.service;

import com.example.ddd.application.dtos.product.ProductDto;
import com.example.ddd.domain.entity.product.Product;
import com.example.ddd.domain.entity.product.ProductDetail;
import com.example.ddd.domain.entity.product.ProductImage;
import com.example.ddd.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * application.service 에 있는 ProductService 는
 * 애플리케이션의 유스케이스를 구현하는 역할
 * */
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductDto getProduct(Long productId) {
        return productRepository.findById(productId)
                .map(ProductDto::of) // TODO: DTO 치환 로직 static 메서드 사용 예제
                .orElseThrow();
    }

    @Transactional
    public void updateImage(Long productId, String name, String url) {
        Product product = productRepository.findById(productId).orElseThrow();
        ProductDetail detail = product.getProductDetail();
        detail.updateImage(ProductImage.create(detail, name, url));
    }
}
