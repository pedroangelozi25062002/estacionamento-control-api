package com.api.estacionamento.repositories;

import com.api.estacionamento.models.EstacionamentoModel;

import com.api.estacionamento.models.EstacionamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstacionamentoRepository extends JpaRepository<EstacionamentoModel, UUID> {

    boolean existePlacaCarro(String placaCarro);
    boolean existeVagaEstacionamento(String numeroDaVaga);
    boolean existeApartamentoEBloco(String apartamento, String bloco);
}
