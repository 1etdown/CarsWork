package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enums.EngineType;
import com.example.springdatabasicdemo.enums.TransmissionType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class ShowOfferDto {
    private UUID id;
    private ShowBrandDto brand;
    private ModelDto model;


    private EngineType engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private TransmissionType transmission;
    private int year;


    public ShowOfferDto(UUID id, ModelDto model, UserDto user, String description, EngineType engine, String imageUrl, int mileage, BigDecimal price, TransmissionType transmission, int year, Date created, Date modified, ShowBrandDto brand) {

        this.model = model;
        this.id = id;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.brand = brand;

    }

    public ShowOfferDto() {
    }



    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ShowBrandDto getBrand() {
        return brand;
    }

    public void setBrand(ShowBrandDto brand) {
        this.brand = brand;
    }
}




