package com.example.springdatabasicdemo.repositories;

import com.example.springdatabasicdemo.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import java.util.UUID;
import com.example.springdatabasicdemo.enums.Role;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UUID> {
     Optional<UserRole> findRoleByName(Role role);
}
