package com.arquiSoft.ejemplo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.arquiSoft.ejemplo.service.ApiService;
import com.arquiSoft.ejemplo.entities.SimpsonDTO;
import com.arquiSoft.ejemplo.service.SimpsonQuote;
import com.arquiSoft.ejemplo.service.AgifyService;
@RestController
public class Apicontroller {

    private final AgifyService agifyService;

    @Autowired
    private ApiService ApiService;
    private SimpsonQuote SimpsonQuote;

    public Apicontroller(ApiService ApiService, SimpsonQuote SimpsonQuote, AgifyService AgifyService, AgifyService agifyService) {
        this.SimpsonQuote = SimpsonQuote;
        this.ApiService = ApiService;
        this.agifyService = agifyService;
    }

    @GetMapping("/saludo")
    public String hello() {
        return ApiService.getSaludo();
    }

    @GetMapping("/saludo2")
        public String hello2(@RequestParam String nombre) {
            return ApiService.getSaludo2(nombre);
    }

    @GetMapping("/frases")
    public List <SimpsonDTO> getQuotes() {
        return SimpsonQuote.getQuotes();
    }
    @GetMapping("/edad")
    public String ageByName(@RequestParam String name){
        return String.valueOf(agifyService.estimateAge(name).getName()+ ":\t"+agifyService.estimateAge(name).getAge());
    }
}