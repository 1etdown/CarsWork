package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.dtos.AddModelDto;
import com.example.springdatabasicdemo.models.Model;
import com.example.springdatabasicdemo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModelRepository extends JpaRepository<Model, UUID> {

     Optional<Object> findByName(String model) ;



}