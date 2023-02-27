package com.example.demo.ws;

import com.example.demo.bean.Locale;
import com.example.demo.service.LocaleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/local")
public class LocaleWs {
    @Autowired
    private LocaleService localeService;

    public Locale findByRef(String ref) {
        return localeService.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return localeService.deleteByRef(ref);
    }

    public List<Locale> findAll() {
        return localeService.findAll();
    }

    public int save(Locale locale) {
        return localeService.save(locale);
    }
}
