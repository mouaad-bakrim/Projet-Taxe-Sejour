package com.example.demo.dao;

import com.example.demo.bean.TauxTaxeTrimestriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface TauxTaxeTrimestrielDao extends JpaRepository<TauxTaxeTrimestriel, Long> {

    TauxTaxeTrimestriel findByCategorieLocaleCodeAndDateBetween(String code , LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin ) ;

    TauxTaxeTrimestriel findByCategorieLocaleCode (String code);


    int deleteByCategorieLocaleCodeAndDateBetween(String code , LocalDateTime dateApplicationDebut, LocalDateTime dateApplicationFin ) ;


    int deleteByCategorieLocaleCode (String code);


}
