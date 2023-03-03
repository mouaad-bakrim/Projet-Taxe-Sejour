package com.example.demo.ws;

import com.example.demo.bean.Rue;
import com.example.demo.service.RueService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rue")
public class RueRest {
    @Autowired
    private RueService rueService;

    @GetMapping("/")
    public List<Rue> findAll() {
        return rueService.findAll();
    }

    @GetMapping("/code/{code}")
    public Rue findByCode(@PathVariable Double code) {
        return rueService.findByCode(code);
    }
    @GetMapping("/Quartiere/code/{code}")
    public Rue findByQuartierCode(Double code) {
        return rueService.findByQuartierCode(code);
    }
    @PostMapping("/")
    public int save(@RequestBody Rue rue) {
        return rueService.save(rue);
    }

    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable Double code) {
        return rueService.deleteByCode(code);
    }


}
