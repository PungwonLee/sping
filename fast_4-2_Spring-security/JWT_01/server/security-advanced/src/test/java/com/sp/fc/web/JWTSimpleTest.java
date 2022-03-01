package com.sp.fc.web;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Base64;
import java.util.Map;

public class JWTSimpleTest {

    private void printToken(String token){
        String[] tokens = token.split("\\.");
        System.out.println("header: "+new String(Base64.getDecoder().decode(tokens[0])));
        System.out.println("body: "+new String(Base64.getDecoder().decode(tokens[1])));
    }

    @DisplayName("1. jjwt 를 이용한 토큰 테스트")
    @Test
    void test_1() {
        String okta_token = Jwts.builder().addClaims(
                        Map.of("name", "pungwon", "price", 3000)
                ).signWith(SignatureAlgorithm.HS256, "pungwon")
                .compact();
        System.out.println("okta_token = " + okta_token);
        // "헤더"."바디"."헤더와바디 해쉬화 으로 구성됨
        printToken(okta_token);
    }


    @DisplayName("2. java-jwt 를 이용한 토큰 테스트")
    @Test
    void test_2() {

    }


}
