package com.example.demo.dao;

import com.example.demo.bean.TauxTaxeTrimestriel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TauxTaxeTrimestrielDao extends JpaRepository<TauxTaxeTrimestriel, Long> {

    TauxTaxeTrimestriel findByCategorieCodeAndDateBetween(String code , LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin ) ;

    TauxTaxeTrimestriel findByCategorieLocaleCode (String code);

    @Transactional
    int deleteByCategorieCodeAndDateBetween(String code , LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin ) ;

    @Transactional
    int deleteByCategorieLocaleCode (String code);







}
