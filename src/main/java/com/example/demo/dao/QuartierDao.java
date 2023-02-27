package com.example.demo.dao;


import com.example.demo.bean.Quartiere;
import com.example.demo.bean.Rue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartierDao extends JpaRepository<Quartiere,Long> {
    List<Quartiere> findAll();
    public Quartiere findByCode(Double code);
     int deleteByCode(Double code);
   List<Quartiere> findBySecteurNom(String nom);

}
