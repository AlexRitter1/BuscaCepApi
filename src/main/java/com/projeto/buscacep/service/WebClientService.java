package com.projeto.buscacep.service;

import com.projeto.buscacep.client.ViaCepClient;
import com.projeto.buscacep.domain.entities.Cep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    private final ViaCepClient client;

    public WebClientService(ViaCepClient client) {
        this.client = client;
    }

    public Mono<Cep> consultarEnderecoPorCep(String cep){
        return client.findEnderecoByCep(cep);
    }
}
