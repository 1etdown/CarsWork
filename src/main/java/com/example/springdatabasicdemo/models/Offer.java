package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.Date;
import java.math.BigDecimal;
import java.util.UUID;
import com.example.springdatabasicdemo.enums.TransmissionType;
import com.example.springdatabasicdemo.enums.EngineType;
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    private String description;
    private EngineType engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private TransmissionType transmission;
    private int year;
    private Date created;
    private Date modified;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable=false)
    private Model model;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private Users user;



    public Offer(String description, EngineType engine, String imageUrl,int mileage,BigDecimal price,TransmissionType transmission,int year,Date created,Date modified) {
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

    protected Offer() {
    }

    public String getDescription() {
        return description;
    }

    public EngineType getEngine() {
        return engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public int getYear() {
        return year;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
