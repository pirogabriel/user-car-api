package com.example.demo.user;

import com.example.demo.user.dto.CreateUserRequest;
import com.example.demo.user.dto.UserResponseDTO;

public class UserMapper {
    public static UserResponseDTO toResponse(User user){
        return new UserResponseDTO(user.getId(), user.getName(), user.getAge());
    }
    public static User toEntity(CreateUserRequest request){
        return new User(request.getName(), request.getAge());
    }
}
