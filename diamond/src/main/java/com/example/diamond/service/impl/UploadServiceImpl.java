package com.example.diamond.service.impl;

import com.example.diamond.service.UploadService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.lang.annotation.Annotation;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    ServletContext app;

    private final String UPLOAD_ROOT = "D:/duanCaNhan/diamond/backend/diamond/";

    @Override
    public File save(MultipartFile file, String folder) {
        File dir = new File(UPLOAD_ROOT + folder);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String s = System.currentTimeMillis() + file.getOriginalFilename();
        String name = Integer.toHexString(s.hashCode()) + s.substring(s.lastIndexOf("."));
        try {
            File savedFile = new File(dir, name);
            file.transferTo(savedFile);
            System.out.println(savedFile.getAbsolutePath());
            return savedFile;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
