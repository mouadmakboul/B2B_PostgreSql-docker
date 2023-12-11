package com.example.B2B.Repositories;

import com.example.B2B.Entities.lignecommandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface lignecommandeRepo extends JpaRepository<lignecommandeEntity, Long> {
}
