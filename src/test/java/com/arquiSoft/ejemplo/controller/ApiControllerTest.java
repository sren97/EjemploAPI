package com.arquiSoft.ejemplo.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.arquiSoft.ejemplo.service.ApiService;
import com.arquiSoft.ejemplo.service.SimpsonQuote;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(Apicontroller.class)
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ApiService apiService;

    @Mock
    private SimpsonQuote simpsonQuote;

    @Test
    void saludoEndpointReturnsGreeting() throws Exception {
        when(apiService.getSaludo()).thenReturn("¡Hola desde la API!");

        mockMvc.perform(get("/saludo"))
                .andExpect(status().isOk())
                .andExpect(content().string("¡Hola desde la API!"));
    }
}