package com.example.itau.transacao.services;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.model.TransacaoDTO;
import com.example.itau.transacao.validators.TransacaoValidator;

@Service
public class TransacaoService {

    private List<TransacaoDTO> transacoes = new ArrayList<>();

    public List<TransacaoDTO> getTransacoes() {
        return this.transacoes;
    }

    public ResponseEntity<Void> createTransacao(Transacao transacao) {
        TransacaoValidator.execute(transacao);
        transacoes.add(new TransacaoDTO(transacao));

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    public ResponseEntity<List<TransacaoDTO>> listTransacoes() {
        return ResponseEntity.status(HttpStatus.OK).body(transacoes);
    }
    
    public ResponseEntity<Void> deleteTransacoes() {
        transacoes.clear();
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    public List<TransacaoDTO> listTransacoesFeitasHaSegundosAtras(long intervaloSegundos) {
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime validDateTime = now.minusSeconds(intervaloSegundos);

        List<TransacaoDTO> foundTransacoes = transacoes.stream()
        .filter(transacaoDTO -> transacaoDTO.getDataHora().isAfter(validDateTime))
        .collect(Collectors.toList());

        return foundTransacoes;
    }
    

}
