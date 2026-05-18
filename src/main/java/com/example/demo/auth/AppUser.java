package com.example.demo.auth;

import jakarta.persistence.*;

@Entity
@Table(name = "app_users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String role;

    public AppUser(){}

    public AppUser(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Integer getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}
