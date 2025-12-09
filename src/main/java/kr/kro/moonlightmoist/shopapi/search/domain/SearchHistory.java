//package kr.kro.moonlightmoist.shopapi.search.domain;
//
//import jakarta.persistence.*;
//import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Getter
//@Builder
//@Entity
//@Table(name="search_histories")
//@AttributeOverride(name = "createdAt", column = @Column(name = "searched_at",updatable = false,nullable = false))
//public class SearchHistory extends BaseTimeEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name="user_id", nullable = false)
////    // todo: User 클래스 만들어야함
////    private User user;
//    @Column(nullable = false)
//    private String keyword;
//
//}
