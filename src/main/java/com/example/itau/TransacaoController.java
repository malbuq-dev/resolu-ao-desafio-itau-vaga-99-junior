package com.example.itau;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itau.transacao.model.EstatisticaDTO;
import com.example.itau.transacao.model.Transacao;
import com.example.itau.transacao.model.TransacaoDTO;
import com.example.itau.transacao.services.EstatisticaService;
import com.example.itau.transacao.services.TransacaoService;

@RestController
@RequestMapping
public class TransacaoController {
    
    private final TransacaoService transacaoService;
    private final EstatisticaService estatisticaService;

    public TransacaoController(TransacaoService transacaoService, EstatisticaService estatisticaService) {
        this.transacaoService = transacaoService;
        this.estatisticaService = estatisticaService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<Void> createTransacao(@RequestBody Transacao transacao) {
        return transacaoService.createTransacao(transacao);
    }

    @GetMapping("/transacao")
    public ResponseEntity<List<TransacaoDTO>> listTransacoes() {
        return transacaoService.listTransacoes();
    }
    
    @DeleteMapping("/transacao")
    public ResponseEntity<Void> deleteTransacoes() {
        return transacaoService.deleteTransacoes();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaDTO> getEstatistica() {
        return estatisticaService.getEstatistica();
    }

}
