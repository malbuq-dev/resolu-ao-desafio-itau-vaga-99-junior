package com.example.itau.transacao.exceptions;

public enum ErrorMessages {
    DATA_HORA_TRANSACAO_INVALIDA("A transação NÃO DEVE acontecer no futuro"),
    VALOR_TRANSACAO_INVALIDO("A transação NÃO DEVE ter valor negativo");

    private String message;

    private ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
