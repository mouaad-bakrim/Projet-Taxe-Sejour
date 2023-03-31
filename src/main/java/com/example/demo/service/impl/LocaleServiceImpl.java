package com.example.demo.service.impl;

import com.example.demo.bean.Locale;
import com.example.demo.bean.Redevable;
import com.example.demo.dao.LocaleDao;
import com.example.demo.service.facade.LocaleService;
import com.example.demo.service.facade.RedevableService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocaleServiceImpl implements LocaleService {
    @Autowired
    private LocaleDao localeDao;
    @Autowired
    private RedevableServiceImpl redevableService;

    @Autowired
    private RueServiceImpl rueServiceImpl;
    @Autowired
    private CategorieLocaleServiceImpl categorieLocaleService;

    @Transactional
    public int deleteById(int id) {
        return localeDao.deleteById(id);
    }


    public int update(Locale locale) {
        if (findByRef(locale.getRef()) == null) {
            return -1;

        } else {
            Locale loc = findByRef(locale.getRef());
            loc.setRef(locale.getRef());
            loc.setRue(locale.getRue());
            loc.setRedevable(locale.getRedevable());
            loc.setId(locale.getId());
            loc.setCategorieLocale(locale.getCategorieLocale());
            loc.setDerniereAnneePaye(locale.getDerniereAnneePaye());
            loc.setDernierTrimestrePaye(locale.getDernierTrimestrePaye());
            localeDao.save(loc);
            return 1;
        }

    }

    public Locale findByRef(String ref) {
        return localeDao.findByRef(ref);
    }


    public List<Locale> findByDerniereAnneePaye(int derniereAnneePaye) {
        return localeDao.findByDerniereAnneePaye(derniereAnneePaye);
    }

    public List<Locale> findByDernierTrimestrePaye(int DernierTrimestrePaye) {
        return localeDao.findByDernierTrimestrePaye(DernierTrimestrePaye);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return localeDao.deleteByRef(ref);
    }

    public List<Locale> findAll() {
        return localeDao.findAll();
    }

    public int save(Locale locale) {
        if (findByRef(locale.getRef()) != null) {
            return -1;

        } else {
            locale.setRedevable(redevableService.findByCin(locale.getRedevable().getCin()));
            locale.setRue(rueServiceImpl.findByLibelle(locale.getRue().getLibelle()));
            locale.setCategorieLocale(categorieLocaleService.findByLibelle(locale.getCategorieLocale().getLibelle()));
            localeDao.save(locale);
            return 1;
        }
    }
}
