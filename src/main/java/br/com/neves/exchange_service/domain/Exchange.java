package br.com.neves.exchange_service.domain;

import br.com.neves.exchange_service.domain.dto.CreateExchangeDTO;
import br.com.neves.exchange_service.domain.dto.UpdateExchangeDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.NumberFormat;

@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Currency fromCurrency;
    @Enumerated(EnumType.STRING)
    private Currency toCurrency;
    private BigDecimal conversionFactor;

    public Exchange(BigDecimal conversionFactor, Currency fromCurrency, Currency toCurrency) {
        this.conversionFactor = conversionFactor;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }

    public  Exchange (CreateExchangeDTO exchangeDTO){
        this.conversionFactor = exchangeDTO.conversionFactor();
        this.fromCurrency = exchangeDTO.from();
        this.toCurrency = exchangeDTO.to();
    }

    public  Exchange (UpdateExchangeDTO exchangeDTO){
        this.conversionFactor = exchangeDTO.conversionFactor();
        this.fromCurrency = exchangeDTO.from();
        this.toCurrency = exchangeDTO.to();
    }

    public Exchange() {
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public String convertValue(BigDecimal value) {
        return formatValue(this.conversionFactor.multiply(value), this.toCurrency);
    }

    public String formatValue(BigDecimal value, Currency currency){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setCurrency(java.util.Currency.getInstance(currency.name()));
        return nf.format(value);
    }

    public void merge(Exchange exchangeDTO) {
        this.toCurrency = exchangeDTO.getToCurrency();
        this.fromCurrency = exchangeDTO.getFromCurrency();
        this.conversionFactor = exchangeDTO.getConversionFactor();
    }
}
