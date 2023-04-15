package com.example.demo.dao;

import com.example.demo.bean.TaxeTrimestriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeTrimestrielDao extends JpaRepository<TaxeTrimestriel, Long> {

    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre);

    TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(String cin, String ref, int trimestre, int annee);


    TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre, int annee);

    int deleteById(int id);

    TaxeTrimestriel findByCategorieLocaleLibelle(String libelle);

    List<TaxeTrimestriel> findAll();

    TaxeTrimestriel findByTrimestreAndAnneeAndLocaleRef(int trimestre, int annee, String ref) ;

}

