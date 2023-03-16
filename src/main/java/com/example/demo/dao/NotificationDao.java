package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.Notification;
import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {

    List<Notification> findByAnneeAndTrimestre(int annee, int trimestre) ;
    List<Notification> findAll();
    Notification findByTrimestere( int trimestre);

}
