package kr.kro.moonlightmoist.shopapi.helpcenter.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class InquiryCreateResponse {

    private boolean success;
    private String message;

}
