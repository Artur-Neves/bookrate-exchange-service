package br.com.neves.exchange_service.domain.dto;


import java.time.LocalTime;

public record ResponseExceptionDTO(
        int code,
        String type,
        LocalTime timestamp,
        String message
) {
    public <T extends Exception>ResponseExceptionDTO(int code, T exception ){
        this(code, exception.getClass().getSimpleName(), LocalTime.now(),exception.getMessage());
    }

    public ResponseExceptionDTO(int code, String type, String message ){
        this(code, type, LocalTime.now(),message);
    }
}
