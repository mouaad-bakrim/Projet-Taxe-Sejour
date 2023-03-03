package com.example.demo.service;

import com.example.demo.bean.Notification;
import com.example.demo.dao.NotificationDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
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
