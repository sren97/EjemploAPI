package com.arquiSoft.ejemplo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.arquiSoft.ejemplo.entities.SimpsonDTO;
import java.util.List;

@Service
public class SimpsonQuote {
    private final WebClient webClient;

    public SimpsonQuote(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://thesimpsonsquoteapi.glitch.me").build();
    }

    public List<SimpsonDTO> getQuotes() {
        return webClient.get()
                .uri("/quotes")
                .retrieve()
                 .bodyToFlux(SimpsonDTO.class)
                .collectList()
                .block();
    }
}
