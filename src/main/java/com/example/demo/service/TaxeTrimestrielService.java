package com.example.demo.service;

import com.example.demo.bean.CategorieLocale;

import com.example.demo.bean.Locale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.dao.TaxeTrimestrielDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static sun.jvm.hotspot.oops.CellTypeState.ref;

@Service
public class TaxeTrimestrielService  {

    @Autowired
    private TaxeTrimestrielDao taxeTrimestrielDao;

    @Autowired
    private LocaleService localeService;

    @Autowired
    private TauxTaxeTrimestrielService tauxTaxeTrimestrielService;

    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String  cin, String ref, int trimestre) {
        return taxeTrimestrielDao.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }

    public TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(String ref, int trimestre,  int annee) {
        return taxeTrimestrielDao.findByLocaleRefAndTrimestreAndAnnee(ref, trimestre, annee);
    }

    public int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref,  int trimestre) {
        return taxeTrimestrielDao.deleteByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }

    public List<TaxeTrimestriel> findAll() {
        return  taxeTrimestrielDao.findAll();
    }



    TaxeTrimestriel taxeTrimestriel = new TaxeTrimestriel();

    public LocalDateTime dateUtile(int trimestre, int annee) {


        trimestre = taxeTrimestriel.getTrimestre();
        annee = taxeTrimestriel.getAnnee();
        LocalDateTime dateTime;
        if (trimestre == 1) {
             dateTime = LocalDateTime.of(annee, Month.MARCH, 31, 0, 0);
            return dateTime;

        } else if (trimestre == 2) {
             dateTime = LocalDateTime.of(annee, Month.JUNE, 30, 0, 0);
            return dateTime;

        } else if (trimestre == 3) {
             dateTime = LocalDateTime.of(annee, Month.SEPTEMBER, 30, 0, 0);
            return dateTime;

        } else {
             dateTime = LocalDateTime.of(annee, Month.DECEMBER, 31, 0, 0);
            return dateTime;
        }
    }


    TauxTaxeTrimestriel tauxTaxeTrimestriel = new TauxTaxeTrimestriel();
    Locale locale = new Locale();
    public int save(int trimestre, String ref, int annee) {


        trimestre = taxeTrimestriel.getTrimestre();
        ref = locale.getRef();
        annee = taxeTrimestriel.getAnnee();


        Locale locale = localeService.findByRef(ref);
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
        } else if (taxeTrimestrielDao.findByLocaleRefAndTrimestreAndAnnee(ref, trimestre,annee) != null) {
            return -4;
        } else {
            double montantBase = 0;
            double montantRetard = 0;
            double montantMajoration = 0;
            double montantTotale=0;

            montantBase = tauxTaxeTrimestriel.getMontantParNuite() * taxeTrimestriel.getNombreDeNuite();

            int nombreDeMoisRetard = taxeTrimestriel.getDateDePresentation().getMonthValue() -  dateUtile(trimestre,annee).getMonthValue()
                    + (12 *(taxeTrimestriel.getDateDePresentation().getYear() -  dateUtile(trimestre,annee).getYear()))   ;

            if (nombreDeMoisRetard > 1) {
                montantRetard = montantBase * tauxTaxeTrimestriel.getPourcentageRetard();

                montantMajoration = (nombreDeMoisRetard-1) * tauxTaxeTrimestriel.getPourcentageMajoration() * montantBase ;
            }

            montantTotale = montantBase + montantRetard + montantMajoration;

            taxeTrimestriel.setTauxTaxeTrimestriel(tauxTaxeTrimestriel);
            taxeTrimestriel.setLocale(locale);
            taxeTrimestriel.setAnnee(annee);
            taxeTrimestriel.setTrimestre(trimestre);
            taxeTrimestriel.setCategorieLocale(categorieLocale);
            taxeTrimestriel.setNombreDeMoisRetard(nombreDeMoisRetard);
            taxeTrimestriel.setMontantBase(montantBase);
            taxeTrimestriel.setMontantRetard(montantRetard);
            taxeTrimestriel.setMontantMajoration(montantMajoration);

            taxeTrimestrielDao.save(taxeTrimestriel);

            return 1;
        }


    }


}
