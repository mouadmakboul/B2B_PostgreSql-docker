package com.example.B2B.Repositories;


import com.example.B2B.Entities.entrepriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface entrepriseRepo extends JpaRepository<entrepriseEntity, Long> {
}
