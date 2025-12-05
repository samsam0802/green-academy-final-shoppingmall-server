package kr.kro.moonlightmoist.shopapi.helpcenter.service;

import jakarta.transaction.Transactional;
import kr.kro.moonlightmoist.shopapi.helpcenter.domain.Inquiry;
import kr.kro.moonlightmoist.shopapi.helpcenter.domain.InquiryStatus;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryCreateRequest;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryCreateResponse;
import kr.kro.moonlightmoist.shopapi.helpcenter.repository.InquiryRepository;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryServiceImpl implements InquiryService{

    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;

    @Override
    public InquiryCreateResponse registerInquiry(InquiryCreateRequest createRequest) {

        User user = userRepository.findByLoginId(createRequest.getLoginId())
                .orElseThrow(()-> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        Inquiry createInquiry = Inquiry.builder()
                .user(user)
                .title(createRequest.getTitle())
                .content(createRequest.getContent())
                .inquiryType(createRequest.getInquiryType())
                .emailAgreement(createRequest.isEmailAgreement())
                .smsAgreement(createRequest.isSmsAgreement())
                .inquiryStatus(InquiryStatus.PENDING)
                .visible(true)
                .answered(false)
                .build();

        inquiryRepository.save(createInquiry);

        return InquiryCreateResponse.builder()
                .success(true)
                .message("문의가 정상적으로 등록 되었습니다.")
                .build();
    }
}
