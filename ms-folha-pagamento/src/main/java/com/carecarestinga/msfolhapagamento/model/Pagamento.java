package com.carecarestinga.msfolhapagamento.model;

import java.math.BigDecimal;

public class Pagamento {

    private Long id;
    private String nome;
    private BigDecimal rendaDiaria;
    private Integer diasTrabalhados;
    public Pagamento() {}
    public Pagamento(Long id, String nome, BigDecimal rendaDiaria, Integer diasTrabalhados) {
        this.id = id;
        this.nome = nome;
        this.rendaDiaria = rendaDiaria;
        this.diasTrabalhados = diasTrabalhados;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getRendaDiaria() {
        return rendaDiaria;
    }

    public Long getId() {
        return id;
    }

    public Integer getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public BigDecimal getTotal() {
        return rendaDiaria.multiply(BigDecimal.valueOf(diasTrabalhados));
    }
}
