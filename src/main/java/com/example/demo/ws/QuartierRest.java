package com.example.demo.ws;

import com.example.demo.bean.Quartier;
import com.example.demo.service.QuartierService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Quartier")
public class QuartierRest {

    @Autowired
    public QuartierService quartierService;
    @GetMapping("/code/{code}")
    public Quartier findByCode(Double code) {
        return quartierService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(Double code) {
        return quartierService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Quartier> findAll() {
        return quartierService.findAll();
    }
    @PostMapping("/")
    public <S extends Quartier> S save(S entity) {
        return quartierService.save(entity);
    }
}
