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

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable=false)
    private Model model;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "description")
    private String description;
    @Column(name = "engine")
    private EngineType engine;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "mileage")
    private int mileage;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "transmission")
    private TransmissionType transmission;
    @Column(name = "year")
    private int year;
    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;
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
