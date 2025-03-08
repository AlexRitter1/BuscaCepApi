package com.projeto.buscacep.repositories;

import com.projeto.buscacep.dtos.EnderecoDTO;
import com.projeto.buscacep.domain.entities.Cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICepRepository extends JpaRepository<Cep, String> {

    @Query()
    public EnderecoDTO findByCep(String cep);
}
