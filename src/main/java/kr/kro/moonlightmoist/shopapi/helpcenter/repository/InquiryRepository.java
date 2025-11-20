package kr.kro.moonlightmoist.shopapi.helpcenter.repository;

import kr.kro.moonlightmoist.shopapi.helpcenter.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
}
