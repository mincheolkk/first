package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity; //Entity 클래스에 추가한다

import javax.persistence.*;

@Getter  // 롬복 어노테이션 , Getter 메소드 자동생성
@NoArgsConstructor  // 롬복 어노테이션 , 기본 생성자 자동추가
@Entity  // 테이블과 연결될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id // 테이블의 pk필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야 auto_increment 가 도미.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 롬복 어노테이션 , 해당 클래스의 빌더 패턴 클래스 생성 및 생성자 상단에 선언 시 생상자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
