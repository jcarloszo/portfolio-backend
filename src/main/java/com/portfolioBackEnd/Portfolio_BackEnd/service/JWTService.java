/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Usuario;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import lombok.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZURITA
 */

@Service
public class JWTService implements IJWTService {

    private final String secret = "fsd46FD45674g46abzup5478SJOIJkjnklh454543875e65r4w4d564aw65e4r65k45io4piu654oi5uf6g4s56d4as56c1x5b465df4gs65df4dz65f465gj1sszokdsd4as98r7f45f874df65g48ew4j65d4hs5d64K654ASD5FeFDF4464F4F4HkjhLJKSAfFFDSWE";
    //@Value("${jwt.expiration}")
    private final int expiration = 21600;
    
    @Override
    public String GenerateToken(Usuario user) {
        return Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } 
        catch(Exception ex) {
            return false;
        }
    }

    @Override
    public String getToken(String header) {
        if(header != null && header.startsWith("Bearer")){
            return header.replace("Bearer ", "");
        }
        return null;
    }
}
