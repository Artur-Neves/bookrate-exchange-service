package br.com.neves.exchange_service.domain;

public enum Currency {
    USD("Dólar", "$"),
    EUR("Euro", "€"),
    BRL("Real", "R$"),
    GBP("Libra Esterlina", "£"),
    ARS("Peso Argentino", "$"),
    CLP("Peso Chileno", "$"),
    COP("Peso Colombiano", "$"),
    MXN("Peso Mexicano", "$");
    private final String fullName;
    private final String symbols;

    Currency(String fullName, String symbols) {
        this.fullName=fullName;
        this.symbols = symbols;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSymbols() {
        return symbols;
    }
}
