package com.example.demo.ws;

import com.example.demo.bean.Notification;
import com.example.demo.service.impl.NotificationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationRest {
    private NotificationServiceImpl notificationService;

    @GetMapping("/annee/{annee}")
    public Notification findByAnnee(@PathVariable int annee) {
        return notificationService.findByAnnee(annee);
    }

    @GetMapping("/trimestre/{trimestre}")
    public Notification findByTrimestre(@PathVariable int trimestre) {
        return notificationService.findByTrimestre(trimestre);
    }

    @GetMapping("/")
    public List<Notification> findAll() {
        return notificationService.findAll();
    }
}
