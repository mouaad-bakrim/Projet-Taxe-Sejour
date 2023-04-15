package com.example.demo.ws;


import com.example.demo.bean.TauxTaxeAnuelle;
import com.example.demo.service.impl.TauxTaxeAnuelleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/taux-taxe-anuelle")
public class TauxTaxeAnuelleRest {

    @Autowired
    private TauxTaxeAnuelleServiceImpl tauxTaxeAnuelleService;



    @PostMapping("/")
    public int save(@RequestBody TauxTaxeAnuelle tauxTaxeAnuelle) {
        return tauxTaxeAnuelleService.save(tauxTaxeAnuelle);
    }

    @GetMapping("/CategorieLocale/{code}/{reference}")
    public TauxTaxeAnuelle findByCategorieLocaleCodeAndReference(@PathVariable String code, @PathVariable String reference) {
        return tauxTaxeAnuelleService.findByCategorieLocaleCodeAndReference(code, reference);
    }

    @GetMapping("Categorie/code/{code}")
    public TauxTaxeAnuelle findByCategorieLocaleCode(@PathVariable String code) {
        return tauxTaxeAnuelleService.findByCategorieLocaleCode(code);
    }
    @GetMapping("/reference/{reference}")
    public TauxTaxeAnuelle findByReference(@PathVariable String reference) {
        return tauxTaxeAnuelleService.findByReference(reference);
    }

    @DeleteMapping("Categorie/code/{code}")
    public int deleteByCategorieLocaleCode(@PathVariable String code) {
        return tauxTaxeAnuelleService.deleteByCategorieLocaleCode(code);
    }

    @GetMapping("/")
    public List<TauxTaxeAnuelle> findAll() {
        return tauxTaxeAnuelleService.findAll();
    }

    @DeleteMapping("/{id}")
    public int deleteById(@PathVariable int id) {
        return tauxTaxeAnuelleService.deleteById(id);
    }
    @PutMapping("/")
    public int update(@RequestBody TauxTaxeAnuelle tauxTaxeAnuelle) {
        return tauxTaxeAnuelleService.update(tauxTaxeAnuelle);
    }
    @GetMapping("/{id}")
    public TauxTaxeAnuelle findById(@PathVariable Long id) {
        return tauxTaxeAnuelleService.findById(id);
    }
}
