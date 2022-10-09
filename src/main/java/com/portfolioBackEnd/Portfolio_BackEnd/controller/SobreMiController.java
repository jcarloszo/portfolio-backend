/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.controller;

import com.portfolioBackEnd.Portfolio_BackEnd.model.SobreMi;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IJWTService;
import com.portfolioBackEnd.Portfolio_BackEnd.service.ISobreMiService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ZURITA
 */

@RestController
public class SobreMiController {
    
    @Autowired
    private ISobreMiService sobreMiService;
    
    @Autowired
    private IJWTService interJWT;
    
    @CrossOrigin("*") 
    @GetMapping ("/sobremi")
    public SobreMi getSobreMi(){
        return sobreMiService.getSobreMi();
    }
    
    @CrossOrigin("*") 
    @PutMapping ("/sobremi/editar")
    public SobreMi editSobreMi(@RequestHeader HttpHeaders headers, @RequestBody SobreMi sobreMiNuevo) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        
        SobreMi sobreMi = sobreMiService.getSobreMi();
        sobreMi.setTitulo(sobreMiNuevo.getTitulo());
        sobreMi.setDescripcion(sobreMiNuevo.getDescripcion());
        sobreMi.setUrlAvatar(sobreMiNuevo.getUrlAvatar());
        sobreMi.setUrlFondo(sobreMiNuevo.getUrlFondo());
        sobreMiService.updateSobreMi(sobreMi);
        return sobreMi;
    }
}
