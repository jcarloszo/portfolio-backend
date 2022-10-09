/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.controller;

import DTO.TokenDTO;
import com.portfolioBackEnd.Portfolio_BackEnd.model.Usuario;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IJWTService;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ZURITA
 */

@RestController
public class UserController {
    
    @Autowired
    private IUsuarioService interUsuario;
    
    @Autowired
    private IJWTService interJWT;
    
    @CrossOrigin("*") 
    @PostMapping ("/usuario/login")
    public TokenDTO validarUsuario(@RequestBody Usuario user){
        if (interUsuario.validarUsuario(user))
            return new TokenDTO(interJWT.GenerateToken(user), "OK");
        return new TokenDTO("", "FAILED");
    }
   
}
