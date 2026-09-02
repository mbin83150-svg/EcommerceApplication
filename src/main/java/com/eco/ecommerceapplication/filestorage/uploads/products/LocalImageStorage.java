package com.eco.ecommerceapplication.filestorage.uploads.products;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class LocalImageStorage {
    // To alot a location
    @Value("${app.upload.dir:uploads/products}")
    private String uploadDir;


    public List<String> store(MultipartFile[] files) {
        List<String> storePaths = new ArrayList<>();
        try {
            Path dir = Paths.get(uploadDir);
            Files.createDirectories(dir);
            for (MultipartFile file : files) {
               if (file.isEmpty()) continue;
               
               
               
               
               String extension = getExtension(file.getOriginalFilename());
               
               
               
               
               
               String filename = UUID.randomUUID() + extension;
                Path target = dir.resolve(filename);

    Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

    storePaths.add("/" + uploadDir + "/" + filename);   
}
        } catch (IOException e) {
            throw new RuntimeException("Failed to Store Image ", e);

        }
        return storePaths;
    }
    private String getExtension(String originalFilename) {
        if (originalFilename == null ||
                !originalFilename.contains(".")) return "";
    return originalFilename.substring(originalFilename.lastIndexOf("."));
    }
}


