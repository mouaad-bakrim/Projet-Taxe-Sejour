package com.example.demo.dao;

import com.example.demo.bean.TaxeSejourTrimestriel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxeSejourTrimestrielDao extends JpaRepository<TaxeSejourTrimestriel, Long> {

    TaxeSejourTrimestriel findByRedevableCinAndLocaleRefAndtAndTrimestre(String cin, String ref, int trimestre);

    TaxeSejourTrimestriel findByLocaleRefAndTrimestre(String ref, int trimestre);


    int DeleteByRedevableCinAndLocaleRefAndtrimestre(String cin, String ref, int trimestre);


}
