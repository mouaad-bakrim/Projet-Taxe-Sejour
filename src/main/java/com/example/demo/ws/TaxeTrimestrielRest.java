package com.example.demo.ws;


import com.example.demo.bean.TaxeTrimestriel;
import com.example.demo.service.impl.TaxeTrimestrielServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taxeTrimestriel")
public class TaxeTrimestrielRest {


    @Autowired
    private TaxeTrimestrielServiceImpl taxeTrimestrielService;

    @GetMapping("/trimestre/{trimestre}")
    public TaxeTrimestriel findByLocaleRefAndTrimestreAndAnnee(@PathVariable String ref, @PathVariable int trimestre, int annee) {
        return taxeTrimestrielService.findByLocaleRefAndTrimestreAndAnnee(ref, trimestre, annee);
    }

    @GetMapping("/Redevable/{cin}/{ref}/{trimestre}")
    public TaxeTrimestriel findByRedevableCinAndLocaleRefAndTrimestre(@PathVariable String cin, @PathVariable String ref, @PathVariable int trimestre) {
        return taxeTrimestrielService.findByRedevableCinAndLocaleRefAndTrimestre(cin, ref, trimestre);
    }




    @Transactional
    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return taxeTrimestrielService.deleteById(id);
    }




    @GetMapping("/findAll")
    public List<TaxeTrimestriel> findAll() {
        return taxeTrimestrielService.findAll();
    }
    @PostMapping ("/")
    public int save( @RequestBody TaxeTrimestriel taxeTrimestriel){
        return taxeTrimestrielService.save( taxeTrimestriel.getTrimestre() , taxeTrimestriel.getAnnee(), taxeTrimestriel.getLocale().getRef() ,taxeTrimestriel.getRedevable().getCin(), taxeTrimestriel.getNombreDeNuite(),  taxeTrimestriel.getDateDePresentation(), taxeTrimestriel.getTauxTaxeTrimestriel().getReference());
    }
}
