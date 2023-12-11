package com.example.B2B.Services;

import com.example.B2B.Entities.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachement(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileID) throws Exception;
}
