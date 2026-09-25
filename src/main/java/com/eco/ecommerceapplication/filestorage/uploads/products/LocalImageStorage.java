package com.eco.ecommerceapplication.filestorage.uploads.products;

<<<<<<< HEAD
import com.eco.ecommerceapplication.Exceptions.ImageStorageException;
=======
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
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
<<<<<<< HEAD
    @Value("${app.upload.dir:uploads/products}")
    private String uploadDir;

=======
    // To alot a location
    @Value("${app.upload.dir:uploads/products}")
    private String uploadDir;


>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
    public List<String> store(MultipartFile[] files) {
        List<String> storePaths = new ArrayList<>();
        try {
            Path dir = Paths.get(uploadDir);
            Files.createDirectories(dir);
            for (MultipartFile file : files) {
<<<<<<< HEAD
                if (file.isEmpty()) continue;

                String extension = getExtension(file.getOriginalFilename());
                String filename = UUID.randomUUID() + extension;
                Path target = dir.resolve(filename);

                Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
                storePaths.add("/" + uploadDir + "/" + filename);
            }
        } catch (IOException e) {
            throw new ImageStorageException("Failed to store image", e);
        }
        return storePaths;
    }

    private String getExtension(String originalFilename) {
        if (originalFilename == null || !originalFilename.contains(".")) return "";
        return originalFilename.substring(originalFilename.lastIndexOf("."));
=======
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
>>>>>>> 84bb21bb077be285a673840d5d72ab1c77390f50
    }
}


