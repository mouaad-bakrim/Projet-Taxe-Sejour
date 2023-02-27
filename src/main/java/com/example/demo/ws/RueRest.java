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
    public RueService rueService;
    @GetMapping("/code/{code}")
    public Rue findByCode(@PathVariable Double code) {
        return rueService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable Double code) {
        return rueService.deleteByCode(code);
    }
    @GetMapping("/code/{code}")
    public List<Rue> findByQuartierCode(@PathVariable Double Code) {
        return rueService.findByQuartierCode(Code);
    }
}
