package com.example.demo.service;

import com.example.demo.bean.TaxeSejourTrimestriel;
import com.example.demo.dao.TaxeSejourTrimestrielDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
TaxeSejourTrimestrielService {

    @Autowired
    private TaxeSejourTrimestrielDao taxeSejourTrimestrielDao ;

    public TaxeSejourTrimestriel findByRedevableCinAndLocaleRefAndAnnee(String cin, String ref, int annee) {
        return taxeSejourTrimestrielDao.findByRedevableCinAndLocaleRefAndAnnee(cin, ref, annee);
    }

    public int DeleteByRedevableCinAndLocaleRefAndAnnee(String cin, String ref, int annee) {
        return taxeSejourTrimestrielDao.DeleteByRedevableCinAndLocaleRefAndAnnee(cin, ref, annee);
    }

    public List<TaxeSejourTrimestriel> findAll() {
        return taxeSejourTrimestrielDao.findAll();
    }





}
