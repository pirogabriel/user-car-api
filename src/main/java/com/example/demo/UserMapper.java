package com.example.demo;

public class UserMapper {
    public static UserResponseDTO toResponse(User user){
        return new UserResponseDTO(user.getId(), user.getName(), user.getAge());
    }
    public static User toEntity(CreateUserRequest request){
        return new User(request.getName(), request.getAge());
    }
}
