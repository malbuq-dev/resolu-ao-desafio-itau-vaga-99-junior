package com.example.itau.transacao.validators;

import java.time.OffsetDateTime;

import com.example.itau.transacao.exceptions.ErrorMessages;
import com.example.itau.transacao.exceptions.TransacaoNotValidException;
import com.example.itau.transacao.model.Transacao;

public class TransacaoValidator {
    private TransacaoValidator() {

    }

    public static void execute(Transacao transacao) {
        boolean isDataHoraInvalid = transacao.getDataHora().isAfter(OffsetDateTime.now());
        
        if(isDataHoraInvalid) {
            throw new TransacaoNotValidException(ErrorMessages.DATA_HORA_TRANSACAO_INVALIDA.getMessage());
        }
        if(transacao.getValor() < 0) {
            throw new TransacaoNotValidException(ErrorMessages.VALOR_TRANSACAO_INVALIDO.getMessage());
        }
    }
}
