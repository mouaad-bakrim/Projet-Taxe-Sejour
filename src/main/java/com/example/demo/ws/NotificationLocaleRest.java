package com.example.demo.ws;

import com.example.demo.bean.NotificationLocale;
import com.example.demo.service.impl.NotificationLocaleSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification-locale")
public class NotificationLocaleRest {
    @Autowired
    private NotificationLocaleSeviceImpl notificationLocaleSevice;

    @GetMapping("/Redevable/cin/{cin}")
    public List<NotificationLocale> findByRedevableCin(String cin) {
        return notificationLocaleSevice.findByRedevableCin(cin);
    }

    @GetMapping("/Locale/ref/{ref}")
    public List<NotificationLocale> findByLocaleRef(String ref) {
        return notificationLocaleSevice.findByLocaleRef(ref);
    }

    @GetMapping("/")
    public List<NotificationLocale> findAll() {
        return notificationLocaleSevice.findAll();
    }

    @GetMapping("/local/{DerniereAnneePaye}/{DernierTrimestrePaye}")
    public List<NotificationLocale> findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye) {
        return notificationLocaleSevice.findByLocaleDerniereAnneePayeAndLocaleDernierTrimestrePaye(DerniereAnneePaye, DernierTrimestrePaye);
    }

    @PostMapping("/")
    public void save(@RequestBody NotificationLocale notificationLocale) {
        notificationLocaleSevice.save(notificationLocale);
    }

     @PutMapping("/")
     public int update(@RequestBody NotificationLocale notificationLocale) {
         return notificationLocaleSevice.update(notificationLocale);
     }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable Long id) {
        notificationLocaleSevice.deleteById(id);
        return 1;
    }

    @GetMapping("/notification/{numero}/locale/{ref}")
    public NotificationLocale findByNotificationNumeroAndLocaleRef(@PathVariable int numero, @PathVariable String ref) {
        return notificationLocaleSevice.findByNotificationNumeroAndLocaleRef(numero, ref);
    }


    @GetMapping("/{id}")
    public NotificationLocale findById(@PathVariable Long id) {
        return notificationLocaleSevice.findById(id);
    }

}
