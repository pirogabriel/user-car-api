package com.example.demo.user;

import com.example.demo.user.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users")
    @GetMapping("/users")
    public Page<UserResponseDTO> getUsers(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue ="5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return userService.getUsers(name, page, size, sortBy, direction);
    }

    @Operation(summary = "Get user by id")
    @GetMapping("/users/{id}")
    public UserResponseDTO getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @Operation(summary = "Get all users unique names")
    @GetMapping("/users/names")
    public Set<String> getNames() {
        return userService.getUniqueNames();
    }

    @Operation(summary = "Get all users in DTO format")
    @GetMapping("/users/dto")
    public List<UserDTO> getDTO() {
        return userService.getDTO();
    }

    @Operation(summary = "Get the summary")
    @GetMapping("/users/summary")
    public Map<String, Object> summary() {
        return userService.getSummary();
    }

    @Operation(summary = "Get top 3 oldest users")
    @GetMapping("/users/top3")
    public List<User> top3() {
        return userService.getTop3Oldest();
    }

    @Operation(summary = "Get all adult users")
    @GetMapping("/users/adults")
    public List<User> adults() {
        return userService.getAdults();
    }

    @Operation(summary = "Add a user")
    @PostMapping("/users")
    public User addUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Update a user")
    @PutMapping("/users/{id}")
    public UserResponseDTO updateUser(@PathVariable Integer id, @Valid @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @Operation(summary = "Delete a user")
    @DeleteMapping("/users/{id}")
    public Map<String, String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return Map.of("message", "User deleted");
    }
}