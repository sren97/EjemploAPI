package com.arquiSoft.ejemplo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.arquiSoft.ejemplo.entities.AgifyDTO;

@Service
public class AgifyService {
    private final WebClient webClient;

    public AgifyService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://api.agify.io").build();
    }

    public AgifyDTO estimateAge(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("name", name).build())
                .retrieve()
                .bodyToMono(AgifyDTO.class)
                .block();
    }
}