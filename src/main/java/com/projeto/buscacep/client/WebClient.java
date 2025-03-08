package com.projeto.buscacep.client;

import com.projeto.buscacep.domain.entities.Cep;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@AllArgsConstructor
public class WebClient {

    private final org.springframework.web.reactive.function.client.WebClient webClient;

    public Mono<Cep> findCharacterById(Long id) {

        var CepMono = webClient
                .get()
                .uri("/json/".concat(id.toString()))
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Favor informar um CEP válido")))
                .bodyToMono(Cep.class);

        return CepMono;
    }

}
