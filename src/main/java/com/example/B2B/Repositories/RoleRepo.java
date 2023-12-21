package com.example.B2B.Repositories;

import com.example.B2B.Entities.ERole;
import com.example.B2B.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepo extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);

}