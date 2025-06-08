package com.arquiSoft.ejemplo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApiServiceTest {

    private final ApiService apiService = new ApiService();

    @Test
    void getSaludoReturnsExpectedGreeting() {
        String saludo = apiService.getSaludo();
        assertEquals("¡Hola desde la API!", saludo);
    }

    @Test
    void getSaludo2ReturnsPersonalizedGreeting() {
        String saludo = apiService.getSaludo2("Lisa");
        assertEquals("¡Hola Lisa desde la API!", saludo);
    }
}
