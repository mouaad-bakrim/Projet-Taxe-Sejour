package com.example.demo.service.impl;

import com.example.demo.bean.*;
import com.example.demo.dao.NotificationLocaleDao;
import com.example.demo.service.facade.NotificationLocaleSevice;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service

public class NotificationLocaleSeviceImpl implements NotificationLocaleSevice {
    @Autowired
    private NotificationLocaleDao notificationLocaleDao;


    @Override
    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    public List<Locale> findAllLocal(int annee, int trimestre) {
        return notificationLocaleDao.findAllLocal(annee, trimestre);
    }

    @Override
    public int save(NotificationLocale notificationLocale) {
        List<Locale> locales= notificationLocaleDao.findAllLocal(notificationLocale.getAnnee(), notificationLocale.getTrimestre());
        List<NotificationLocale> notificationLocales =new ArrayList<>();
        for (Locale locale: locales){
            NotificationLocale notificationLocaleb=new NotificationLocale();
            notificationLocaleb.setLocale(locale);
            notificationLocaleb.setRedevable(locale.getRedevable());
            notificationLocales.add(notificationLocaleb);
         //   notificationLocaleDao.save(notificationLocale);
        }
        for (NotificationLocale notificationLocaled: notificationLocales){
            notificationLocaled.setId(notificationLocale.getId());
           notificationLocaled.setTrimestre(notificationLocale.getTrimestre());
           notificationLocaled.setNumero(notificationLocale.getNumero());
           notificationLocaled.setAnnee(notificationLocale.getAnnee());
           notificationLocaled.setMantantEstimation(notificationLocale.getMantantEstimation());
            notificationLocaleDao.save(notificationLocaled);

        }
        return 1;
    }




    public List<NotificationLocale> findByRedevableCin(String cin) {
        return notificationLocaleDao.findByRedevableCin(cin);
    }

    @Override
    public List<NotificationLocale> findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye) {
        return notificationLocaleDao.findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(DerniereAnneePaye, DernierTrimestrePaye);
    }

    public List<NotificationLocale> findByLocaleRef(String ref) {
        return notificationLocaleDao.findByLocaleRef(ref);
    }

    public List<NotificationLocale> findAll() {
        return notificationLocaleDao.findAll();
    }


    @Transactional
    public int deleteById(int id) {
        return notificationLocaleDao.deleteById(id);
    }
}
