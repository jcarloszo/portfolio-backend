/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Skill;
import com.portfolioBackEnd.Portfolio_BackEnd.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZURITA
 */

@Service
public class SkillService implements ISkillService {

    @Autowired
    private SkillRepository repoSkill;
    
    @Override
    public List<Skill> getSkill() {
        List<Skill> listaSkill = repoSkill.findAll(Sort.by("posicion").descending());
        return listaSkill;
    }

    @Override
    public void saveSkill(Skill skill) {
        repoSkill.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        repoSkill.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        return repoSkill.findById(id).orElse(null);
    }
    
}
