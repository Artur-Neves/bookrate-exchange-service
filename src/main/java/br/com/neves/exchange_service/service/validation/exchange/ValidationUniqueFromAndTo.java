package br.com.neves.exchange_service.service.validation.exchange;

import br.com.neves.exchange_service.domain.Exchange;
import br.com.neves.exchange_service.infra.exception.ExchangeException;
import br.com.neves.exchange_service.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidationUniqueFromAndTo implements br.com.neves.exchange_service.service.validation.exchange.ExchangeValidation {
    @Autowired
    private ExchangeRepository repository;
    @Override
    public void validate(Exchange exchange) {
        boolean exists = repository.findByFromCurrencyAndToCurrencyAndIdNot(exchange.getFromCurrency(), exchange.getToCurrency(), exchange.getId()).isPresent();
        if (exists){
            throw  new ExchangeException("Já existe um fator de conversão de %s para %s".formatted(exchange.getFromCurrency().getFullName(), exchange.getToCurrency().getFullName()));
        }
    }
}
