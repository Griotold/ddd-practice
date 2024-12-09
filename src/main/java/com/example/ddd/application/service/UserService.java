package com.example.ddd.application.service;

import com.example.ddd.application.dtos.user.SimpleUpdateUserDto;
import com.example.ddd.application.dtos.user.UpdateUserDto;
import com.example.ddd.application.dtos.user.UserDto;
import com.example.ddd.application.dtos.user.UserResponse;
import com.example.ddd.domain.entity.user.User;
import com.example.ddd.domain.repository.ProductRepository;
import com.example.ddd.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public UserResponse getUser(Long userId) {
        return userRepository.findById(userId).map(UserResponse::of).orElseThrow();
    }

    @Transactional
    public UserResponse createUser(UserDto request) {
        // User 엔티티에 객체 생성에 대한 책임을 부여합니다.
        User user = User.create(
                request.getName(),
                request.getEmail(),
                request.getPhoneNumber()
        );

        userRepository.save(user);

        // Dirty Checking 으로 User 엔티티의 Id가 추가되어 반환됩니다.
        return UserResponse.of(user);
    }

    //TODO: Optional 안에서 로직 처리하고 맨 마지막에 .orElseThrow()
    @Transactional
    public UserResponse simpleUpdateUser(Long userId, SimpleUpdateUserDto request) {
        return userRepository.findById(userId).map(user -> {
            user.update(request.getName(), request.getEmail());
            return UserResponse.of(user);
        }).orElseThrow();
    }

    @Transactional
    public UserResponse updateUser(Long userId, UpdateUserDto request) {
        return userRepository.findById(userId).map(user -> {
            user.update(request.getName(), request.getEmail(), request.getPhoneNumber());
            return UserResponse.of(user);
        }).orElseThrow();
    }
}
