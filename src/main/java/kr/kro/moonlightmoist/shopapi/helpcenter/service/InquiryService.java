package kr.kro.moonlightmoist.shopapi.helpcenter.service;


import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryCreateRequest;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryCreateResponse;

public interface InquiryService {
    InquiryCreateResponse registerInquiry (InquiryCreateRequest createRequest);
}
