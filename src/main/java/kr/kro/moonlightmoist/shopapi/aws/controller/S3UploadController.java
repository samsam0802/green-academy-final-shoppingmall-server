package kr.kro.moonlightmoist.shopapi.aws.controller;

import kr.kro.moonlightmoist.shopapi.aws.service.S3UploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/s3")
@Slf4j
public class S3UploadController {

    private final S3UploadService s3UploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> s3upload(@ModelAttribute MultipartFile file) {

        log.info("s3upload file : {}", file);
        String s3url = s3UploadService.uploadOneFile(file, "products/");

        return ResponseEntity.ok(s3url);
    }
}