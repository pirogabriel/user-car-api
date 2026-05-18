package com.example.demo.car;

import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String brand;
    private String model;
    private int productionYear;

    @JsonIgnore
    @ManyToOne
    private User owner;

    public Car(){
    }

    public Car(String brand, String model, int productionYear, User owner){
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.owner = owner;
    }

    public Integer getId(){
        return id;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public int getProductionYear(){
        return productionYear;
    }
    public User getOwner(){
        return owner;
    }
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setProductionYear(int productionYear){
        this.productionYear = productionYear;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setOwner(User owner){
        this.owner = owner;
    }
}
