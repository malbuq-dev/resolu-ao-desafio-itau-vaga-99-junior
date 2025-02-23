package com.example.itau.transacao.services;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.validators.TransacaoValidator;

@Service
public class TransacaoService {

    private List<Transacao> transacoes;

    public ResponseEntity<Void> receberTransacao(Transacao transacao) {
        TransacaoValidator.execute(transacao);
        transacoes.add(transacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

}
