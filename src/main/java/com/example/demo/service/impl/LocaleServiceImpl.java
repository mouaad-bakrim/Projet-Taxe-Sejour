package com.example.demo.service.impl;

import com.example.demo.bean.Locale;
import com.example.demo.dao.LocaleDao;
import com.example.demo.service.facade.LocaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocaleServiceImpl implements LocaleService {
    @Autowired
    private LocaleDao localeDao;

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
            localeDao.save(locale);
            return 1;
        }
    }
}
