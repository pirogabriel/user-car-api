package com.example.demo;

public class UserResponseDTO {
    private Integer id;
    private String name;
    private int age;

    public UserResponseDTO(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
