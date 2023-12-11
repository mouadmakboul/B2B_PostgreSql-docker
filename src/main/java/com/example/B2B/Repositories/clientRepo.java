package com.example.B2B.Repositories;

import com.example.B2B.Entities.categoryproductEntity;
import com.example.B2B.Entities.clientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface clientRepo extends JpaRepository<clientEntity, Long> {
}
