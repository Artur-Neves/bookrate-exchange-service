package br.com.neves.exchange_service.controller;

import br.com.neves.exchange_service.domain.Exchange;
import br.com.neves.exchange_service.domain.Currency;
import br.com.neves.exchange_service.domain.dto.CreateExchangeDTO;
import br.com.neves.exchange_service.domain.dto.SimpleExchangeConvertedDTO;
import br.com.neves.exchange_service.domain.dto.SimpleExchangeDTO;
import br.com.neves.exchange_service.domain.dto.UpdateExchangeDTO;
import br.com.neves.exchange_service.service.ExchangeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

@RestController
@RequestMapping("/exchange-service")
public class ExchangeController {
    @Autowired
    private ExchangeService service;



    @PostMapping()
    public ResponseEntity<SimpleExchangeDTO> save (
            @RequestBody @Valid CreateExchangeDTO exchangeDTO,
            UriComponentsBuilder builder
    ){
        Exchange exchange = service.save(new Exchange(exchangeDTO));
        URI uri = builder.path("/{id}").buildAndExpand(exchange.getId()).toUri();
        return  ResponseEntity.created(uri).body(new SimpleExchangeDTO(exchange));
    }


    @GetMapping("/{value}/{from}/{to}")
    public ResponseEntity<SimpleExchangeConvertedDTO> exchangeConvert(
            @PathVariable BigDecimal value,
            @PathVariable Currency from,
            @PathVariable Currency to
            ){
        return ResponseEntity.ok(service.convertExchange(value, from, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimpleExchangeDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(new SimpleExchangeDTO(service.findById(id)));
    }

    @GetMapping()
    public ResponseEntity<Page<SimpleExchangeDTO>> findById(@PageableDefault Pageable pageable){
        return ResponseEntity.ok((service.findAll(pageable).map(SimpleExchangeDTO::new)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SimpleExchangeDTO> update(@PathVariable Long id, @RequestBody UpdateExchangeDTO exchangeDTO){
        return ResponseEntity.ok(new SimpleExchangeDTO(service.update(id, new Exchange(exchangeDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
