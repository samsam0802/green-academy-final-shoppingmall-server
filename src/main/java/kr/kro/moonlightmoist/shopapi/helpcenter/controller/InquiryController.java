package kr.kro.moonlightmoist.shopapi.helpcenter.controller;


import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryCreateRequest;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryCreateResponse;
import kr.kro.moonlightmoist.shopapi.helpcenter.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inquiry")
@Slf4j
@CrossOrigin(origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE})
public class InquiryController {

    private final InquiryService service;

    @PostMapping("/add")
    public ResponseEntity<InquiryCreateResponse> createInquiry (@RequestBody InquiryCreateRequest request) {
        InquiryCreateResponse response = service.registerInquiry(request);
        return ResponseEntity.ok(response);
    }
}


