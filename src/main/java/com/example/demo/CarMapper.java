package com.example.demo;

public class CarMapper {
    public static CarResponseDTO toResponse(Car car){
        return new CarResponseDTO(car.getId(), car.getBrand(), car.getModel(), car.getProductionYear(), car.getOwner().getName());
    }
}
