/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.SobreMi;
import com.portfolioBackEnd.Portfolio_BackEnd.repository.SobreMiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ZURITA
 */
@Service
public class SobreMiService implements ISobreMiService {

    @Autowired
    private SobreMiRepository sobreMiRepository;
    
    @Override
    public SobreMi getSobreMi() {
        return sobreMiRepository.findById(1L).orElse(null);
    }

    @Override
    public void updateSobreMi(SobreMi sobreMi) {
        sobreMiRepository.save(sobreMi);
    }
}
