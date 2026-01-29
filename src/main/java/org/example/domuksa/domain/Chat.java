package org.example.domuksa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity // 이 클래스는 JPA가 관리하는 엔티티다!!
@Getter // getter를 자동 생성! Entity는 보통 값을 꺼내는 일이 많아서 필수임!
@NoArgsConstructor // 파라미터 없는 기본 생성자를 만들어줌!
@AllArgsConstructor // 모든 필드를 받는 생성자를 자동 생성.
@Builder
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private String content;

}
