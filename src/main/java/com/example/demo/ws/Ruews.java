package com.example.demo.ws;

import com.example.demo.bean.Rue;
import com.example.demo.service.RueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class Ruews {
    @GetMapping("/")
    public List<Rue> findAll() {
        return rueService.findAll();
    }
    @GetMapping("/code/{code}")
    public Rue findByCode(Double code) {
        return rueService.findByCode(code);
    }
    @GetMapping("/Quartiere/code/{code}")
    public Rue findByQuartiereCode(Double code) {
        return rueService.findByQuartiereCode(code);
    }

    public int save(Rue rue) {
        return rueService.save(rue);
    }
    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(Double code) {
        return rueService.deleteByCode(code);
    }
    @Autowired
   private RueService rueService;

}
