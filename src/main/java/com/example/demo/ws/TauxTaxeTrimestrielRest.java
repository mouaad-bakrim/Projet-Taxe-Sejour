package com.example.demo.ws;


import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.service.TauxTaxeTrimestrielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/taux-taxe-trimestriel")
public class TauxTaxeTrimestrielRest {
    @Autowired
    private TauxTaxeTrimestrielService tauxTaxeTrimestrielService;

    @GetMapping("/code/{code}")
    public TauxTaxeTrimestriel findByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielService.findByCategorieLocaleCode(code);
    }
@PostMapping("/")
    public int save(@RequestBody TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        return tauxTaxeTrimestrielService.save(tauxTaxeTrimestriel);
    }
}
