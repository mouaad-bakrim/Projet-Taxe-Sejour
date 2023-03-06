package com.example.demo.ws;

import com.example.demo.bean.NotificationLocal;
import com.example.demo.service.NotificationLocalSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification-local")
public class NotificationLocalRest {
    @Autowired
    private NotificationLocalSevice notificationLocalSevice;

    @GetMapping("/Redevable/cin/{cin}")
    public List<NotificationLocal> findByRedevableCin(String cin) {
        return notificationLocalSevice.findByRedevableCin(cin);
    }

    @GetMapping("/Local/ref/{ref}")
    public List<NotificationLocal> findByLocalRef(String ref) {
        return notificationLocalSevice.findByLocalRef(ref);
    }

    @GetMapping("/")
    public List<NotificationLocal> findAll() {
        return notificationLocalSevice.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody NotificationLocal notificationLocal) {
        return notificationLocalSevice.save(notificationLocal);
    }
}
