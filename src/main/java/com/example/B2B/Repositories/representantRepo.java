package com.example.B2B.Repositories;
import com.example.B2B.Entities.representantEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface representantRepo extends JpaRepository<representantEntity, Long> {
}
