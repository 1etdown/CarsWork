package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByEmail(String email);

    Optional<Users> findByUserName(String username);

    Optional<Users> findUserByUserName(Users username);
}
