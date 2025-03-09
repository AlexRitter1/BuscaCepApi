package com.projeto.buscacep.client;

import com.projeto.buscacep.domain.entities.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class ViaCepClient {

    private final WebClient webClient = null;

    public ViaCepClient() {
    }

    public Mono<Cep> findEnderecoByCep(String cep) {

        var CepMono = webClient
                .get()
                .uri("/24900435/json".concat(cep))
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Favor informar um CEP válido")))
                .bodyToMono(Cep.class);

        return CepMono;
    }

}
