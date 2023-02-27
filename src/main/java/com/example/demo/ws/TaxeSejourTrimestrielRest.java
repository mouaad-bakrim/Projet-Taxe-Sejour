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
    public TaxeSejourTrimestriel findByLocaleRefAndTrimestre(String ref,int trimestre) {
        return taxeSejourTrimestrielService.findByLocaleRefAndTrimestre(ref,trimestre);
    }




    @GetMapping("/cin/{cin}/ref/{ref}/trimestre/{trimestre}")
    public TaxeSejourTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeSejourTrimestrielService.findByRedevableCinAndLocaleRefAndAnnee(cin, ref, trimestre);
    }
    @DeleteMapping("/cin/{cin}/ref/{ref}/trimestre/{trimestre}")
    public int DeleteByRedevableCinAndLocaleRefAndtrimestre(String cin, String ref, int trimestre) {
        return taxeSejourTrimestrielService.DeleteByRedevableCinAndLocaleRefAndtrimestre(cin, ref, trimestre);
    }
    @GetMapping("/")
    public List<TaxeSejourTrimestriel> findAll() {
        return taxeSejourTrimestrielService.findAll();
    }
}
