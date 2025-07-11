package br.com.neves.exchange_service.domain.dto;

import br.com.neves.exchange_service.domain.Exchange;
import br.com.neves.exchange_service.domain.Currency;

import java.math.BigDecimal;

public record SimpleExchangeDTO(
        Long id,
        Currency from,
        Currency to,
        BigDecimal conversionFactor

) {
    public SimpleExchangeDTO(Exchange exchange){
        this(exchange.getId(), exchange.getFromCurrency(), exchange.getToCurrency(), exchange.getConversionFactor());
    }
}
