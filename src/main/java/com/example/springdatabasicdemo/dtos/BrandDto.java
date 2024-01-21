
package com.example.springdatabasicdemo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class BrandDto {

    private UUID id;
    private String name;
    private Date created;
    private Date modified;

    public BrandDto(UUID id, String name, Date created, Date modified) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    public BrandDto() {
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @NotEmpty(message = "Brand name must not be null or empty!")
    @Size(min = 2, max = 30, message = "Company name must be between 2 and 30 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Brand { id=" + id + ", name=" + name + ", created=" + created + ", modified=" + modified + " }";
    }
}

