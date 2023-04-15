package com.example.demo.service.impl;

import com.example.demo.bean.*;
import com.example.demo.dao.NotificationLocaleDao;
import com.example.demo.service.facade.NotificationLocaleSevice;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Log4j2
@Service

public class NotificationLocaleSeviceImpl implements NotificationLocaleSevice {
    @Autowired
    private NotificationLocaleDao notificationLocaleDao;

    public void save(NotificationLocale notificationLocale) {
        notificationLocaleDao.save(notificationLocale);
    }

    public int update(NotificationLocale notificationLocale ) {
        if (findById(notificationLocale.getNotification().getId()) == null) {
            return -1;
        }
        else {
            NotificationLocale loc = findById(notificationLocale.getId());
            loc.setLocale(notificationLocale.getLocale());
            loc.setRedevable(notificationLocale.getRedevable());
            loc.setId(notificationLocale.getId());
            loc.setMantantEstimation(notificationLocale.getMantantEstimation());
            notificationLocaleDao.save(loc);
            return 1;
        }
    }
    public NotificationLocale findById(Long id) {

        return notificationLocaleDao.findById(id).orElse(null);
    }

    @Override
    public int deleteById(Long id) {
        notificationLocaleDao.deleteById(id);
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


    @Override
    public NotificationLocale findByNotificationNumeroAndLocaleRef(int numero, String ref) {
        return notificationLocaleDao.findByNotificationNumeroAndLocaleRef(numero, ref);
    }
}
