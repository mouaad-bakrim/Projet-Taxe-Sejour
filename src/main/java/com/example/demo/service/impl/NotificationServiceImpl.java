package com.example.demo.service.impl;


import com.example.demo.bean.NotificationLocal;
import com.example.demo.dao.NotificationDao;
import com.example.demo.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao notificationDao;

    @Override
    public List<Notification> findByAnneeAndTrimestre(int annee, int trimestre) {
        return notificationDao.findByAnneeAndTrimestre(annee, trimestre);
    }

    @Override
    public List<Notification> findAll() {
        return notificationDao.findAll();
    }

    @Override
    public Notification findByTrimestere(int trimestre) {
        return notificationDao.findByTrimestere(trimestre);
    }

    @Override
    public int save(Notification notification) {
        notificationDao.save(notification);
        return 1;
    }


}
