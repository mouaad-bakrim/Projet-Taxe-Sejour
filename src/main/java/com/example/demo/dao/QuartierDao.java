package com.example.demo.dao;

<<<<<<< HEAD

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
=======
import com.example.demo.bean.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartierDao extends JpaRepository<Quartier,Long> {
    Quartier findByCode(Double code);

    int deleteByCode(Double code);
>>>>>>> origin/main

}
