package com.example.demo.dao;


import com.example.demo.bean.TauxTaxeAnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TauxTaxeAnuelleDao extends JpaRepository<TauxTaxeAnuelle,Long> {



    TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(String code , String reference) ;

    TauxTaxeAnuelle findByCategorieLocaleCode (String code);

    int deleteByCategorieLocaleCode (String code);
    List<TauxTaxeAnuelle> findAll();
    int deleteById(int id);
    TauxTaxeAnuelle findByReference(String reference);
}

