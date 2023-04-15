package com.example.demo.service.facade;


import com.example.demo.bean.NotificationLocale;


import java.util.List;

public interface NotificationLocaleSevice {

    List<NotificationLocale> findByRedevableCin(String cin);

    List<NotificationLocale> findByLocaleRef(String ref);

    List<NotificationLocale> findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye);

    List<NotificationLocale> findAll();

    void save(NotificationLocale notificationLocale);

    int deleteById(Long id);

    NotificationLocale findByNotificationNumeroAndLocaleRef(int numero, String ref);
    int update(NotificationLocale notificationLocale );

}
