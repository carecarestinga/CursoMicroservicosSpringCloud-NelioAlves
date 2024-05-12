package com.carecarestinga.mstrabalhador.controller;

import com.carecarestinga.mstrabalhador.model.Trabalhador;
import com.carecarestinga.mstrabalhador.repository.TrabalhadorRepository;
import com.carecarestinga.mstrabalhador.dto.response.BuscarTodosTrabalhadresResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trabalhadores")
public class BuscarTodosTrabalhadoresController {

    private final Logger logger = LoggerFactory.getLogger(BuscarTodosTrabalhadoresController.class);

    @Autowired
    TrabalhadorRepository trabalhadorRepository;

    @Transactional
    @GetMapping
    public ResponseEntity<?> findAll() {
        logger.info("...Iniciando a busca de todos os trabalhadores cadastrados");

        List<Trabalhador> lista = trabalhadorRepository.findAll();

        logger.info("...Devolvendo consulta de buscar todos trabalhadores com sucesso");
        return ResponseEntity.ok().body(lista.stream().map(trabalhador -> new BuscarTodosTrabalhadresResponse(trabalhador)));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid NovoTrabalhadorRequest request) {
        logger.info("...Inicializando o cadastro de um trabalhador: " + request.getNome());

        Trabalhador trabalhador = request.toModel();

        trabalhadorRepository.save(trabalhador);

        logger.info("...Trabalhador cadastrado com sucesso: " + trabalhador.getNome());
        return ResponseEntity.ok().build();
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        logger.info("...Iniciando a busca de um trabalhador por id: " + id);

        Optional<Trabalhador> obj = trabalhadorRepository.findById(id);

        Trabalhador trabalhador = obj.orElseThrow(() -> new ResourceNotFoundException("id do trabalhador não encontrado"));

        return ResponseEntity.ok().body(new TrabalhadorDetalhesResponse(trabalhador));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete( @PathVariable("id") Long id) {
        logger.info("...Iniciando a deleção de um trabalhador");

        Optional<Trabalhador> possivelTrabalhador = trabalhadorRepository.findById(id);

        Trabalhador trabalhador = possivelTrabalhador.orElseThrow(() -> new ResourceNotFoundException("id trabalhador não encontrado"));

        trabalhadorRepository.delete(trabalhador);

        logger.info("Trabalhador deletado com sucesso: " + trabalhador.getId());
        return ResponseEntity.noContent().build();

    }

}
