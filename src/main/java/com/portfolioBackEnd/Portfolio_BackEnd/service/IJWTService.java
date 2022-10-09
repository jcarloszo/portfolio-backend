/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ZURITA
 */
public interface IJWTService {
    public String GenerateToken(Usuario user);
    public boolean validateToken(String token);
    public String getToken(String header);
}
