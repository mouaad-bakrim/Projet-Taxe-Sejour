package com.example.demo.service.impl;

import com.example.demo.bean.Notification;
import com.example.demo.dao.NotificationDao;
import com.example.demo.service.facade.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationDao notificationDao;

    public Notification findByAnnee(int annee) {
        return notificationDao.findByAnnee(annee);
    }

    public Notification findByTrimestre(int trimestre) {
        return notificationDao.findByTrimestre(trimestre);
    }

    public List<Notification> findAll() {
        return notificationDao.findAll();
    }
}
