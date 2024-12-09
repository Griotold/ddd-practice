package com.example.ddd.application.service;

import com.example.ddd.domain.entity.product.Product;
import com.example.ddd.domain.entity.user.User;
import com.example.ddd.domain.repository.ProductRepository;
import com.example.ddd.domain.repository.UserRepository;
import com.example.ddd.domain.service.UserProductDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    private final UserProductDomainService userProductDomainService;

    //TODO: 도메인 서비스 사용 예제
    @Transactional
    public void connectProductToUser(Long userId, Long productId) {
        final User user = userRepository.findById(userId).orElseThrow();
        final Product product = productRepository.findById(productId).orElseThrow();
        userProductDomainService.connectUserProduct(user, product);
    }
}
