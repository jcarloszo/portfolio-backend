/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Experiencia;
import com.portfolioBackEnd.Portfolio_BackEnd.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZURITA
 */

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    private ExperienciaRepository repoExp;
    
    @Override
    public List<Experiencia> getExperiencias() {
        List<Experiencia> listaExperiencias = repoExp.findAll(Sort.by("posicion").descending());
        return listaExperiencias;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        repoExp.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        repoExp.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        return repoExp.findById(id).orElse(null);
    }
    
}
