package com.example.B2B.Repositories;

import com.example.B2B.Entities.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AttachmentRepo extends JpaRepository<Attachment,String> {
}
