package com.example.demo.dao;

import com.example.demo.bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {

    Notification findByAnne(int anne);

    Notification findByTrimestre(int trimestre);

    List<Notification> findAll();


}
