
package com.example.springdatabasicdemo.models;
import java.util.Date;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.HashSet;
import java.util.Set;
import com.example.springdatabasicdemo.enums.Category;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    private String name;
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private Date created;
    private Date modified;
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @ManyToOne(optional = false)

    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable=false)
    private Brand brand;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Offer> offers;


    public Model(String name, Category category, String imageUrl, Integer startYear, Integer endYear, Date created, Date modified) {
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.offers = new HashSet<>();

    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Model() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
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
    public Set<Offer> getOffers() {
        return offers;
    }
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }




}


