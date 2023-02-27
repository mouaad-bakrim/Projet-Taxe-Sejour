package com.example.demo.ws;

import com.example.demo.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Notification;
import java.util.List;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationRest {
    private NotificationService notificationService;

    @GetMapping("/anne/{anne}")
    public Notification findByAnne(int anne) {
        return notificationService.findByAnne(anne);
    }
    @GetMapping("/")
    public List<Notification> findAll() {
        return notificationService.findAll();
    }
}
