package com.arquiSoft.ejemplo.service;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
    public String getSaludo() {
        return "¡Hola desde la API!";
    }
    public String getSaludo2(String nombre) {
        return "¡Hola " + nombre + " desde la API!";
    }
}
