package com.example.demo.service;

import com.example.demo.bean.Notification;
import com.example.demo.dao.NotificationDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private NotificationDao notificationDao;

    public Notification findByAnne(int anne) {
        return notificationDao.findByAnne(anne);
    }

    public Notification findByTrimestre(int trimestre) {
        return notificationDao.findByTrimestre(trimestre);
    }

    public List<Notification> findAll() {
        return notificationDao.findAll();
    }
}
