package com.api.estacionamento.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.estacionamento.dtos.EstacionamentoDto;
import com.api.estacionamento.models.EstacionamentoModel;
import com.api.estacionamento.services.EstacionamentoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/estacionamento")
public class EstacionamentoController {

    final EstacionamentoService estacionamentoService;

    
    public EstacionamentoController(EstacionamentoService estacionamentoService) {
        this.estacionamentoService = estacionamentoService;
        
        
    }


    @PostMapping
    public ResponseEntity<Object> SalvarVagaEstacionamento (@RequestBody @Valid EstacionamentoDto estacionamentoDto){
        
    	if(estacionamentoService.existePlacaCarro (estacionamentoDto.getPlacaCarro())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: O carro já esta matriculado!");
        }
        
       
    	if(estacionamentoService.existeVagaEstacionamento (estacionamentoDto.getNumeroDaVaga())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: A vaga de estacionamento já está em uso!");
        }
        
        if(estacionamentoService.existeApartamentoEBloco(estacionamentoDto.getApartamento(), estacionamentoDto.getBloco())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: Vaga já registrada para este apartamento/bloco!\n"
            		+ "");
        }
       
        EstacionamentoModel estacionamentoModel = new EstacionamentoModel();
        
        BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
        
        estacionamentoModel.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoService.save(estacionamentoModel));
    }

    @GetMapping
    public ResponseEntity<Page<EstacionamentoModel>> getTodasAsVagas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.findAll(pageable));
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBuscaVagaUnitaria(@PathVariable(value = "id") UUID id){
        Optional<EstacionamentoModel> parkingSpotModelOptional = estacionamentoService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVaga(@PathVariable(value = "id") UUID id){
        Optional<EstacionamentoModel> parkingSpotModelOptional = estacionamentoService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.\n"
            		+ "");
        }
        estacionamentoService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("A vaga de estacionamento foi excluída com sucesso.\n"
        		+ "");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVaga(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid EstacionamentoDto estacionamentoDto){
        Optional<EstacionamentoModel> ModeloDaVagaOpicional = estacionamentoService.findById(id);
        if (!ModeloDaVagaOpicional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada.\n"
            		+ "");
        }
        EstacionamentoModel estacionamentoModel = new EstacionamentoModel();
        BeanUtils.copyProperties(estacionamentoDto, estacionamentoModel);
        estacionamentoModel.setId(ModeloDaVagaOpicional.get().getId());
        estacionamentoModel.setDataDeRegistro(ModeloDaVagaOpicional.get().getDataDeRegistro());
        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoService.save(estacionamentoModel));
    }



}
