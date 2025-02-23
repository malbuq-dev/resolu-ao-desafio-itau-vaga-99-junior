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
    public void dado_pelo_menos_uma_transacao_remover_e_retornar_codigo_200_e_body_null() {
        Transacao transacao = new Transacao();
        transacao.setValor(9.99);
        transacao.setDataHora(OffsetDateTime.now());

        transacaoService.createTransacao(transacao);

        assertEquals(ResponseEntity.status(HttpStatus.OK).body(null), transacaoService.deleteTransacoes());
    }

    @Test
    public void dado_nenhuma_transacao_retornar_codigo_200_e_body_null() {
        assertEquals(ResponseEntity.status(HttpStatus.OK).body(null), transacaoService.deleteTransacoes());
    }
}
