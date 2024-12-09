package com.example.ddd.domain.repository;

import com.example.ddd.domain.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//TODO: Infra 계층과 분리하기 위한 방식
@Repository
public interface UserRepository {
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);
}
