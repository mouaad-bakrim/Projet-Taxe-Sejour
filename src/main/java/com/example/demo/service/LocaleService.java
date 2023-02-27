package com.example.demo.service;

import com.example.demo.bean.Locale;
import com.example.demo.dao.LocaleDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocaleService {
    @Autowired
    private LocaleDao localeDao;

    public Locale findByRef(String ref) {
        return localeDao.findByRef(ref);
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
