package com.bank.transaccionesms.service.impl;

import com.bank.transaccionesms.client.CuentaClient;
import com.bank.transaccionesms.exception.TransaccionException;
import com.bank.transaccionesms.model.TipoTransaccion;
import com.bank.transaccionesms.model.Transaccion;
import com.bank.transaccionesms.repository.TransaccionRepository;
import com.bank.transaccionesms.service.TransaccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository transaccionRepository;

    private final CuentaClient cuentaClient;

    @Override
    public Mono<Transaccion> realizarDeposito(String numeroCuentaDestino, Integer cuentaId, Double monto) {
        if (monto <= 0) {
            return Mono.error(new TransaccionException("El monto debe ser mayor a 0"));
        }

        return cuentaClient.realizarDeposito(cuentaId, monto)
                .then(transaccionRepository.save(Transaccion.builder()
                        .tipo(TipoTransaccion.DEPOSITO)
                        .numeroCuentaDestino(numeroCuentaDestino)
                        .cuentaDestinoId(cuentaId)
                        .monto(monto)
                        .fecha(LocalDateTime.now())
                        .build()));
    }

    @Override
    public Mono<Transaccion> realizarRetiro(String numeroCuentaOrigen, Integer cuentaId, Double monto) {
        if (monto <= 0) {
            return Mono.error(new TransaccionException("El monto debe ser mayor a 0"));
        }

        return cuentaClient.realizarRetiro(cuentaId, monto)
                .then(transaccionRepository.save(Transaccion.builder()
                        .tipo(TipoTransaccion.RETIRO)
                        .numeroCuentaOrigen(numeroCuentaOrigen)
                        .cuentaOrigenId(cuentaId)
                        .monto(monto)
                        .fecha(LocalDateTime.now())
                        .build()));
    }

    @Override
    public Mono<Transaccion> realizarTransferencia(
            String numeroCuentaOrigen,
            Integer cuentaOrigenId,
            String numeroCuentaDestino,
            Integer cuentaDestinoId,
            Double monto
    ) {
        if (monto <= 0) {
            return Mono.error(new TransaccionException("El monto debe ser mayor a 0"));
        }

        if (numeroCuentaOrigen.equals(numeroCuentaDestino)) {
            return Mono.error(new TransaccionException("No se puede transferir a la misma cuenta"));
        }

        return cuentaClient.realizarRetiro(cuentaOrigenId, monto)
                .then(cuentaClient.realizarDeposito(cuentaDestinoId, monto))
                .then(transaccionRepository.save(Transaccion.builder()
                        .tipo(TipoTransaccion.TRANSFERENCIA)
                        .numeroCuentaOrigen(numeroCuentaOrigen)
                        .cuentaOrigenId(cuentaOrigenId)
                        .numeroCuentaDestino(numeroCuentaDestino)
                        .cuentaDestinoId(cuentaDestinoId)
                        .monto(monto)
                        .fecha(LocalDateTime.now())
                        .build()));
    }

    @Override
    public Flux<Transaccion> obtenerHistorialTransacciones() {
        return transaccionRepository.findAll();
    }
}