package com.example.itau.transacao.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class Transacao {
    private Integer id;

    private float valor;

    private OffsetDateTime dataHora;
}
