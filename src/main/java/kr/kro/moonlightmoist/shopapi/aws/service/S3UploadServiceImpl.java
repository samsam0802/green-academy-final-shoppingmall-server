package kr.kro.moonlightmoist.shopapi.aws.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class S3UploadServiceImpl implements S3UploadService {

    private final Cloudinary cloudinary;

    @Override
    public String uploadOneFile(MultipartFile file, String path) { // path 예시 : "products/"
        try {
            if (file.isEmpty()) {
                throw new IllegalArgumentException("파일이 비어있습니다.");
            }

            String publicId = path + UUID.randomUUID();

            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap("public_id", publicId)
            );

            return (String) uploadResult.get("secure_url");

        } catch (Exception e) {
            log.error("파일 업로드 실패 : {} ", e.getMessage(), e);
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }
}