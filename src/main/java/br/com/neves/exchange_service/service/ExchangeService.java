package br.com.neves.exchange_service.service;

import br.com.neves.exchange_service.domain.Exchange;
import br.com.neves.exchange_service.domain.Currency;
import br.com.neves.exchange_service.domain.dto.SimpleExchangeConvertedDTO;
import br.com.neves.exchange_service.environment.InstanceInformationService;
import br.com.neves.exchange_service.infra.exception.ExchangeException;
import br.com.neves.exchange_service.repository.ExchangeRepository;
import br.com.neves.exchange_service.service.validation.exchange.ExchangeValidation;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class ExchangeService {
    @Autowired
    private ExchangeRepository repository;

    @Autowired
    private Environment environment;

    @Autowired
    private InstanceInformationService informationService;

    @Autowired
    private List<ExchangeValidation> validations;

    public SimpleExchangeConvertedDTO convertExchange(BigDecimal value, Currency from, Currency to) {
        Exchange exchange = repository.findByFromCurrencyAndToCurrency(from, to).orElseThrow(() -> new ExchangeException("Exchange de conversão inexistente"));
        String valueConverted = exchange.convertValue(value);
        return new SimpleExchangeConvertedDTO(value, exchange, valueConverted, environment.getProperty("local.server.port"));
    }

    public Exchange save(Exchange exchange) {
        validations.forEach(v -> v.validate(exchange));
        return repository.save(exchange);
    }

    public Exchange findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Exchange não encontrado para este id"));
    }

    public Page<Exchange> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Transactional
    public Exchange update(Long id, Exchange exchangeDTO) {
        Exchange exchange = this.findById(id);
        exchangeDTO.setId(id);
        validations.forEach(v -> v.validate(exchangeDTO));
        exchange.merge(exchangeDTO);
        return exchange;
    }

    public void delete(Long id) {
        repository.delete(this.findById(id));
    }
}
