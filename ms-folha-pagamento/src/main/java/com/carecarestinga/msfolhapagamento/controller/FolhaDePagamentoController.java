package com.carecarestinga.msfolhapagamento.controller;

import com.carecarestinga.msfolhapagamento.exception.ResourceNotFoundException;
import com.carecarestinga.msfolhapagamento.model.Pagamento;
import com.carecarestinga.msfolhapagamento.service.FolhaDePagamentoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("pagamentos")
public class FolhaDePagamentoController {

    private final Logger logger = LoggerFactory.getLogger(FolhaDePagamentoController.class);

    @Autowired
    private FolhaDePagamentoService service;

    @HystrixCommand(fallbackMethod = "consultaAlternativa")
    @GetMapping(value = "/{id}/dias/{dias}")
    public ResponseEntity<?> consulta(@PathVariable("id") Long id, @PathVariable("dias") Integer dias) {
        logger.info("Inicio Consulta Dados Pagamento");

        Optional<Pagamento> obj = service.consulta(id, dias);

        Pagamento pagamento = obj.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        logger.info("Retorno Consulta Dados Pagamento");
        return  ResponseEntity.ok().body(pagamento);


    }

    public ResponseEntity<?> consultaAlternativa(Long id, Integer dias) {
        Pagamento pagamento = new Pagamento(id, "Carlos", new BigDecimal(320.00), dias);
        return  ResponseEntity.ok().body(pagamento);
    }
}
