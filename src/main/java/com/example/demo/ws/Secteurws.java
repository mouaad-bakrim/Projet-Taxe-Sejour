package com.example.demo.ws;

import com.example.demo.bean.Secteur;
import com.example.demo.service.SecteurService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Secteurws {
    @GetMapping("/")
    public List<Secteur> findAll() {
        return secteurService.findAll();
    }
    @GetMapping("/code/{code}")
    public Secteur findByCode(Double code) {
        return secteurService.findByCode(code);
    }
    @PostMapping("/")

    public int save(Secteur secteur) {
        return secteurService.save(secteur);
    }
    @DeleteMapping("/")
    @Transactional
    public int deleteByCode(Double code) {
        return secteurService.deleteByCode(code);
    }

    @Autowired
    private SecteurService secteurService;

}
