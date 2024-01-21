package com.example.springdatabasicdemo.dtos;

import com.example.springdatabasicdemo.enums.Category;

import java.util.Date;
import java.util.UUID;

public class ShowModelDto {
    private UUID id;
    private String name;
    private AddBrandDto brand;
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private Date created;
    private Date modified;

    public ShowModelDto(UUID id, String name, AddBrandDto brand, Category category, String imageUrl, Integer startYear, Integer endYear, Date created, Date modified) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
    }

    public ShowModelDto() {
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddBrandDto getBrand() {
        return brand;
    }

    public void setBrand(AddBrandDto brand) {
        this.brand = brand;
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


    @Override
    public String toString() {
        return "Model { id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", imageUrl=" + imageUrl + ", startYear=" + startYear + ", endYear=" + endYear + ", created=" + created + ", modified=" + modified + " }";
    }
}
