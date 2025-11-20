package kr.kro.moonlightmoist.shopapi.user.repository;

import kr.kro.moonlightmoist.shopapi.user.domain.UserGrade;
import kr.kro.moonlightmoist.shopapi.util.EntityFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
class UserGradeRepositoryUnitTest {

    @Autowired
    private UserGradeRepository userGradeRepository;

    @Test
    @DisplayName("유저등급 생성테스트")
    public void createUserGrade() {
        UserGrade userGrade = EntityFactory.createUserGrade();
        UserGrade savedUserGrade = userGradeRepository.save(userGrade);

        assertThat(savedUserGrade.getGrade()).isEqualTo("BRONZE");
    }


//    @Test
//    @DisplayName("유저등급 수정테스트")
//    public void updateUserGrade() {
//
//
//    }

}