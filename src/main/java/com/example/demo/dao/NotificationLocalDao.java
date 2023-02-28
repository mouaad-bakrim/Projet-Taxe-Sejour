package com.example.demo.dao;

import com.example.demo.bean.NotificationLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationLocalDao extends JpaRepository<NotificationLocal, Long> {
    NotificationLocal findByRedevableCinAndLocalRef(String cin, String ref);

    List<NotificationLocal> findAll();

}
