package com.example.itau.transacao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TransacaoNotValidException extends RuntimeException {
    public TransacaoNotValidException(String message) {
        super(message);
    }
}
