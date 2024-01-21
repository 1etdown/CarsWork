package com.example.springdatabasicdemo.dtos;
import com.example.springdatabasicdemo.enums.EngineType;
import com.example.springdatabasicdemo.enums.TransmissionType;
import com.example.springdatabasicdemo.models.Users;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


public class AddOfferDto {
    private UUID id;
    private AddModelDto model;
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


    public AddOfferDto(UUID id, AddModelDto model, String user, String description, EngineType engine, String imageUrl, int mileage, BigDecimal price, TransmissionType transmission, int year, Date created, Date modified) {
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

    public AddOfferDto() {
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AddModelDto getModel() {
        return model;
    }

    public void setModel(AddModelDto model) {
        this.model = model;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public void setCurrentUser(String user) {
        this.user = user;
    }
    @NotEmpty(message = "Description must not be null or empty!")
    @Size(min = 10, max =300 , message = "Description must be between 2 and 30 characters!")
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
    @NotEmpty(message = "Image Url must not be null or empty!")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @NotNull(message = "Mileage must not be null or empty!")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    @NotNull(message = "Price must not be null or empty!")
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
