package com.example.demo.ws;

import com.example.demo.bean.Locale;
import com.example.demo.bean.NotificationLocal;
import com.example.demo.service.impl.NotificationLocalSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notification-local")
public class NotificationLocalRest {
    @Autowired
    private NotificationLocalSeviceImpl notificationLocalSevice;

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
    @GetMapping("/local/{annee}/{trimestre}")
    @Query("select l from Locale l where (l.derniereAnneePaye*4+l.dernierTrimestrePaye)<(:annee*4+:trimestre)")
    public List<Locale> findAllLocal(int annee, int trimestre) {
        return notificationLocalSevice.findAllLocal(annee, trimestre);
    }
    @GetMapping("/local/{DerniereAnneePaye}/{DernierTrimestrePaye}")
    public List<NotificationLocal> findByLocalDerniereAnneePayeAndLocalDernierTrimestrePaye(int DerniereAnneePaye, int DernierTrimestrePaye) {
        return notificationLocalSevice.findByLocalDerniereAnneePayeAndLocalDernierTrimestrePaye(DerniereAnneePaye, DernierTrimestrePaye);
    }
}
