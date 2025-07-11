package br.com.neves.exchange_service.infra.exception;

import br.com.neves.exchange_service.domain.dto.ResponseExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class CustomResponseExceptions {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExceptionDTO> exception (Exception e){
        return ResponseEntity.internalServerError().body(new ResponseExceptionDTO(500, e));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseExceptionDTO> exception (MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(new ResponseExceptionDTO(400, e.getClass().getSimpleName(), Objects.requireNonNull(e.getFieldError()).getField()+" "+Objects.requireNonNull(e.getFieldError()).getDefaultMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ResponseExceptionDTO> exception (EntityNotFoundException e){
        return ResponseEntity.status(404).body(new ResponseExceptionDTO(404, e));
    }
}
