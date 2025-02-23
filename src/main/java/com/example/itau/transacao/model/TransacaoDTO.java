package com.example.itau.transacao.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class TransacaoDTO {
    
    private double valor;
    
    private OffsetDateTime dataHora;

    public TransacaoDTO(Transacao transacao) {
        this.valor = transacao.getValor();
        this.dataHora = transacao.getDataHora();
    }
}
