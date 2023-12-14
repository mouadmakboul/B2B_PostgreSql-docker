package com.example.B2B.Repositories;


import com.example.B2B.Entities.contratEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface contratRepo extends JpaRepository<contratEntity, Long> {
    List<contratEntity> findByEntrepriseId(long entrepriseId);
}
