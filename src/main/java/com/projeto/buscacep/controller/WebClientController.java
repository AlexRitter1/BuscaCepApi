package com.projeto.buscacep.controller;

import com.projeto.buscacep.domain.entities.Cep;
import com.projeto.buscacep.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("v1/buscacep_api")
@RequiredArgsConstructor
public class WebClientController {

    private final WebClientService service;

    public WebClientController() {
        service = null;
    }

    @GetMapping("/{cep}")
    public Mono<Cep> consultarPersonagemPorId(@PathVariable String cep) {
        return service.consultarEnderecoPorCep(cep);
    }

}