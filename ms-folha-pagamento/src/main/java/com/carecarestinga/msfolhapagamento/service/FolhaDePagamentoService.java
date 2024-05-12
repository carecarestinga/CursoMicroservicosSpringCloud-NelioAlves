package com.carecarestinga.msfolhapagamento.service;

import com.carecarestinga.msfolhapagamento.apiExternaTrabalhadores.ApiFeingTrabalhadoresClient;
import com.carecarestinga.msfolhapagamento.apiExternaTrabalhadores.TrabalhadorResponse;
import com.carecarestinga.msfolhapagamento.exception.ResourceNotFoundException;
import com.carecarestinga.msfolhapagamento.model.Pagamento;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FolhaDePagamentoService {

    @Autowired
    private ApiFeingTrabalhadoresClient apiFeingTrabalhadoresClient;

    public Optional<Pagamento> consulta(Long id, Integer dias) {

        TrabalhadorResponse response;

        try {
            response = apiFeingTrabalhadoresClient.findById(id).getBody();
        }
        catch (Exception e) {
            return  Optional.empty();                 // retorna nulo
        }

        Pagamento pagamento = new Pagamento(response.getId(), response.getNome(), response.getRendaDiaria(), dias);

        return  Optional.of(pagamento);

    }


}
