package com.example.demo.service.impl;

import com.example.demo.bean.Locale;
import com.example.demo.bean.Notification;
import com.example.demo.bean.NotificationLocale;
import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.dao.NotificationDao;
import com.example.demo.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationImpl implements NotificationService {
    @Autowired
    private NotificationDao notificationDao;
    @Autowired
    private TaxeTrimestrielServiceImpl taxeTrimestrielService;
    @Autowired
    private NotificationLocaleSeviceImpl notificationLocaleSeviceImpl;


    @Override
    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    public List<Locale> findAllLocal(int annee, int trimestre) {
        return notificationDao.findAllLocal(annee, trimestre);
    }

    @Override
    public String save(Notification notification) {
        if (notification == null) {
            return "notification is null";
        }
        List<Locale> locales = notificationDao.findAllLocal(notification.getAnnee(), notification.getTrimestre());
        List<NotificationLocale> notificationLocales = new ArrayList<>();
        if (locales == null) {
            return "locales is null";
        }
        for (Locale locale : locales) {
            NotificationLocale notificationLocale = new NotificationLocale();
            TaxeTrimestriel mantantEstimation = taxeTrimestrielService.findByCategorieLocaleLibelle(locale.getCategorieLocale().getLibelle());
            notificationLocale.setLocale(locale);
            notificationLocale.setRedevable(locale.getRedevable());
            notificationLocale.setMantantEstimation(mantantEstimation.getMontantBase());
            notificationLocales.add(notificationLocale);
        }
        if (notificationLocales == null) {
            return "notificationLocales is null";
        }
        notificationDao.save(notification);
        for (NotificationLocale notificationLocaleItem : notificationLocales) {
            if (notificationLocaleSeviceImpl.findByNotificationNumeroAndLocaleRef(notificationLocaleItem.getNotification().getNumero(), notificationLocaleItem.getLocale().getRef()) != null) {
                notification.setNumero(notification.getNumero() + 1);
                if (notification.getNumero() > 3) {
                    return "numero de notification supérieur à 3";
                }
                notificationLocaleItem.setNotification(notification);
            } else {
                notificationLocaleItem.setNotification(notification);
            }
            notificationLocaleSeviceImpl.save(notificationLocaleItem);
        }
        return "";
    }

    @Override
    public Notification findByNumero(int numero) {
        return notificationDao.findByNumero(numero);
    }

    @Override
    public int deleteById(int id) {
        return notificationDao.deleteById(id);
    }

    @Override
    public List<Notification> findAll() {
        return notificationDao.findAll();
    }

}
