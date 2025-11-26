package kr.kro.moonlightmoist.shopapi.order.service;

import kr.kro.moonlightmoist.shopapi.order.domain.Order;
import kr.kro.moonlightmoist.shopapi.order.domain.OrderProduct;
import kr.kro.moonlightmoist.shopapi.order.dto.OrderProductRequestDTO;
import kr.kro.moonlightmoist.shopapi.order.dto.OrderRequestDTO;
import kr.kro.moonlightmoist.shopapi.order.dto.OrderResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    Long createOrder(OrderRequestDTO dto, Long userId);
    List<OrderResponseDTO> getOrder(Long userId);

}
