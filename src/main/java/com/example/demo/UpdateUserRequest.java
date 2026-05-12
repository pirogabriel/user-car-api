package com.example.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UpdateUserRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 0 , message = "Age must be >= 0")
    private int age;

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
}
