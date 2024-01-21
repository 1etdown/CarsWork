package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.HashSet;
import java.util.Set;
import com.example.springdatabasicdemo.enums.Role;
@Entity
@Table(name = "userRole")
public class UserRole extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, length = 50)
    private Role name;
    public UserRole(Role name) {
        this.name = name;
    }

    public UserRole() {
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}
