package com.example.demo.service.impl;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.bean.Locale;
import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.dao.TauxTaxeTrimestrielDao;
import com.example.demo.service.facade.TauxTaxeTrimestrielService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TauxTaxeTrimestrielServiceImpl implements TauxTaxeTrimestrielService {

    @Autowired

    private TauxTaxeTrimestrielDao tauxTaxeTrimestrielDao;

    @Autowired
    private CategorieLocaleServiceImpl categorieLocaleService;

    public int save(TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        if (tauxTaxeTrimestriel.getCategorielocale() == null) {
            return -1;
        } else if (tauxTaxeTrimestriel.getCategorielocale() != null) {
            CategorieLocale categorieLocaleServiceByCode = categorieLocaleService.findOrSave(tauxTaxeTrimestriel.getCategorielocale());
            tauxTaxeTrimestriel.setCategorielocale(categorieLocaleServiceByCode);
            tauxTaxeTrimestrielDao.save(tauxTaxeTrimestriel);
            return 1;
        }
        return 2;
    }

    @Override
    public List<TauxTaxeTrimestriel> findAll() {
        return tauxTaxeTrimestrielDao.findAll();
    }

    @Override
    public TauxTaxeTrimestriel findByReference(String reference) {
        return tauxTaxeTrimestrielDao.findByReference(reference);
    }

    @Override
    public TauxTaxeTrimestriel findByCategorieLocaleCodeAndReference(String code, String reference) {
        return tauxTaxeTrimestrielDao.findByCategorieLocaleCodeAndReference(code, reference);
    }

    @Override
    public TauxTaxeTrimestriel findByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielDao.findByCategorieLocaleCode(code);
    }


    @Transactional
    @Override
    public int deleteByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielDao.deleteByCategorieLocaleCode(code);
    }
    @Transactional
    @Override
    public int deleteById(Long id) {
        tauxTaxeTrimestrielDao.deleteById(id);
        return 1;
    }

    @Override
    public TauxTaxeTrimestriel findById(Long id) {
        return tauxTaxeTrimestrielDao.findById(id).orElse(null);
    }

    @Override
    public int update(TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        if (findById(tauxTaxeTrimestriel.getId()) == null) {
            return -1;
        } else {
            TauxTaxeTrimestriel tauxTaxeTrimestriel1 = findById(tauxTaxeTrimestriel.getId());
            tauxTaxeTrimestriel1.setReference(tauxTaxeTrimestriel.getReference());
            tauxTaxeTrimestriel1.setPourcentageMajoration(tauxTaxeTrimestriel.getPourcentageMajoration());
            tauxTaxeTrimestriel1.setPourcentageRetard(tauxTaxeTrimestriel.getPourcentageRetard());
            tauxTaxeTrimestriel1.setMontantParNuite(tauxTaxeTrimestriel.getMontantParNuite());
            tauxTaxeTrimestriel1.setId(tauxTaxeTrimestriel.getId());
            tauxTaxeTrimestriel1.setCategorieLocale(tauxTaxeTrimestriel.getCategorieLocale());
            tauxTaxeTrimestriel1.setDateApplicationDebut(tauxTaxeTrimestriel.getDateApplicationDebut());
            tauxTaxeTrimestriel1.setDateApplicationFin(tauxTaxeTrimestriel.getDateApplicationFin());
            tauxTaxeTrimestrielDao.save(tauxTaxeTrimestriel1);
            return 1;
        }
    }

}


