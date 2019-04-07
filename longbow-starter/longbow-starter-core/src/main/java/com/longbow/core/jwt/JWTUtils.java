package com.longbow.core.jwt;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {
    private static String secret = "abc12345678";
    private static Long expiration = 28800L; //默认8小时

    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (ExpiredJwtException e){
            claims = null;
        }catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private static Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    public static Date getIssuedDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getIssuedAt();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    public static Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public static JWTSubject getSubjectFromToken(String token) {
        JWTSubject jwtSubject;
        try {
            Claims claims = getClaimsFromToken(token);
            jwtSubject = JSON.parseObject(claims.getSubject(), JWTSubject.class);
        }catch (ExpiredJwtException e){
            jwtSubject = null;
        }catch (Exception e) {
            jwtSubject = null;
        }
        return jwtSubject;
    }

    public static String generateToken(JWTSubject subject) {
        return Jwts.builder()
                .setSubject(JSON.toJSONString(subject))
                .setExpiration(generateExpirationDate())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public static String refreshToken(String token) {
        String refreshedToken;
        try {
            final JWTSubject subject = getSubjectFromToken(token);
            refreshedToken = generateToken(subject);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public static Boolean validateToken(String token) {
        try {
            final Date expiration = getExpirationDateFromToken(token);
            return expiration.after(new Date());
        } catch (Exception e) {
        }
        return false;
    }
}