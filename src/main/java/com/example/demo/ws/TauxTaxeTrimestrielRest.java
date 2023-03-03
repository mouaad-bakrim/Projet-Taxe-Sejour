package com.example.demo.ws;


import com.example.demo.bean.TauxTaxeTrimestriel;
import com.example.demo.service.TauxTaxeTrimestrielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/taux-taxe-trimestriel")
public class TauxTaxeTrimestrielRest {
    @Autowired
    private TauxTaxeTrimestrielService tauxTaxeTrimestrielService;

    @GetMapping("/code/{code}")
    public TauxTaxeTrimestriel findByCategorieCode(String code) {
        return tauxTaxeTrimestrielService.findByCategorieCode(code);
    }
}
