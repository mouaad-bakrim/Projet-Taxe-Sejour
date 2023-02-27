package com.example.demo.service.facade;

import com.example.demo.bean.Quartiere;
import org.springframework.stereotype.Service;

import java.util.List;
public interface QuartiereService {
    public Quartiere findByCode(Double code);
    List<Quartiere> findAll();
     int save(Double code);
    public List<Quartiere> findBySecteurNom(String nom);
     int deleteByCode(Double code);
}
