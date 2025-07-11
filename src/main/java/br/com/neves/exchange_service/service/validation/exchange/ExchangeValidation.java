package br.com.neves.exchange_service.service.validation.exchange;

import br.com.neves.exchange_service.domain.Exchange;

public interface ExchangeValidation {
    void validate(Exchange exchange);
}
