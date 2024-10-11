package com.example.booking_up.service;

import com.example.booking_up.entity.Images;
import com.example.booking_up.repository.ImagesRepository;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImagesService {

    private final ImagesRepository imagesRepository;
    private final Storage storageService;

    //  @Value("${spring.gcp.storage.bucket}")
    private final String bucketName = "bucket-booking";



    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName).build();
        storageService.create(blobInfo, file.getBytes());

        String fileUrl = String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);
        //https://storage.googleapis.com/bucket-booking/text.txt

        Images fileLink = new Images();
        fileLink.setName(fileName);
        fileLink.setUrl(fileUrl);
        imagesRepository.save(fileLink);

        return fileUrl;
    }
}
