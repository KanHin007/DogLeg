package com.hb.common.crypto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.util.Date;

@Slf4j
public class JwtUtils {

    public static final String SUBJECT = "demo";

    //过期时间，毫秒，一周
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    //秘钥
    public static final String APPSECRET = "hb007007";

    public static String generateToken(Long userId) {

        if (userId == null) {
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();

        return token;

    }

    public static Claims parseToken(String token) {
        Claims claims = null;
        try {
            if (token != null && !"".equals(token.trim())) {
                claims = Jwts.parser().setSigningKey(APPSECRET).
                        parseClaimsJws(token).getBody();
            }
        }catch (Exception e){
            log.error("JwtUtils parseToken occur a error {}", ExceptionUtils.getFullStackTrace(e));
        }
        return claims;
    }


    public static void main(String[] args) {
        System.out.println(generateToken(1L));
        System.out.println(parseToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvbmVoZWUiLCJpZCI6MSwiaWF0IjoxNTc2NTAwNDk4LCJleHAiOjE1NzcxMDUyOTh9.rXKeOIS-K_DkjT93fH33v82r-rHZZjjWUAPEHwEywSE"));
    }

}
