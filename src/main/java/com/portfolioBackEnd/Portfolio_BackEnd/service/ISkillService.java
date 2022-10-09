/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolioBackEnd.Portfolio_BackEnd.service;

import com.portfolioBackEnd.Portfolio_BackEnd.model.Skill;
import java.util.List;

/**
 *
 * @author ZURITA
 */
public interface ISkillService {
  public List<Skill> getSkill();
  public void saveSkill(Skill proyecto);
  public void deleteSkill(Long id);
  public Skill findSkill(Long id);  
}
