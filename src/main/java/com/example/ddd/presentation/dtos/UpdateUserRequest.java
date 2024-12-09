package com.example.ddd.presentation.dtos;

import com.example.ddd.application.dtos.user.UpdateUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateUserRequest {
    String name;
    String email;
    String phoneNumber;

    public UpdateUserDto toDTO() {
        return UpdateUserDto.create(this.name, this.email, this.phoneNumber);
    }
}
