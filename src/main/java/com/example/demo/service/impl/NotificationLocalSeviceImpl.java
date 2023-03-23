package com.example.demo.service.impl;

import com.example.demo.bean.*;
import com.example.demo.dao.NotificationLocalDao;
import com.example.demo.service.facade.NotificationLocalSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service

public class NotificationLocalSeviceImpl implements NotificationLocalSevice {
    @Autowired
    private NotificationLocalDao notificationLocalDao;


    @Override
    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    public List<Locale> findAllLocal(int annee, int trimestre) {
        return notificationLocalDao.findAllLocal(annee, trimestre);
    }

    @Override
    public void save(NotificationLocal notificationLocal) {
        List<Locale> locals=notificationLocalDao.findAllLocal(notificationLocal.getAnnee(),notificationLocal.getTrimestre());
        List<NotificationLocal> notificationLocals=new ArrayList<>();
        for (Locale locale: locals){
            NotificationLocal notificationLocalb=new NotificationLocal();
            notificationLocalb.setLocal(locale);
            notificationLocalb.setRedevable(locale.getRedevable());
            notificationLocals.add(notificationLocalb);
            notificationLocalDao.save(notificationLocal);
        }
        for (NotificationLocal notificationLocald: notificationLocals){
            notificationLocalDao.save(notificationLocald);

        }
    }




    public List<NotificationLocal> findByRedevableCin(String cin) {
        return notificationLocalDao.findByRedevableCin(cin);
    }

    @Override
    public List<NotificationLocal> findByLocalDerniereAnneePayeAndLocalDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye) {
        return notificationLocalDao.findByLocalDerniereAnneePayeAndLocalDernierTrimestrePaye(DerniereAnneePaye, DernierTrimestrePaye);
    }

    public List<NotificationLocal> findByLocalRef(String ref) {
        return notificationLocalDao.findByLocalRef(ref);
    }

    public List<NotificationLocal> findAll() {
        return notificationLocalDao.findAll();
    }





}
