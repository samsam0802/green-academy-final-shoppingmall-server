package kr.kro.moonlightmoist.shopapi.order.repository;

import kr.kro.moonlightmoist.shopapi.order.domain.Order;
import kr.kro.moonlightmoist.shopapi.order.dto.OrderSearchCondition;

import java.util.List;

public interface OrderCustomRepository {
    List<Order> search(OrderSearchCondition condition);
}
