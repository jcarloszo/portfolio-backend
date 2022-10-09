/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Proyecto;
import java.util.List;

/**
 *
 * @author ZURITA
 */
public interface IProyectoService {
    public List<Proyecto> getProyecto();
    public void saveProyecto(Proyecto proyecto);
    public void deleteProyecto(Long id);
    public Proyecto findProyecto(Long id);
}
