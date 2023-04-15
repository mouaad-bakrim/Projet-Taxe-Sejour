package com.example.demo.ws;

import com.example.demo.bean.Locale;
import com.example.demo.bean.Notification;
import com.example.demo.service.impl.NotificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationRest {
    @Autowired
    private NotificationImpl notificationImpl;

    @GetMapping("/{numero}")
    public Notification findByNumero(@PathVariable int numero) {
        return notificationImpl.findByNumero(numero);
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return notificationImpl.deleteById(id);
    }

    @GetMapping("/")
    public List<Notification> findAll() {
        return notificationImpl.findAll();
    }

    @PostMapping("/")
    public String save(@RequestBody Notification notification) {
        return notificationImpl.save(notification);
    }

    @GetMapping("/locale/{annee}/{trimestre}")
    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    public List<Locale> findAllLocal(int annee, int trimestre) {
        return notificationImpl.findAllLocal(annee, trimestre);
    }
}
