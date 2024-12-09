package com.example.ddd.presentation;

import com.example.ddd.application.dtos.user.UserResponse;
import com.example.ddd.application.service.UserService;
import com.example.ddd.presentation.dtos.SimpleUpdateUserRequest;
import com.example.ddd.presentation.dtos.UpdateUserRequest;
import com.example.ddd.presentation.dtos.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.createUser(request.toDTO()));
    }

    @PutMapping("/simple/{userId}")
    public ResponseEntity<UserResponse> simpleUpdateUser(
            @RequestBody SimpleUpdateUserRequest request,
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.simpleUpdateUser(userId, request.toDTO()));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(
            @RequestBody UpdateUserRequest request,
            @PathVariable Long userId
    ) {
        return ResponseEntity.ok(userService.updateUser(userId, request.toDTO()));
    }
}
