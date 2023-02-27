package com.example.demo.service;

import com.example.demo.dao.NotificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Notification;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationDao notificationDao;

    public Notification findByAnne(int anne) {
        return notificationDao.findByAnne(anne);
    }

    public List<Notification> findAll() {
        return notificationDao.findAll();
    }
}
