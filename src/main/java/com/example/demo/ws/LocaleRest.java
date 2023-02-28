package com.example.demo.ws;

import com.example.demo.bean.Locale;
import com.example.demo.service.LocaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/local")
public class LocaleRest {
    @Autowired
    private LocaleService localeService;

    @GetMapping("/ref/{ref}")
    public Locale findByRef(@PathVariable String ref) {
        return localeService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return localeService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Locale> findAll() {
        return localeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Locale locale) {
        return localeService.save(locale);
    }

    @GetMapping("/derniereAnneePaye/{derniereAnneePaye}")
    public Locale findByDerniereAnneePaye(@PathVariable int derniereAnneePaye) {
        return localeService.findByDerniereAnneePaye(derniereAnneePaye);
    }

    @GetMapping("anne/{anne}/derniereTrimestre/{derniereTrimestre}")
    public Locale findByAnneAndDernierTrimestrePaye(@PathVariable int anne, @PathVariable int derniereTrimestre) {
        return localeService.findByAnneAndDernierTrimestrePaye(anne, derniereTrimestre);
    }
}


