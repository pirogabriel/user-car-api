package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }
    @Operation(summary = "Get cars by specific user")
    @GetMapping("/users/{userId}/cars")
    public List<CarResponseDTO> getCarsByUser(@PathVariable Integer userId){
        return carService.getCarsByUserId(userId);
    }
    @Operation(summary = "Add a car for specific user")
    @PostMapping("/users/{userId}/cars")
    public CarResponseDTO createCarForUser(@PathVariable Integer userId, @Valid @RequestBody CreateCarRequest request) {
        return carService.createCarForUser(userId, request);
    }
}
