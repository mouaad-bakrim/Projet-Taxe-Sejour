package com.example.demo.service;

import com.example.demo.bean.CategorieLocale;
import com.example.demo.bean.Locale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.dao.TaxeTrimestrielDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeTrimestrielService {

    @Autowired
    private TaxeTrimestrielDao taxeTrimestrielDao;

    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielDao.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }

    public TaxeTrimestriel findByLocaleRefAndTrimestre(String ref, int trimestre) {
        return taxeTrimestrielDao.findByLocaleRefAndTrimestre(ref, trimestre);
    }

    public int deleteByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielDao.deleteByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }

    public List<TaxeTrimestriel> findAll() {
        return taxeTrimestrielDao.findAll();
    }

    @Autowired
    private LocaleService localeService ;

    @Autowired
    private TauxTaxeTrimestrielService tauxTaxeTrimestrielService;

    TauxTaxeTrimestriel tauxTaxeTrimestriel = new TauxTaxeTrimestriel();
    TaxeTrimestriel taxeTrimestriel = new TaxeTrimestriel();


    public int save(int trimestre, String ref) {

        Locale locale = localeService.findByRef(ref) ;
        if(locale == null){ return  -1 ;}

        CategorieLocale categorieLocale = locale.getCategorieLocale() ;

        if (categorieLocale == null ){return -2;}


        tauxTaxeTrimestriel  = tauxTaxeTrimestrielService.findByCategorieCodeAndDateBetween( categorieLocale.getCode() , tauxTaxeTrimestriel.getDateApplicationDebut(), tauxTaxeTrimestriel.getDateApplicationFin() );

        if(tauxTaxeTrimestriel == null) {
            return -3 ;
        }else if( taxeTrimestrielDao.findByLocaleRefAndTrimestre(ref, trimestre) != null )  {
            return -4 ;
        }else
        {
            double montantBase=0;
            montantBase= tauxTaxeTrimestriel.getMontantParNuite() * taxeTrimestriel.getNombreDeNuite() ;

            double montantRetard=0;



            double montantMajoration=0;
            double montantTotale;
            montantTotale = montantBase + montantRetard + montantMajoration ;


    return 1 ;
        }




    }





















}
