package com.example.demo.service.facade;

import com.example.demo.bean.Notification;

import java.util.List;

public interface NotificationService {
    Notification findByAnnee(int annee);

    Notification findByTrimestre(int trimestre);

    List<Notification> findAll();
}
