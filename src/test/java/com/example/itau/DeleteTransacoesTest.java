package com.example.itau;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.services.TransacaoService;

public class DeleteTransacoesTest {

    @InjectMocks
    TransacaoService transacaoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void dado_transacao_valida_retornar_codigo_200_e_body_null() {
        Transacao transacao = new Transacao();
        transacao.setValor(9.99);
        transacao.setDataHora(OffsetDateTime.now());
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(null), transacaoService.createTransacao(transacao));
    }
}
