package org.example.domuksa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity // 이 클래스는 JPA가 관리하는 엔티티다!!
@Getter // getter를 자동 생성! Entity는 보통 값을 꺼내는 일이 많아서 필수임!
@NoArgsConstructor // 파라미터 없는 기본 생성자를 만들어줌!
@AllArgsConstructor // 모든 필드를 받는 생성자를 자동 생성.
@Builder // 빌더 패턴 제공.
/*
User user = User.builder()
    .username("parkhs")
    .password("1234")
    .email("park@hgu.ac.kr")
    .name("박해석")
    .build();
    순서 상관없음. 필요한 것만 설정 가능.
    외부에서 객체를 만들 때 쓰라고 달아둔 것.
 */
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     /*
    @Id : 이 필드가 PK라는 뜻
    @GeneratedValue : PK를 자동으로 생성하라는 뜻
     */

    @Column(nullable = false, length = 30)
    private String name;
    //  @Column(nullable = false, length = 30) : DB컬럼에 NOT NULL 제약을 걸어둔다. 즉 name은 무조건 있어야 함!!
    // 길이는 30처럼 제한을 걸어둔다.

    @Column(nullable = false, unique = true, length = 50)
    private String email;
    // unique = true : DB에서 중복 제약. 같은 이메일 두 번 저장 못하게 함!

    // 구글 고유 ID (sub)
    // 기존 회원들은 null일 수 있으므로 nullable 허용
    @Column(unique = true, length = 50)
    private String googleSub;


    // 변경 로직은 엔티티에 모아두면 유지보수에 좋음.
    public void updateName(String name) {
        this.name = name;
    }


    //  구글 로그인 시 사용
    public void updateOAuthProfile(String name) {
        this.name = name;
    }

    public void connectGoogle(String googleSub) {
        this.googleSub = googleSub;
    }

    /* 왜 변경 로직을 repository에 두면 안될까?
    repository는 DB에서 무엇을 할지 실행만 한다. 판단, 규칙 X.

     */
}
