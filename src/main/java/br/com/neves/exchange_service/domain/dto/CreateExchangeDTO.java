package br.com.neves.exchange_service.domain.dto;

import br.com.neves.exchange_service.domain.Currency;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateExchangeDTO(
        @NotNull
        Currency from,
        @NotNull
        Currency to,
        @NotNull
        @JsonAlias("conversion_factor")
        BigDecimal conversionFactor
) {
}
