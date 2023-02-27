package com.example.demo.ws;


import com.example.demo.bean.TaxeSejourTrimestriel;
import com.example.demo.service.TaxeSejourTrimestrielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taxe-sejour-trimestrie")
public class TaxeSejourTrimestrielRest {


    @Autowired
    private TaxeSejourTrimestrielService taxeSejourTrimestrielService ;
    @GetMapping("/trimestre/{trimestre}")
    public TaxeSejourTrimestriel findByLocaleTrimestre(int trimestre) {
        return taxeSejourTrimestrielService.findByLocaleTrimestre(trimestre);
    }


    }

    @GetMapping("/cin/{cin}/ref/{ref}/annee/{annee}")
    public TaxeSejourTrimestriel findByRedevableCinAndLocaleRefAndAnnee(String cin, String ref, int annee) {
        return taxeSejourTrimestrielService.findByRedevableCinAndLocaleRefAndAnnee(cin, ref, annee);
    }
    @DeleteMapping("/cin/{cin}/ref/{ref}/annee/{annee}")
    public int DeleteByRedevableCinAndLocaleRefAndAnnee(String cin, String ref, int annee) {
        return taxeSejourTrimestrielService.DeleteByRedevableCinAndLocaleRefAndAnnee(cin, ref, annee);
    }
    @GetMapping("/")
    public List<TaxeSejourTrimestriel> findAll() {
        return taxeSejourTrimestrielService.findAll();
    }
}
