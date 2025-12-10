package kr.kro.moonlightmoist.shopapi.order.dto;

import kr.kro.moonlightmoist.shopapi.order.domain.OrderProductStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductResBySearch {
    private Long id;
    private String productName;
    private String productOptionName;
    private int quantity;
    private int totalAmount;
    private OrderProductStatus orderProductStatus;
}
