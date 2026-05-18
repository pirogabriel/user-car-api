package com.example.demo.car;

import com.example.demo.car.dto.CarResponseDTO;

public class CarMapper {
    public static CarResponseDTO toResponse(Car car){
        return new CarResponseDTO(car.getId(), car.getBrand(), car.getModel(), car.getProductionYear(), car.getOwner().getName());
    }
}
