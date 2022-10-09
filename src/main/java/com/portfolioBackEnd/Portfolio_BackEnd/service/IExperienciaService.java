/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Experiencia;
import java.util.List;

/**
 *
 * @author ZURITA
 */
public interface IExperienciaService {
    public List<Experiencia> getExperiencias();
    public void saveExperiencia(Experiencia experiencia);
    public void deleteExperiencia(Long id);
    public Experiencia findExperiencia(Long id);
}
