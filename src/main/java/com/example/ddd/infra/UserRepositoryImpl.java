package com.example.ddd.infra;

import com.example.ddd.domain.entity.user.User;
import com.example.ddd.domain.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO: JpaRepository 를 Infra 계층에
// 만약, 여기다가 QueryDSL 도 사용한다면, 여기다가 구현을 하고 UserRepository 선언부만 작성해서 사용한다.
public interface UserRepositoryImpl extends JpaRepository<User, Long>, UserRepository {
}
