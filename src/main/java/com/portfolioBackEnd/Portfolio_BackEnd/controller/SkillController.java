/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.controller;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Skill;
import com.portfolioBackEnd.Portfolio_BackEnd.service.IJWTService;
import com.portfolioBackEnd.Portfolio_BackEnd.service.ISkillService;
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
public class SkillController {
    @Autowired
    private ISkillService interSkill;
    
    @Autowired
    private IJWTService interJWT;
    
    @CrossOrigin("*")
    @GetMapping ("/skill/{id}")
    public Skill getSkill(@PathVariable Long id){
        return interSkill.findSkill(id);
    }
    
    @CrossOrigin("*") 
    @GetMapping ("/skill/traer")
    public List<Skill> getEducacions(){
        return interSkill.getSkill();
    }
    
    @CrossOrigin("*") 
    @PostMapping ("/skill/crear")
    public void createProyecto(@RequestHeader HttpHeaders headers, @RequestBody Skill skill) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interSkill.saveSkill(skill);
    }
    
    @CrossOrigin("*") 
    @DeleteMapping ("/skill/borrar/{id}")
    public void deletePersona(@RequestHeader HttpHeaders headers, @PathVariable Long id) throws Exception{
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        interSkill.deleteSkill(id);
    }
    
    @CrossOrigin("*") 
    @PutMapping ("/skill/editar/{id}")
    public Skill editPersona(@RequestHeader HttpHeaders headers, @PathVariable Long id, @RequestBody Skill skill) throws Exception
    {
        String token = interJWT.getToken(headers.getFirst("Authorization"));
        if(!interJWT.validateToken(token)) throw new Exception("Validation token failed");
        
        Skill nuevaSkill = interSkill.findSkill(id);
        
        nuevaSkill.setNombre(skill.getNombre());
        nuevaSkill.setProgreso(skill.getProgreso());
        nuevaSkill.setPosicion(skill.getPosicion());
        
        interSkill.saveSkill(nuevaSkill);
        return nuevaSkill;
    }
}
