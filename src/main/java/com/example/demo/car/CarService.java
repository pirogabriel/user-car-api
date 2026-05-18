package com.example.demo.car;

import com.example.demo.car.dto.CarResponseDTO;
import com.example.demo.car.dto.CreateCarRequest;
import com.example.demo.user.User;
import com.example.demo.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final UserService userService;

    public CarService(CarRepository carRepository, UserService userService){
        this.carRepository = carRepository;
        this.userService = userService;
    }
    public List<CarResponseDTO> getCarsByUserId(Integer userId){
        userService.getUserById(userId);
        return carRepository.findByOwnerId(userId).stream().map(CarMapper::toResponse).toList();
    }
    public CarResponseDTO createCarForUser(Integer userId, CreateCarRequest request){
        User owner = userService.getUserEntityById(userId);

        Car car = new Car(request.getBrand(), request.getModel(), request.getProductionYear(), owner);

        Car savedCar = carRepository.save(car);

        return CarMapper.toResponse(savedCar);
    }
}
