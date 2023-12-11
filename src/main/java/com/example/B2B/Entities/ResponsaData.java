package com.example.B2B.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ResponsaData {
    public String fileName;
    private String downloadURL;
    private String fileType;
    private Long fileSize;

}
