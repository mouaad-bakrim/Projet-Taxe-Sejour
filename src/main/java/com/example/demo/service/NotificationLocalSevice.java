package com.example.demo.service;

import com.example.demo.bean.NotificationLocal;
import com.example.demo.dao.NotificationLocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NotificationLocalSevice {
    @Autowired
    private NotificationLocalDao notificationLocalDao;

    public NotificationLocal findByRedevableCinAndLocalRef(String cin, String ref) {
        return notificationLocalDao.findByRedevableCinAndLocalRef(cin, ref);
    }

    public List<NotificationLocal> findAll() {
        return notificationLocalDao.findAll();
    }
}
