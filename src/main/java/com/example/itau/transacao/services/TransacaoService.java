package com.example.itau.transacao.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.model.TransacaoDTO;
import com.example.itau.transacao.validators.TransacaoValidator;

@Service
public class TransacaoService {

    private List<TransacaoDTO> transacoes = new ArrayList<>();

    public ResponseEntity<Void> createTransacao(Transacao transacao) {
        TransacaoValidator.execute(transacao);
        transacoes.add(new TransacaoDTO(transacao));

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
