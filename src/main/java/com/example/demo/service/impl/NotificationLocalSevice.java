package com.example.demo.service.impl;

import com.example.demo.bean.*;
import com.example.demo.dao.NotificationLocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NotificationLocalSevice {
    @Autowired
    private NotificationLocalDao notificationLocalDao;



    public List<NotificationLocal> findByRedevableCin(String cin) {
        return notificationLocalDao.findByRedevableCin(cin);
    }

    public List<NotificationLocal> findByLocalRef(String ref) {
        return notificationLocalDao.findByLocalRef(ref);
    }

    public List<NotificationLocal> findAll() {
        return notificationLocalDao.findAll();
    }
    public int save(NotificationLocal notificationLocal){
        if(notificationLocal.getNotification().getNumero()<=3){
            notificationLocalDao.save(notificationLocal);
            return 1;
        }
        else {
            return -1;
        }
    }
}
