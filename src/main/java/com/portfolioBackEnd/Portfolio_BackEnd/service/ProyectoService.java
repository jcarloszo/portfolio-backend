/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Proyecto;
import com.portfolioBackEnd.Portfolio_BackEnd.repository.EducacionRepository;
import com.portfolioBackEnd.Portfolio_BackEnd.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZURITA
 */

@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    private ProyectoRepository repoProy;
    
    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> listaProyecto = repoProy.findAll(Sort.by("posicion").descending());
        return listaProyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        repoProy.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        repoProy.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return repoProy.findById(id).orElse(null);
    }
    
}
