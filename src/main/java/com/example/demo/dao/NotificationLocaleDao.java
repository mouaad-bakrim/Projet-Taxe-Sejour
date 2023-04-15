package com.example.demo.dao;

import com.example.demo.bean.Locale;
import com.example.demo.bean.NotificationLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationLocaleDao extends JpaRepository<NotificationLocale, Long> {

    List<NotificationLocale> findByRedevableCin(String cin);

    List<NotificationLocale> findByLocaleRef(String ref);

    List<NotificationLocale> findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye);

    List<NotificationLocale> findAll();

    NotificationLocale findByNotificationNumeroAndLocaleRef(int numero, String ref);


}
