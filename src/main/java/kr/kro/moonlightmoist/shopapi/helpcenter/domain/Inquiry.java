package kr.kro.moonlightmoist.shopapi.helpcenter.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import lombok.*;

@Entity
@Table(name = "inquiries")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inquiry extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // pk

    @Column(nullable = false)
    private String title;   // 문의 제목

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryType inquiryType;  // 문의 유형

    @Column(nullable = false)
    private String content;   // 문의내용

    @Builder.Default
    @Column(name = "is_answered")
    private boolean answered = false;   // 답변 완료여부

    @Column(nullable = true) // 처음엔 답변이 없음으로 true
    private String answerContent; // 답변내용

    @Builder.Default
    @Column(name = "is_visible")
    private boolean visible = true;   // 노출 여부

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private InquiryStatus inquiryStatus = InquiryStatus.PENDING; // 진행 상태

    private boolean emailAgreement; // 이메일알림동의

    private boolean smsAgreement; // sms 알림동의

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
