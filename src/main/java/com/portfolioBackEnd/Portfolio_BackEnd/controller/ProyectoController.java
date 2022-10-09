/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.controller;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Proyecto;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IJWTService;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ZURITA
 */

@RestController
public class ProyectoController {
    @Autowired
    private IProyectoService interProyecto;
    
    @Autowired
    private IJWTService interJWT;
    
    @CrossOrigin("*")
    @GetMapping ("/proyecto/{id}")
    public Proyecto getEducacion(@PathVariable Long id){
        return interProyecto.findProyecto(id);
    }
    
    @CrossOrigin("*") 
    @GetMapping ("/proyecto/traer")
    public List<Proyecto> getEducacions(){
        return interProyecto.getProyecto();
    }
    
    @CrossOrigin("*") 
    @PostMapping ("/proyecto/crear")
    public void createProyecto(@RequestHeader HttpHeaders headers, @RequestBody Proyecto proy) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interProyecto.saveProyecto(proy);
    }
    
    @CrossOrigin("*") 
    @DeleteMapping ("/proyecto/borrar/{id}")
    public void deletePersona(@RequestHeader HttpHeaders headers, @PathVariable Long id) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interProyecto.deleteProyecto(id);
    }
    
    @CrossOrigin("*") 
    @PutMapping ("/proyecto/editar/{id}")
    public Proyecto editPersona(@RequestHeader HttpHeaders headers, @PathVariable Long id, @RequestBody Proyecto proyecto) throws Exception
    {
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        
        Proyecto nuevoProy = interProyecto.findProyecto(id);
        
        nuevoProy.setTitulo(proyecto.getTitulo());
        nuevoProy.setDescripcion(proyecto.getDescripcion());
        nuevoProy.setUrlImagen(proyecto.getUrlImagen());
        nuevoProy.setPosicion(proyecto.getPosicion());
      
        interProyecto.saveProyecto(nuevoProy);
        return nuevoProy;
    }
}
