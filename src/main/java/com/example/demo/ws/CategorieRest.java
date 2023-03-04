package com.example.demo.ws;


import com.example.demo.bean.CategorieLocale;
import com.example.demo.service.CategorieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categoriel-locale-sejour")
public class CategorieRest {
    @Autowired
    private CategorieService categorieService;

    @PostMapping("/")
    public int save(@RequestBody CategorieLocale categorieLocale) {
        return categorieService.save(categorieLocale);
    }

    @GetMapping("/code/{code}")
    public CategorieLocale findByCode(@PathVariable String code) {
        return categorieService.findByCode(code);
    }

    @Transactional
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieService.deleteByCode(code);
    }
}
