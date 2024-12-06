package com.bank.transaccionesms.controller;

import com.bank.transaccionesms.model.Transaccion;
import com.bank.transaccionesms.service.TransaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transacciones")
@RequiredArgsConstructor
public class TransaccionController {

    private final TransaccionService transaccionService;

    @PostMapping("/deposito")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Transaccion> realizarDeposito(@RequestBody Transaccion transaccion) {
        return transaccionService.realizarDeposito(
                transaccion.getNumeroCuentaDestino(),
                transaccion.getCuentaDestinoId(),
                transaccion.getMonto()
        );
    }

    @PostMapping("/retiro")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Transaccion> realizarRetiro(@RequestBody Transaccion transaccion) {
        return transaccionService.realizarRetiro(
                transaccion.getNumeroCuentaOrigen(),
                transaccion.getCuentaOrigenId(),
                transaccion.getMonto()
        );
    }

    @PostMapping("/transferencia")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Transaccion> realizarTransferencia(@RequestBody Transaccion transaccion) {
        return transaccionService.realizarTransferencia(
                transaccion.getNumeroCuentaOrigen(),
                transaccion.getCuentaOrigenId(),
                transaccion.getNumeroCuentaDestino(),
                transaccion.getCuentaDestinoId(),
                transaccion.getMonto()
        );
    }

    @GetMapping("/historial")
    public Flux<Transaccion> obtenerHistorial() {
        return transaccionService.obtenerHistorialTransacciones();
    }
}