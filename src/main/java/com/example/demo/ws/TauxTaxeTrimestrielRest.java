package com.example.demo.ws;


import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.service.impl.TauxTaxeTrimestrielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/taux-taxe-trimestriel")
public class TauxTaxeTrimestrielRest {
    @Autowired
    private TauxTaxeTrimestrielService tauxTaxeTrimestrielService;

    @GetMapping("/code/{code}")
    public TauxTaxeTrimestriel findByCategorieLocaleCode(String code) {
        return tauxTaxeTrimestrielService.findByCategorieLocaleCode(code);
    }

    @GetMapping("/code/{code}/dateApplicationDebut/{dateApplicationDebut}")
    public TauxTaxeTrimestriel findByCategorieCodeAndDateBetween(@PathVariable String code,@PathVariable LocalDateTime dateApplicationDebut,@PathVariable LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielService.findByCategorieCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }
    @DeleteMapping("/code/{code}/dateApplicationDebut/{dateApplicationDebut}")
    public int deleteByCategorieCodeAndDateBetween(@PathVariable String code,@PathVariable LocalDateTime dateApplicationDebut,@PathVariable LocalDateTime dateApplicationFin) {
        return tauxTaxeTrimestrielService.deleteByCategorieCodeAndDateBetween(code, dateApplicationDebut, dateApplicationFin);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCategorieLocaleCode(@PathVariable String code) {
        return tauxTaxeTrimestrielService.deleteByCategorieLocaleCode(code);
    }

    @PostMapping("/")
    public int save(@RequestBody TauxTaxeTrimestriel tauxTaxeTrimestriel) {
        return tauxTaxeTrimestrielService.save(tauxTaxeTrimestriel);
    }
}
