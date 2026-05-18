package com.example.demo.user;

import com.example.demo.car.Car;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value=0, message = "Age must be >= 0")
    private int age;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars(){
        return cars;
    }

    public User() {
    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void setAge(int age){
        if (age< 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }
    public void setName(String name){
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }
    public int getId(){ return id; }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}
