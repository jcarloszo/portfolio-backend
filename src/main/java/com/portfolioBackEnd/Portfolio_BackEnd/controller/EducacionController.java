/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.controller;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Educacion;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IEducacionService;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IJWTService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService interEducacion;
    
    @Autowired
    private IJWTService interJWT;
    
    @CrossOrigin("*")
    @GetMapping ("/educacion/{id}")
    public Educacion getEducacion(@PathVariable Long id){
        return interEducacion.findEducacion(id);
    }
    
    @CrossOrigin("*") 
    @GetMapping ("/educacion/traer")
    public List<Educacion> getEducacions(){
        return interEducacion.getEducacion();
    }
    
    @CrossOrigin("*") 
    @PostMapping ("/educacion/crear")
    public void createExperiencia(@RequestHeader HttpHeaders headers, @RequestBody Educacion edu) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interEducacion.saveEducacion(edu);
    }
    
    @CrossOrigin("*") 
    @DeleteMapping ("/educacion/borrar/{id}")
    public void deletePersona(@RequestHeader HttpHeaders headers, @PathVariable Long id) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interEducacion.deleteEducacion(id);
    }
    
    @CrossOrigin("*") 
    @PutMapping ("/educacion/editar/{id}")
    public Educacion editPersona(@RequestHeader HttpHeaders headers, @PathVariable Long id, @RequestBody Educacion educacion) throws Exception
    {
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        
        Educacion nuevaEdu = interEducacion.findEducacion(id);
        nuevaEdu.setNombreInstitucion(educacion.getNombreInstitucion());
        nuevaEdu.setTitulo(educacion.getTitulo());
        nuevaEdu.setUrlImagen(educacion.getUrlImagen());
        nuevaEdu.setFechaInicio(educacion.getFechaInicio());
        nuevaEdu.setFechaFin(educacion.getFechaFin());
        nuevaEdu.setPosicion(educacion.getPosicion());
        
        interEducacion.saveEducacion(nuevaEdu);
        return nuevaEdu;
    }
}
