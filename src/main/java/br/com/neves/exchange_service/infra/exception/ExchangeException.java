package br.com.neves.exchange_service.infra.exception;

public class ExchangeException extends RuntimeException {
    public ExchangeException(String message) {
        super(message);
    }
}
