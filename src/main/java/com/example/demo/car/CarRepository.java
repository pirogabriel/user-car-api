package com.example.demo.car;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findByOwnerId(Integer ownerId);
}
