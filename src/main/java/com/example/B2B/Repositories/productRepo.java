package com.example.B2B.Repositories;


import com.example.B2B.Entities.productEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface productRepo extends JpaRepository<productEntity, Long> {
}
