package com.example.demo.ws;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.service.impl.CategorieLocaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categoriel-locale-sejour")
public class CategorieLocaleRest {
    @Autowired
    private CategorieLocaleService categorieLocaleService;

    @PostMapping("/")
    public int save(@RequestBody CategorieLocale categorieLocale) {
        return categorieLocaleService.save(categorieLocale);
    }

    @GetMapping("/code/{code}")
    public CategorieLocale findByCode(@PathVariable String code) {
        return categorieLocaleService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieLocaleService.deleteByCode(code);
    }
}
