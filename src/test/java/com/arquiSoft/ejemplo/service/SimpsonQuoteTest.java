package com.arquiSoft.ejemplo.service;

import com.arquiSoft.ejemplo.entities.SimpsonDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SimpsonQuoteTest {

    @Test
    void getQuotesReturnsList() {
        WebClient.Builder builder = mock(WebClient.Builder.class, RETURNS_DEEP_STUBS);
        SimpsonQuote simpsonQuote = new SimpsonQuote(builder);


        assertDoesNotThrow(() -> {
            List<SimpsonDTO> quotes = simpsonQuote.getQuotes();
        });
    }
}
