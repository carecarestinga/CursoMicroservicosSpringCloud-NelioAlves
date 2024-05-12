package com.carecarestinga.msfolhapagamento.apiExternaTrabalhadores;

import java.math.BigDecimal;

public class TrabalhadorResponse {

    private Long id;

    private String nome;

    private BigDecimal rendaDiaria;

    public TrabalhadorResponse() {
    }

    public TrabalhadorResponse(Long id, String nome, BigDecimal rendaDiaria) {
        this.id = id;
        this.nome = nome;
        this.rendaDiaria = rendaDiaria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getRendaDiaria() {
        return rendaDiaria;
    }

    public BigDecimal total(Integer diasTrabalhados) {
        return rendaDiaria.multiply(BigDecimal.valueOf(diasTrabalhados));
    }
}
