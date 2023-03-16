package com.example.demo.ws;


import com.example.demo.service.impl.NotificationServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.management.Notification;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationRest {
    private NotificationServiceImpl notificationService;
    @GetMapping("/anne/{anne}/trimestre/{trimestre}")
    public List<Notification> findByAnneeAndTrimestre(@PathVariable int annee, @PathVariable int trimestre) {
        return notificationService.findByAnneeAndTrimestre(annee, trimestre);
    }
    @GetMapping("/")
    public List<Notification> findAll() {
        return notificationService.findAll();
    }
    @GetMapping("/trimestre/{trimestre}")
    public Notification findByTrimestere(@PathVariable int trimestre) {
        return notificationService.findByTrimestere(trimestre);
    }
    @PostMapping("/")
    public int save(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }
}
