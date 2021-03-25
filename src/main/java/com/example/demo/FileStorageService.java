package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    public void initializeDir() {
        try {
            Files.createDirectory(Paths.get("uploads"));
        } catch(IOException ex) {
            ex.getMessage();
        }
    }

    public void saveFile(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), Paths.get("uploads").resolve(file.getOriginalFilename()));
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
}
