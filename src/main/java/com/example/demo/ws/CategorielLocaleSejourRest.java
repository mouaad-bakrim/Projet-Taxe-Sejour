package com.example.demo.ws;


import com.example.demo.bean.CategorieLocaleSejour;
import com.example.demo.service.CategorieLocaleSejourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CategorielLocaleSejourRest {
@Autowired
    private CategorieLocaleSejourService categorieLocaleSejourService;

@PostMapping("/")
    public int save(@RequestBody CategorieLocaleSejour categorieLocaleSejour) {
        return categorieLocaleSejourService.save(categorieLocaleSejour);
    }
@GetMapping("/code/{code}")
    public CategorieLocaleSejour findByCode(@PathVariable int code) {
        return categorieLocaleSejourService.findByCode(code);
    }
@DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieLocaleSejourService.deleteByCode(code);
    }
}
