package com.example.restaurant.wishList.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListDto {
    private Integer index;
    private String title;               //가게명
    private String category;            //카테고리
    private String address;             //주소
    private String roadAddress;         //도로명주소
    private String homePageLink;        //홈페이지 링크주소
    private String imageLink;           //이미지 링크주소
    private boolean isVisit;            //방문 확인 체크
    private int visitCount;             //방문 횟수
    private LocalDateTime lastVisitData;//마지막 방문


}
