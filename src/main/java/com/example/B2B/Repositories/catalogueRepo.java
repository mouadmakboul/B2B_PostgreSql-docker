package com.example.B2B.Repositories;

import com.example.B2B.Entities.catalogueEntity;
import com.example.B2B.Entities.categoryproductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface catalogueRepo extends JpaRepository<catalogueEntity, Long> {
}
