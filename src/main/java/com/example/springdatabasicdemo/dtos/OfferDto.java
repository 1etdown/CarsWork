package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enums.EngineType;
import com.example.springdatabasicdemo.enums.TransmissionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class OfferDto {

    private UUID id;
    private ModelDto model;
    private String user;
    private String description;
    private EngineType engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private TransmissionType transmission;
    private int year;
    private Date created;
    private Date modified;

    public OfferDto(UUID id, ModelDto model, String user, String description, EngineType engine, String imageUrl, int mileage, BigDecimal price, TransmissionType transmission, int year, Date created, Date modified) {
        this.id = id;
        this.model = model;
        this.user = user;
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
    }

    public OfferDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ModelDto getModel() {
        return model;
    }

    public void setModel(ModelDto model) {
        this.model = model;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Offer {id=" + id + ", model=" + model + ", user=" + user + ", description='" + description + "', engine=" + engine + ", imageUrl='" + imageUrl + "', mileage=" + mileage + ", price=" + price + ", transmission=" + transmission + ", year=" + year + ", created=" + created + ", modified=" + modified + " }";
    }
}
