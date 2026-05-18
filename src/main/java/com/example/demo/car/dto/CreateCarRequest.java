package com.example.demo.car.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateCarRequest {
    @NotBlank(message = "Brand cannot be empty")
    private String brand;
    @NotBlank(message = "Model cannot be empty")
    private String model;
    @Min(value = 1885 , message = "Car year must be >= 1885")
    private int productionYear;

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getProductionYear() {
        return productionYear;
    }
}
