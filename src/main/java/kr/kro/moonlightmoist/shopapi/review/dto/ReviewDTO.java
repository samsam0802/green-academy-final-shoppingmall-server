package kr.kro.moonlightmoist.shopapi.review.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class ReviewDTO {
    private Long id;
    private String content;
    private int rating;
    private Long userId;
    private String loginId;
    private Long productId;
    private Long orderId;
    private String productImage;
    private String productName;
    private String brandName;
    private LocalDateTime createdAt;
    private LocalDateTime purchaseDate;
    @Builder.Default
    private List<String> imageUrls = new ArrayList<>();
    @Builder.Default
    private List<String> deleteImgUrls = new ArrayList<>();

}
