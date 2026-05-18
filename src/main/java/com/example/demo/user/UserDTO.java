package com.example.demo.user;

import io.swagger.v3.oas.annotations.media.Schema;

public class UserDTO {
    @Schema(example = "Gabriel")
    private String name;
    private int age;

    public UserDTO(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
