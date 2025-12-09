package kr.kro.moonlightmoist.shopapi.product.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchRecentKeywordResponseDTO {
    private String keyword;
    private LocalDateTime createdAt;
}
