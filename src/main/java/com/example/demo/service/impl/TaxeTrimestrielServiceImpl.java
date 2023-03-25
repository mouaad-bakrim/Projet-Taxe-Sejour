package com.example.demo.service.impl;

import com.example.demo.bean.CategorieLocale;

import com.example.demo.bean.Locale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.dao.TaxeTrimestrielDao;
import com.example.demo.service.facade.TaxeTrimestrielService;
import com.example.demo.service.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaxeTrimestrielServiceImpl implements TaxeTrimestrielService {

    @Autowired
    private TaxeTrimestrielDao taxeTrimestrielDao;

    @Autowired
    private LocaleServiceImpl localeService;

    @Autowired
    private TauxTaxeTrimestrielServiceImpl tauxTaxeTrimestrielService;




    @Override
    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielDao.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref,  trimestre);
    }

    @Override
    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(String cin, String ref, int trimestre, int annee) {
        return taxeTrimestrielDao.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, trimestre, annee);
    }

    public TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre, int annee) {
        return taxeTrimestrielDao.findByLocaleRefAndTrimestreAndAnnee(ref, trimestre, annee);
    }

    public int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielDao.deleteByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }


    public List<TaxeTrimestriel> findAll() {
        return taxeTrimestrielDao.findAll();
    }

    TauxTaxeTrimestriel tauxTaxeTrimestriel = new TauxTaxeTrimestriel();


    public int save(int trimest, String refLocale, int annee, LocalDateTime datePresentation) {
        Locale locale = localeService.findByRef(refLocale);
        if (locale == null) {
            return -1;
        }
        CategorieLocale categorieLocale = locale.getCategorieLocale();
        if (categorieLocale == null) {
            return -2;
        }
        tauxTaxeTrimestriel = tauxTaxeTrimestrielService.findByCategorieCodeAndDateBetween(categorieLocale.getCode(), tauxTaxeTrimestriel.getDateApplicationDebut(), tauxTaxeTrimestriel.getDateApplicationFin());
        if (tauxTaxeTrimestriel == null) {
            return -3;
        } else if (taxeTrimestrielDao.findByLocaleRefAndTrimestreAndAnnee(refLocale, trimest, annee) != null) {
            return -4;
        } else {
            TaxeTrimestriel taxeTrimestriel = new TaxeTrimestriel();
            double montantRetard = 0;
            double montantMajoration = 0;

            double montantBase = tauxTaxeTrimestriel.getMontantParNuite() * taxeTrimestriel.getNombreDeNuite();
            taxeTrimestriel.setMontantBase(montantBase);



            int nombreDeMoisRetard = DateUtil.calculateNbrMoisRetard(trimest, annee, datePresentation);
            if (nombreDeMoisRetard >= 1) {
                montantRetard = montantBase * tauxTaxeTrimestriel.getPourcentageRetard();
                montantMajoration = (nombreDeMoisRetard - 1) * tauxTaxeTrimestriel.getPourcentageMajoration() * montantBase;
            }


            double montantTotale = montantBase + montantRetard + montantMajoration;
            taxeTrimestriel.setTauxTaxeTrimestriel(tauxTaxeTrimestriel);
            taxeTrimestriel.setLocale(locale);
            taxeTrimestriel.setAnnee(annee);
            taxeTrimestriel.setTrimestre(trimest);
            taxeTrimestriel.setCategorieLocale(categorieLocale);
            taxeTrimestriel.setNombreDeMoisRetard(nombreDeMoisRetard);
            taxeTrimestriel.setMontantBase(montantBase);
            taxeTrimestriel.setMontantRetard(montantRetard);
            taxeTrimestriel.setMontantMajoration(montantMajoration);
            taxeTrimestriel.setMontantTotal(montantTotale);
            taxeTrimestrielDao.save(taxeTrimestriel);

            return 1;
        }




    }


}
