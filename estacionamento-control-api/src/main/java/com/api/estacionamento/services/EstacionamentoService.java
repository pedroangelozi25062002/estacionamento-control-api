package com.api.estacionamento.services;

import com.api.estacionamento.models.EstacionamentoModel;
import com.api.estacionamento.repositories.EstacionamentoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EstacionamentoService {

    final EstacionamentoRepository estacionamentoRepository;

    public EstacionamentoService(EstacionamentoRepository estacionamentoRepository) {
        this.estacionamentoRepository = estacionamentoRepository;
    }

    @Transactional
    public EstacionamentoModel save(EstacionamentoModel estacionamentoModel) {
        return estacionamentoRepository.save(estacionamentoModel);
    }

    public boolean existePlacaCarro(String placaCarro) {
        return estacionamentoRepository.existePlacaCarro(placaCarro);
    }

    public boolean existeVagaEstacionamento(String numeroDaVaga) {
        return estacionamentoRepository.existeVagaEstacionamento(numeroDaVaga);
    }

    public boolean existeApartamentoEBloco(String apartamento, String bloco) {
        return estacionamentoRepository.existeApartamentoEBloco(apartamento, bloco);
    }

    public Page <EstacionamentoModel> findAll(Pageable pageable) {
        return estacionamentoRepository.findAll(pageable);
    }

    public Optional<EstacionamentoModel> findById(UUID id) {
        return estacionamentoRepository.findById(id);
    }

    @Transactional
    public void delete(EstacionamentoModel estacionamentoModel) {
    	estacionamentoRepository.delete(estacionamentoModel);
    }
}
