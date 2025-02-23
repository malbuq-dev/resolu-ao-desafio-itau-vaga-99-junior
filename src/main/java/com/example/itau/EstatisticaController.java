package com.example.itau;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.itau.estatistica.model.EstatisticaDTO;
import com.example.itau.estatistica.services.EstatisticaService;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> getEstatistica(@RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") long intervaloBusca) {
        return estatisticaService.getEstatistica(intervaloBusca);
    }
}
