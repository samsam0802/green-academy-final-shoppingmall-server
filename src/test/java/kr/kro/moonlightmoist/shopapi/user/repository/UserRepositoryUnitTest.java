package kr.kro.moonlightmoist.shopapi.user.repository;


import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.domain.UserGrade;
import kr.kro.moonlightmoist.shopapi.user.domain.UserRole;
import kr.kro.moonlightmoist.shopapi.util.EntityFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
class UserRepositoryUnitTest { // 생성, 삭제, 수정, 제약조건

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGradeRepository userGradeRepository;

    @Test
    @DisplayName("유저생성 테스트")
    public void createUser() {

        UserGrade userGrade = UserGrade.builder()
                .grade("BRONZE")
                .minTotalPoints(0)
                .freeDeliveryMinAmount(30000)
                .description("브론즈는 혜택이 없습니다.")
                .disCountRate(0)
                .build();
        UserGrade savedUserGrade = userGradeRepository.save(userGrade);


        User newUser = User.builder()
                .loginId("user")
                .passwordHash("123123")
                .name("유저")
                .email("user@naver.com")
                .phoneNumber("01012345678")
                .postalCode("11111")
                .address("성남")
                .addressDetail("분당")
                .birthDate(LocalDate.of(2025,11,11))
                .emailAgreement(true)
                .smsAgreement(false)
                .userGrade(savedUserGrade)
                .userRole(UserRole.USER)
                .build();

        User savedUser = userRepository.save(newUser);

        assertThat(savedUser.getLoginId()).isEqualTo("user");
        assertThat(savedUser.getPasswordHash()).isEqualTo("123123");
        assertThat(savedUser.getName()).isEqualTo("유저");
        assertThat(savedUser.getEmail()).isEqualTo("user@naver.com");
        assertThat(savedUser.getPhoneNumber()).isEqualTo("01012345678");
        assertThat(savedUser.getPostalCode()).isEqualTo("11111");
        assertThat(savedUser.getAddress()).isEqualTo("성남");
        assertThat(savedUser.getAddressDetail()).isEqualTo("분당");
        assertThat(savedUser.getBirthDate()).isEqualTo(LocalDate.of(2025,11,11));
        assertThat(savedUser.isEmailAgreement()).isTrue();
        assertThat(savedUser.isSmsAgreement()).isFalse();
        assertThat(savedUser.getUserGrade().getGrade()).isEqualTo("BRONZE");
        assertThat(savedUser.getUserRole()).isEqualTo(UserRole.USER);
    }



    @Test
    @DisplayName("로그인 Id로 유저 조회하기")
    public void findByLoginId() {
        UserGrade userGrade = EntityFactory.createUserGrade();
        UserGrade saveUserGrade = userGradeRepository.save(userGrade);

        User user = EntityFactory.createUser(userGrade);
        User savedUser = userRepository.save(user);
        Optional<User> testUser = userRepository.findByLoginId("user");

        assertThat(testUser).isPresent();
        assertThat(testUser.get().getLoginId()).isEqualTo("user");
    }

    @Test
    @DisplayName("중복 로그인Id 저장테스트")
    public void duplicateLoginId() {
        UserGrade userGrade = EntityFactory.createUserGrade();
        UserGrade saveUserGrade = userGradeRepository.save(userGrade);

//        User user = EntityFactory.createUser(userGrade);
//        User savedUser = userRepository.save(user);

        User testUser = User.builder()
                .name("")
                .email("")
                .loginId("user")
                .userRole(UserRole.USER)
                .userGrade(userGrade)
                .birthDate(LocalDate.of(2025,11,11))
                .smsAgreement(true)
                .emailAgreement(true)
                .addressDetail("")
                .address("")
                .phoneNumber("")
                .passwordHash("")
                .postalCode("")
                .deleted(true)
                .deletedAt(LocalDate.of(2025,11,11))
                .build();
        User savedTestUser = userRepository.save(testUser);

    }


    @Test
    @DisplayName("유저 삭제테스트")
    public void deleteUser() {
        UserGrade userGrade = EntityFactory.createUserGrade();
        UserGrade saveUserGrade = userGradeRepository.save(userGrade);

        User user = EntityFactory.createUser(userGrade);
        User savedUser = userRepository.save(user);

        userRepository.deleteById(user.getId());

        assertThat(userRepository.findById(savedUser.getId())).isEmpty(); // 삭제 했을때
//        assertThat(userRepository.findById(savedUser.getId())).isNotEmpty(); // 등록 했을때

    }

//    @Test
//    @DisplayName("유저 수정테스트")
//    public void updateUser() {
//
//        UserGrade userGrade = EntityFactory.createUserGrade();
//        userGradeRepository.save(userGrade);
//
//        User user = EntityFactory.createUser(userGrade);
//        userRepository.save(user);
//
//        비즈니스 로직을 만들어서 수정하고싶은 필드만 변경할 수 있는 메서드를 만들어야하는데
//        프론트에서 Form을 받으면 해당 Form에 있는 데이터로 변경 해야하는데 이건 Builder나, Setter로 하면 되는것 아닌지
//
//
//        왜 아래 같은 메서드..?생성자 ? 를 만들어야하는지.
//
//        public void updateBasicInfo (String name, String phoneNumber, String email){
//            this.name = name;           // 기존 필드 수정
//            this.phoneNumber = phoneNumber;
//            this.email = email;
//        }
//
//    }

}
