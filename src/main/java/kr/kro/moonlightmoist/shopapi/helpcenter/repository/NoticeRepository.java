package kr.kro.moonlightmoist.shopapi.helpcenter.repository;

import kr.kro.moonlightmoist.shopapi.helpcenter.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
