package kr.kro.moonlightmoist.shopapi.product.repository;

import kr.kro.moonlightmoist.shopapi.product.domain.SearchHistory;
import kr.kro.moonlightmoist.shopapi.product.dto.SearchPopularKeywordResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {

    // 회원 ID를 기준으로 최근 검색한 키워드 10개 (중복 제거는 Service에서 처리)
    @Query(value = "SELECT * FROM search_histories " +
                   //search_histories 테이블의 모든 컬럼을 가져온다
            "WHERE user_id = :userId " +
            //회원ID가 userId인 검색 기록만 필터링
            "ORDER BY created_at DESC " +
            //최신 순으로 정렬
            "LIMIT 20", nativeQuery = true) //최대 20개만 가져옴
            //중복이 있어도 충분히 가져와서 Service에서 중복 제거 후 최근 10개만 보여주기 위해 20개를 가져온다
    List<SearchHistory> findByUserId10Searched(@Param("userId") Long userId);

    // 세션 식별자를 기준으로 최근 검색한 키워드 10개 (중복 제거는 Service에서 처리)
    @Query(value = "SELECT * FROM search_histories " +
            "WHERE session_identifier = :sessionIdentifier " +
            //해당 세션에 해당하는 검색 기록만 필터링
            "ORDER BY created_at DESC " +
            "LIMIT 20", nativeQuery = true)
    List<SearchHistory> findBySessionIdentifier10Searched(@Param("sessionIdentifier") String sessionIdentifier);

    // 실시간 인기 검색어 (최근 24시간 기준)
    @Query(value = "SELECT keyword, COUNT(*) as count " +
                   //키워드별 검색 횟수를 계산
            "FROM search_histories " +
            "WHERE created_at > DATE_SUB(NOW(), INTERVAL 24 HOUR) " +
            //24시간 이내 검색 기록만 포함
            "GROUP BY keyword " +
            //같은 키워드는 하나의 group로 묶는다
            "ORDER BY count DESC " +
            //많이 검색된 순서
            "LIMIT 10", nativeQuery = true)
            //상위 10개만 가져오기
    List<Object[]> findPopularKeywords();
}
