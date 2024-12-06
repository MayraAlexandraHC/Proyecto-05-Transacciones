package com.bank.transaccionesms.service;

import com.bank.transaccionesms.model.Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionService {
    Mono<Transaccion> realizarDeposito(String cuentaDestino, Integer cuentaId, Double monto);

    Mono<Transaccion> realizarRetiro(String cuentaOrigen, Integer cuentaId, Double monto);

    Mono<Transaccion> realizarTransferencia(String cuentaOrigen, Integer cuentaOrigenId, String cuentaDestino, Integer cuentaDestinoId, Double monto);

    Flux<Transaccion> obtenerHistorialTransacciones();
}
