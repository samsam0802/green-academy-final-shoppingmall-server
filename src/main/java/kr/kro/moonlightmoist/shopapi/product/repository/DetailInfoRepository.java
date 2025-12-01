package kr.kro.moonlightmoist.shopapi.product.repository;

import kr.kro.moonlightmoist.shopapi.product.domain.DetailInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailInfoRepository extends JpaRepository<DetailInfo, Long> {
}
