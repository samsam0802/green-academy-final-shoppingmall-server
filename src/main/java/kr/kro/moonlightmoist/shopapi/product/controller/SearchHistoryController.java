package kr.kro.moonlightmoist.shopapi.product.controller;

import jakarta.servlet.http.HttpSession;
import kr.kro.moonlightmoist.shopapi.product.dto.SearchPopularKeywordResponseDTO;
import kr.kro.moonlightmoist.shopapi.product.dto.SearchRecentKeywordResponseDTO;
import kr.kro.moonlightmoist.shopapi.product.service.SearchHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/search")
@CrossOrigin(origins = "http://localhost:5173")
public class SearchHistoryController {

    private final SearchHistoryService searchHistoryService;

    @PostMapping("/add")
    public ResponseEntity<Void> searchAdd(
            @RequestParam String keyword,
            @RequestParam(required = false) Long userId,
            HttpSession session
    ) {
        //HttpSession : 웹에서 사용자를 구분하고 데이터를 잠깐 저장할 수 있는 공간
        //브라우저와 서버가 연결되어 있는 동안 유지되는 데이터 저장소
        //섹션 식별자를 서버가 기억하도록 해주는 역할

        //세션 ID 가져오기(비회원 식별)
        String sessionIdentifier = session.getId();

        log.info("==== add keyword: {}", keyword);
        log.info("==== add userId: {}", userId);

        //검색 기록 저장
        searchHistoryService.searchAdd(userId, sessionIdentifier, keyword);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/recent")
    public ResponseEntity<List<SearchRecentKeywordResponseDTO>> getRecentKeywords(
            @RequestParam(required = false) Long userId,
            HttpSession session
    ) {

        String sessionIdentifier = session.getId();

        log.info("==== recent userId: {}", userId);
        log.info("==== recent sessionId: {}", sessionIdentifier);

        List<SearchRecentKeywordResponseDTO> recentList =
                searchHistoryService.getRecentKeywordList(userId, sessionIdentifier);

        return ResponseEntity.ok(recentList);
    }

    @GetMapping("/popular")
    public ResponseEntity<List<SearchPopularKeywordResponseDTO>> getPopularKeywords() {

        List<SearchPopularKeywordResponseDTO> searchPopularKeywordResponseDTO =
                searchHistoryService.getPoularKeywordList();

        return ResponseEntity.ok(searchPopularKeywordResponseDTO);
    }
}
