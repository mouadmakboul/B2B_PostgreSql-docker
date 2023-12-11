package com.example.B2B.Repositories;



import com.example.B2B.Entities.commandeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface commandeRepo extends JpaRepository<commandeEntity, Long> {
}
