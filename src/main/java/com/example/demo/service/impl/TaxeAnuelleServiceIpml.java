package com.example.demo.service.impl;

import com.example.demo.bean.Locale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.bean.TaxeAnuelle;
import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.dao.TaxeAnuelleDao;
import com.example.demo.service.facade.TaxeAnuelleService;
import com.example.demo.service.util.DateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaxeAnuelleServiceIpml implements TaxeAnuelleService {
    @Autowired
    private TaxeAnuelleDao taxeAnuelleDao;
    @Autowired
    private TaxeTrimestrielServiceImpl taxeTrimestrielServiceImpl;


    public List<TaxeAnuelle> findByRedevableCin(Long cin) {
        return taxeAnuelleDao.findByRedevableCin(cin);
    }

    public List<TaxeAnuelle> findByLocaleRef(Long ref) {
        return taxeAnuelleDao.findByLocaleRef(ref);
    }

    public TaxeAnuelle findByAnnee(int annee) {
        return taxeAnuelleDao.findByAnnee(annee);
    }

    @Transactional
    public int deleteByAnnee(int annee) {
        return taxeAnuelleDao.deleteByAnnee(annee);
    }

    @Override
    public int save(TaxeAnuelle taxeAnuelle) {
        return 0;
    }

    @Autowired
    TaxeTrimestrielServiceImpl TaxeTrimestrielServiceImpl;
    @Autowired
    TauxTaxeTrimestrielServiceImpl tauxTaxeTrimestrielService;
    @Autowired
    LocaleServiceImpl localeServiceImpl;

    public int save(String cin, String ref, int annee, LocalDateTime datePresentation) {


        TaxeTrimestriel taxeTrimestriel1 = TaxeTrimestrielServiceImpl.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 1, annee);
        TaxeTrimestriel taxeTrimestriel2 = TaxeTrimestrielServiceImpl.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 2, annee);
        TaxeTrimestriel taxeTrimestriel3 = TaxeTrimestrielServiceImpl.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 3, annee);
        TaxeTrimestriel taxeTrimestriel4 = TaxeTrimestrielServiceImpl.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, 4, annee);
        if (taxeTrimestriel1 == null) {
            return -1;
        } else if (taxeTrimestriel2 == null) {
            return -2;
        } else if (taxeTrimestriel3 == null) {
            return -3;
        } else if (taxeTrimestriel4 == null) {
            return -4;
        } else {

           return  1;
    }


}
}
