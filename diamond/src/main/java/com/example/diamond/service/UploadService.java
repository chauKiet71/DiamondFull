package com.example.diamond.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {

    File save(MultipartFile file, String folder);
}