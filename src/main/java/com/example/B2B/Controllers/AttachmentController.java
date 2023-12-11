package com.example.B2B.Controllers;

import com.example.B2B.Entities.Attachment;
import com.example.B2B.Entities.ResponsaData;
import com.example.B2B.Services.AttachmentService;
import org.apache.coyote.Response;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController

public class AttachmentController {

    private AttachmentService as;

    public AttachmentController(AttachmentService as) {
        this.as = as;
    }

    @PostMapping("/upload")
    public ResponsaData uploadFile(@RequestParam ("file") MultipartFile file) throws Exception{
        Attachment  attachement=null;
        String downloadURI="";
        attachement=as.saveAttachement(file);
        downloadURI= ServletUriComponentsBuilder.fromCurrentContextPath().path("/download").
                path(attachement.getId()).toUriString();
        return new ResponsaData(attachement.getFileName(), downloadURI,file.getContentType(),file.getSize());
    }
    @GetMapping("/download/{fileID}")
    public ResponseEntity<Resource>  downloadFile (@PathVariable String fileID) throws Exception{
        Attachment attachment=null;
        attachment=as.getAttachment(fileID);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFileType())).
                header(HttpHeaders.CONTENT_DISPOSITION,"attachement; fileName=\""+attachment.getFileName()+"\"")
                .body(new ByteArrayResource(attachment.getData()));
    }



}
