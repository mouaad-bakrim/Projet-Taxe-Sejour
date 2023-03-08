package com.example.demo.ws;

import com.example.demo.bean.TaxeAnuelle;
import com.example.demo.service.impl.TaxeAnuelleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taxe-anuelle")
public class TaxeAnuelleRest {
    @Autowired
    private TaxeAnuelleService taxeAnuelleService;

    @GetMapping("/code/{code}")
    public TaxeAnuelle findByAnnee(int annee) {
        return taxeAnuelleService.findByAnnee(annee);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByAnnee(int annee) {
        return taxeAnuelleService.deleteByAnnee(annee);
    }

    @PostMapping("/")
    public int save(TaxeAnuelle taxeAnuelle) {
        return taxeAnuelleService.save(taxeAnuelle);
    }

    @GetMapping("/redevable/cin/{cin}")
    public List<TaxeAnuelle> findByRedevableCin(Long cin) {
        return taxeAnuelleService.findByRedevableCin(cin);
    }

    @GetMapping("/locale/ref/{ref}")
    public List<TaxeAnuelle> findByLocaleRef(Long ref) {
        return taxeAnuelleService.findByLocaleRef(ref);
    }
}
