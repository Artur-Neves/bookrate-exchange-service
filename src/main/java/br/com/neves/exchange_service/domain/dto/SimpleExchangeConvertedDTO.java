package br.com.neves.exchange_service.domain.dto;

import br.com.neves.exchange_service.domain.Exchange;
import br.com.neves.exchange_service.domain.Currency;

import java.math.BigDecimal;

public record SimpleExchangeConvertedDTO(
        BigDecimal value,
        Currency from,
        Currency to,
        BigDecimal factorConversation,
        String valueConverted,
        String environment
) {

    public SimpleExchangeConvertedDTO(BigDecimal value, Exchange exchange, String valueConverted, String environment){
        this(value, exchange.getFromCurrency(), exchange.getToCurrency(), exchange.getConversionFactor(), valueConverted, environment);
    }
}
