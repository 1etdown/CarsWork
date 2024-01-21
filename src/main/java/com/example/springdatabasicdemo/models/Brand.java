package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Model> model;


    @Column(name = "name")
    private String name;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    public Brand(String name, Date created, Date modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Brand() {
    }

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
    public Set<Model> getModels() {
        return model;
    }

    public void setModels(Set<Model> models) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "Brand { name=" + name + ", created=" + created + ", modified=" + modified + " }";
    }
}
