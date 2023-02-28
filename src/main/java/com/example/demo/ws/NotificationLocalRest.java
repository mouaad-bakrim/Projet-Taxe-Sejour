package com.example.demo.ws;

import com.example.demo.bean.NotificationLocal;
import com.example.demo.service.NotificationLocalSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification-local")
public class NotificationLocalRest {
    @Autowired
    private NotificationLocalSevice notificationLocalSevice;

    @GetMapping("/cin/{cin}/ref/{ref}")
    public NotificationLocal findByRedevableCinAndLocalRef(@PathVariable String cin, @PathVariable String ref) {
        return notificationLocalSevice.findByRedevableCinAndLocalRef(cin, ref);
    }

    @GetMapping("/")
    public List<NotificationLocal> findAll() {
        return notificationLocalSevice.findAll();
    }
}
