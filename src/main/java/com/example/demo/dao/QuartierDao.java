package com.example.demo.dao;

import com.example.demo.bean.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartierDao extends JpaRepository<Quartier,Long> {
    Quartier findByCode(Double code);

    int deleteByCode(Double code);

}
