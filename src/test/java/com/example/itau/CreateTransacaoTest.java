package com.example.itau;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.itau.transacao.exceptions.TransacaoNotValidException;
import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.services.TransacaoService;

public class CreateTransacaoTest {

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

    @Test
    public void dado_valor_invalido_retornar_codigo_422_e_body_null() {
        Transacao transacao = new Transacao();
        transacao.setValor(-1);
        transacao.setDataHora(OffsetDateTime.now());
        assertThrows(TransacaoNotValidException.class, () -> transacaoService.createTransacao(transacao));
    }

    @Test
    public void dado_data_invalida_retornar_codigo_422_e_body_null() {
        Transacao transacao = new Transacao();
        transacao.setValor(-1);
        transacao.setDataHora(OffsetDateTime.now().plusDays(1));
        assertThrows(TransacaoNotValidException.class, () -> transacaoService.createTransacao(transacao));
    }

}
