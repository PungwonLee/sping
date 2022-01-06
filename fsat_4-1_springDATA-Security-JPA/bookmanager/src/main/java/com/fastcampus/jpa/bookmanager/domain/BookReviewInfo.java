package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)//상속ㅂ다는
@ToString(callSuper = true)//상속받는 클래스 슈퍼클래스의 정보를 포함시켜준다는 것

@Data
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

//    private Long bookId;
    @OneToOne(optional = false) //널을 허용하지 않겠다
    private Book book;

    private float averageReviewScore;

    private int reviewCount;
}
