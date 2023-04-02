package com.example.demo.service.impl;

import com.example.demo.bean.*;
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
    @Autowired
    private RedevableServiceImpl redevableService;


    public int
    save(int trimestre, int annee, String refLocale, String cin, double nombreDeNuite, LocalDateTime datePresentation, String reference) {
        Locale locale = localeService.findByRef(refLocale);
        if (locale == null) {
            return -1;
        }
        CategorieLocale categorieLocale = locale.getCategorieLocale();

        Redevable redevable = redevableService.findByCin(cin);
        if (redevable == null) {
            return -2;
        }

        TauxTaxeTrimestriel tauxTaxeTrimestriel = tauxTaxeTrimestrielService.findByReference(reference);
        if (tauxTaxeTrimestriel == null) {
            return -3;
        } else if (taxeTrimestrielDao.findByLocaleRefAndTrimestreAndAnnee(refLocale, trimestre, annee) != null) {
            return -4;
        } else {
            TaxeTrimestriel taxeTrimestriel = new TaxeTrimestriel();
            double montantRetard = 0;
            double montantMajoration = 0;
            double montantBase = tauxTaxeTrimestriel.getMontantParNuite() * nombreDeNuite;



            int nombreDeMoisRetard = DateUtil.calculateNbrMoisRetard(trimestre, annee, datePresentation);
            if (nombreDeMoisRetard >= 1) {
                montantRetard = montantBase * tauxTaxeTrimestriel.getPourcentageRetard();
                montantMajoration = (nombreDeMoisRetard - 1) * tauxTaxeTrimestriel.getPourcentageMajoration() * montantBase;
            }


            double montantTotale = montantBase + montantRetard + montantMajoration;
            taxeTrimestriel.setTauxTaxeTrimestriel(tauxTaxeTrimestriel);
            taxeTrimestriel.setLocale(locale);
            taxeTrimestriel.setAnnee(annee);
            taxeTrimestriel.setNombreDeMoisRetard(nombreDeMoisRetard);
            taxeTrimestriel.setNombreDeNuite(nombreDeNuite);
            taxeTrimestriel.setTrimestre(trimestre);
            taxeTrimestriel.setCategorieLocale(categorieLocale);
            taxeTrimestriel.setNombreDeMoisRetard(nombreDeMoisRetard);
            taxeTrimestriel.setMontantBase(montantBase);
            taxeTrimestriel.setMontantRetard(montantRetard);
            taxeTrimestriel.setMontantMajoration(montantMajoration);
            taxeTrimestriel.setMontantTotal(montantTotale);
            taxeTrimestriel.setDateDePresentation(datePresentation);
            taxeTrimestriel.setRedevable(redevable);
            locale.setDernierTrimestrePaye(trimestre);


            taxeTrimestrielDao.save(taxeTrimestriel);

            return 1;
        }


    }


    @Override
    public int deleteByRedevableCinAndLocaleRefAndTrimestreAndAnnee(String cin, String ref, int trimestre, int annee) {
        return taxeTrimestrielDao.deleteByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, trimestre, annee);
    }

    @Override
    public int deleteById(long id) {
        return taxeTrimestrielDao.deleteById(id);
    }

    @Override
    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielDao.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }

    @Override
    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(String cin, String ref, int trimestre, int annee) {
        return taxeTrimestrielDao.findByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, trimestre, annee);
    }

    public TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre, int annee) {
        return taxeTrimestrielDao.findByLocaleRefAndTrimestreAndAnnee(ref, trimestre, annee);
    }

    public int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre, int annee) {
        return taxeTrimestrielDao.deleteByRedevableCinAndLocaleRefAndTrimestreAndAnnee(cin, ref, trimestre, annee);
    }


    public List<TaxeTrimestriel> findAll() {
        return taxeTrimestrielDao.findAll();
    }


}
