package br.com.neves.exchange_service.repository;

import br.com.neves.exchange_service.domain.Exchange;
import br.com.neves.exchange_service.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    public Optional<Exchange> findByFromCurrencyAndToCurrency(Currency fromCurrency, Currency toCurrency);

    Optional<Object> findByFromCurrencyAndToCurrencyAndIdNot(Currency fromCurrency, Currency toCurrency, Long id);
}
