/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.controller;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Experiencia;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService interExperiencia;
    
    @Autowired
    private IJWTService interJWT;
    
    @CrossOrigin("*")
    @GetMapping ("/experiencia/{id}")
    public Experiencia getExperiencia(@PathVariable Long id){
        return interExperiencia.findExperiencia(id);
    }
    
    @CrossOrigin("*") 
    @GetMapping ("/experiencia/traer")
    public List<Experiencia> getExperiencias(){
        return interExperiencia.getExperiencias();
    }
    
    @CrossOrigin("*") 
    @PostMapping ("/experiencia/crear")
    public void createExperiencia(@RequestHeader HttpHeaders headers, @RequestBody Experiencia exp) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interExperiencia.saveExperiencia(exp);
    }
    
    @CrossOrigin("*") 
    @DeleteMapping ("/experiencia/borrar/{id}")
    public void deletePersona(@RequestHeader HttpHeaders headers, @PathVariable Long id) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interExperiencia.deleteExperiencia(id);
    }
    
    @CrossOrigin("*") 
    @PutMapping ("/experiencia/editar/{id}")
    public Experiencia editPersona(@RequestHeader HttpHeaders headers, @PathVariable Long id, @RequestBody Experiencia experiencia) throws Exception
    {
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        
        Experiencia nuevaExp = interExperiencia.findExperiencia(id);
        nuevaExp.setNombreOrganizacion(experiencia.getNombreOrganizacion());
        nuevaExp.setUrlImagen(experiencia.getUrlImagen());
        nuevaExp.setPuesto(experiencia.getPuesto());
        nuevaExp.setDescripcionPuesto(experiencia.getDescripcionPuesto());
        nuevaExp.setFechaInicio(experiencia.getFechaInicio());
        nuevaExp.setFechaFin(experiencia.getFechaFin());
        nuevaExp.setPosicion(experiencia.getPosicion());
                
        interExperiencia.saveExperiencia(nuevaExp);
        return nuevaExp;
    }
}
