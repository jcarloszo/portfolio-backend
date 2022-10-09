/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.repository;

import com.portfolioBackEnd.Portfolio_BackEnd.model.SobreMi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ZURITA
 */
@Repository
public interface SobreMiRepository extends JpaRepository <SobreMi, Long> {
    
}
