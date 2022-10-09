/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Usuario;
import com.portfolioBackEnd.Portfolio_BackEnd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZURITA
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository userRepository;
    
    @Override
    public boolean validarUsuario(Usuario usuario) {
        Usuario user = userRepository.findById(usuario.getEmail()).orElse(null);
        return user != null && user.getPassword().equals(usuario.getPassword());
    }
}
