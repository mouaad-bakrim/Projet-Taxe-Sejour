package com.example.demo.service.facade;


import com.example.demo.bean.NotificationLocal;

import javax.management.Notification;
import java.util.List;

public interface NotificationService {
     List<Notification> findByAnneeAndTrimestre(int annee, int trimestre) ;
    List<Notification> findAll();
    Notification findByTrimestere( int trimestre);
    int save(Notification notification);

}
