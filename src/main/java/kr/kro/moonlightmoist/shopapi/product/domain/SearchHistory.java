package kr.kro.moonlightmoist.shopapi.product.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import lombok.*;


@Entity
@Table(name = "search_histories")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SearchHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = true)
    private String sessionIdentifier;

    @Column(nullable = false, length = 150)
    private String keyword;

}
