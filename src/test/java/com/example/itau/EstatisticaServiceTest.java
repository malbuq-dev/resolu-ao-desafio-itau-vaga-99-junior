package com.example.itau;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.itau.transacao.model.EstatisticaDTO;
import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.model.TransacaoDTO;
import com.example.itau.transacao.services.EstatisticaService;
import com.example.itau.transacao.services.TransacaoService;

public class EstatisticaServiceTest {

    @InjectMocks
    EstatisticaService estatisticaService;

    @Mock
    TransacaoService transacaoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void dado_pelo_menos_uma_transacao_valida_retornar_estatisticas() {
        Transacao transacao = new Transacao();
        transacao.setValor(9.99);
        transacao.setDataHora(OffsetDateTime.now());

        List<TransacaoDTO> transacoes = List.of(new TransacaoDTO(transacao));

        when(transacaoService.listTransacoesFeitasHaSegundosAtras(60)).thenReturn(transacoes);

        DoubleSummaryStatistics estatisticas = transacoes.stream()
        .collect(Collectors.summarizingDouble(transacaoDTO -> transacaoDTO.getValor()));
        
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO(estatisticas);

        if(estatisticas.getCount() == 0) {
            estatisticaDTO = new EstatisticaDTO();
        }

        assertEquals(ResponseEntity.status(HttpStatus.OK).body(estatisticaDTO), estatisticaService.getEstatistica());
    }

    @Test
    public void dado_nenhuma_transacao_retornar_codigo_200_e_body_com_estatisticas_zeradas() {
        Transacao transacao = new Transacao();
        transacao.setValor(9.99);
        transacao.setDataHora(OffsetDateTime.now());

        List<TransacaoDTO> transacoes = new ArrayList<>();

        when(transacaoService.listTransacoesFeitasHaSegundosAtras(60)).thenReturn(transacoes);

        EstatisticaDTO excpectedEstatisticaDTO = new EstatisticaDTO();

        assertEquals(ResponseEntity.status(HttpStatus.OK).body(excpectedEstatisticaDTO), estatisticaService.getEstatistica());
    }
}
