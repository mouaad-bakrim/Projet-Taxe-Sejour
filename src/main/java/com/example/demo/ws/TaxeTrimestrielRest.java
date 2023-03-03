package com.example.demo.ws;


import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.service.TaxeTrimestrielService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taxeSejourTrimestrie")
public class TaxeTrimestrielRest {


    @Autowired
    private TaxeTrimestrielService taxeTrimestrielService;

    @GetMapping("/trimestre/{trimestre}")
    public TaxeTrimestriel findByLocaleRefAndTrimestre(@PathVariable String ref, @PathVariable int trimestre) {
        return taxeTrimestrielService.findByLocaleRefAndTrimestre(ref, trimestre);
    }
    @GetMapping("/Redevable/cin/{cin}/Locale/ref/{ref}/trimestre/{trimestre}")
    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(String cin, String ref, int trimestre) {
        return taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }



    @Transactional
    @DeleteMapping("/Redevable/cin/{cin}/Locale/ref/{ref}/trimestre/{trimestre}")
    public int deleteByRedevableCinAndLocaleRefAndTrimestre(@PathVariable String cin,@PathVariable String ref,@PathVariable int trimestre) {
        return taxeTrimestrielService.deleteByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }

    @GetMapping("/")
    public List<TaxeTrimestriel> findAll() {
        return taxeTrimestrielService.findAll();
    }
}
