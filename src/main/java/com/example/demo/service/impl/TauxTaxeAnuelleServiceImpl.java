package com.example.demo.service.impl;


import com.example.demo.bean.*;
import com.example.demo.dao.TauxTaxeAnuelleDao;
import com.example.demo.service.facade.TauxTaxeAnuelleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauxTaxeAnuelleServiceImpl implements TauxTaxeAnuelleService {

    @Autowired
    private TauxTaxeAnuelleDao tauxTaxeAnuelleDao;

    @Autowired
    private CategorieLocaleServiceImpl categorieLocaleService;

    public int save(TauxTaxeAnuelle tauxTaxeAnuelle) {
        if (tauxTaxeAnuelle.getCategorieLocale() == null) {
            return -1;
        } else if (tauxTaxeAnuelle.getCategorieLocale() != null) {
            CategorieLocale categorieLocaleServiceByCode = categorieLocaleService.findOrSave(tauxTaxeAnuelle.getCategorieLocale());
            tauxTaxeAnuelle.setCategorieLocale(categorieLocaleServiceByCode);
            tauxTaxeAnuelleDao.save(tauxTaxeAnuelle);
            return 1;
        }
        return 2;
    }

    @Override
    public TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(String code, String reference) {
        return tauxTaxeAnuelleDao.findByCategorieLocaleCodeAndReference(code, reference);
    }

    @Override
    public List<TauxTaxeAnuelle> findAll() {
        return tauxTaxeAnuelleDao.findAll();
    }

    @Override
    public TauxTaxeAnuelle findByCategorieLocaleCode(String code) {
        return tauxTaxeAnuelleDao.findByCategorieLocaleCode(code);
    }
    @Override
    public TauxTaxeAnuelle findByReference(String reference) {
        return tauxTaxeAnuelleDao.findByReference(reference);
    }

    @Transactional
    @Override
    public int deleteByCategorieLocaleCode(String code) {
        return tauxTaxeAnuelleDao.deleteByCategorieLocaleCode(code);
    }
    @Transactional
    @Override
    public int deleteById(int id) {
        return tauxTaxeAnuelleDao.deleteById(id);
    }
    @Override
    public int update(TauxTaxeAnuelle tauxTaxeAnuelle){
        if (tauxTaxeAnuelleDao.findById(tauxTaxeAnuelle.getId()) != null) {
            return -1;

        } else {
            TauxTaxeAnuelle ta = findById(tauxTaxeAnuelle.getId());
            ta.setId(tauxTaxeAnuelle.getId());
            ta.setReference(tauxTaxeAnuelle.getReference());
            ta.setPourcentageRetardAnnuelle(tauxTaxeAnuelle.getPourcentageRetardAnnuelle());
            ta.setPourcentageMajorationAnnuelle(tauxTaxeAnuelle.getPourcentageMajorationAnnuelle());
            ta.setCategorieLocale(tauxTaxeAnuelle.getCategorieLocale());
            ta.setDateApplicationDebut(tauxTaxeAnuelle.getDateApplicationDebut());
            ta.setDateApplicationFin(tauxTaxeAnuelle.getDateApplicationFin());
            tauxTaxeAnuelleDao.save(ta);
            return 1;
        }

    }
    @Override
    public TauxTaxeAnuelle findById(Long id) {
        return tauxTaxeAnuelleDao.findById(id).orElse(null);
    }


}
