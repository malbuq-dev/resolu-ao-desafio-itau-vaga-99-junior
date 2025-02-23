package com.example.itau.transacao.services;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.itau.transacao.model.EstatisticaDTO;
import com.example.itau.transacao.model.TransacaoDTO;

public class EstatisticaService {

    private TransacaoService transacaoService;
    
    public EstatisticaService(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    public ResponseEntity<EstatisticaDTO> getEstatistica() {
        long intervaloSegundos = 60;
        List<TransacaoDTO> transacoes = transacaoService.listTransacoesFeitasHaSegundosAtras(intervaloSegundos);

        DoubleSummaryStatistics estatisticas = transacoes.stream()
        .collect(Collectors.summarizingDouble(transacaoDTO -> transacaoDTO.getValor()));
        
        EstatisticaDTO estatisticaDTO = new EstatisticaDTO(estatisticas);

        if(estatisticas.getCount() == 0) {
            estatisticaDTO = new EstatisticaDTO();
        }

        return ResponseEntity.status(HttpStatus.OK).body(estatisticaDTO);
    }
}
