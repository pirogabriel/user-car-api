package com.example.demo;

public class CarResponseDTO {
    private Integer id;
    private String brand;
    private String model;
    private int productionYear;
    private String ownerName;

    public CarResponseDTO(Integer id, String brand, String model, int productionYear, String ownerName){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.ownerName = ownerName;
    }
    public Integer getId(){ return id; }
    public String getBrand(){ return brand; }
    public String getModel(){ return model; }
    public int getProductionYear(){ return productionYear; }
    public String getOwnerName(){ return ownerName; }
}
