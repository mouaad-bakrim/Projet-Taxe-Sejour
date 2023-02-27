package com.example.demo.dao;

import com.example.demo.bean.Rue;
import com.example.demo.bean.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RueDao extends JpaRepository<Rue,Long> {
    List<Rue> findAll();

    Rue findByCode(Double code);
     int deleteByCode(Double code);
}
