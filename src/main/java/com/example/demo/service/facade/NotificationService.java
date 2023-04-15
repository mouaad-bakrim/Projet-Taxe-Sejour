package com.example.demo.service.facade;

import com.example.demo.bean.Locale;
import com.example.demo.bean.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationService {

    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    List<Locale> findAllLocal(@Param("annee") int annee, @Param("trimestre") int trimestre);

    Notification findByNumero(int numero);

    int deleteById(int id);

    List<Notification> findAll();

    String save(Notification notification);
}
