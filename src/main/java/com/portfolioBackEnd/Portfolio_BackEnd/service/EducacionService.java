/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Educacion;
import com.portfolioBackEnd.Portfolio_BackEnd.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZURITA
 */

@Service
public class EducacionService implements IEducacionService {

    @Autowired
    private EducacionRepository repoEdu;
    
    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> listaEducacion = repoEdu.findAll(Sort.by("posicion").descending());
        return listaEducacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        repoEdu.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        repoEdu.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        return repoEdu.findById(id).orElse(null);
    }
    
}
