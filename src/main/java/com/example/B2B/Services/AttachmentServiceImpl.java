package com.example.B2B.Services;

import com.example.B2B.Entities.Attachment;
import com.example.B2B.Repositories.AttachmentRepo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service

public class AttachmentServiceImpl implements AttachmentService {
    private AttachmentRepo ar;

    public AttachmentServiceImpl(AttachmentRepo ar) {
        this.ar = ar;
    }

    @Override
    public Attachment saveAttachement(MultipartFile file) throws Exception {

        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")){
                throw new Exception("filename contains invalid sequence path"+fileName);
            }
            Attachment attachment=new Attachment(fileName,file.getContentType(),file.getBytes());
            return ar.save(attachment);


        }catch(Exception e) {
            throw new Exception("could not save file " + fileName);


        }
    }

    @Override
    public Attachment getAttachment(String fileID) throws Exception {
        return ar.findById(fileID).orElseThrow(()->new Exception("File not found with id "+fileID));
    }
}
