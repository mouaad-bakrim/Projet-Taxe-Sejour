package com.example.demo.service.facade;

import com.example.demo.bean.NotificationLocal;

import java.util.List;

public interface NotificationLocalSevice {
    List<NotificationLocal> findByRedevableCin(String cin);

    List<NotificationLocal> findByLocalRef(String ref);
    List<NotificationLocal> findByLocalDerniereAnneePayeAndLocalDernierTrimestrePaye(int DerniereAnneePaye,int DernierTrimestrePaye);

    List<NotificationLocal> findAll();
     int save(NotificationLocal notificationLocal);


}
