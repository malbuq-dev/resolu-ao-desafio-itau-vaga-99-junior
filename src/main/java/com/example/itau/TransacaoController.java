package com.example.itau;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.services.TransacaoService;

@RestController
@RequestMapping
public class TransacaoController {
    
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> createTransacao(@RequestBody Transacao transacao) {
        return transacaoService.createTransacao(transacao);
    }

}
