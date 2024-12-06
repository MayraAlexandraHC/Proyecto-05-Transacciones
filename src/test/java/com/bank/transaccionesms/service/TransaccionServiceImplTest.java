package com.bank.transaccionesms.service;

import com.bank.transaccionesms.client.CuentaClient;
import com.bank.transaccionesms.exception.SaldoInsuficienteException;
import com.bank.transaccionesms.exception.TransaccionException;
import com.bank.transaccionesms.model.TipoTransaccion;
import com.bank.transaccionesms.model.Transaccion;
import com.bank.transaccionesms.repository.TransaccionRepository;
import com.bank.transaccionesms.service.impl.TransaccionServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TransaccionServiceImplTest {

    @Mock
    private TransaccionRepository transaccionRepository;

    @Mock
    private CuentaClient accountClient;

    @InjectMocks
    private TransaccionServiceImpl transaccionService;

    private Transaccion[] transacciones;

    @BeforeEach
    void setUp() {
        transacciones = new Transaccion[]{
                Transaccion.builder()
                        .tipo(TipoTransaccion.DEPOSITO)
                        .numeroCuentaDestino("1234567890")
                        .cuentaDestinoId(1)
                        .monto(100.0)
                        .fecha(LocalDateTime.now())
                        .build(),
                Transaccion.builder()
                        .tipo(TipoTransaccion.RETIRO)
                        .numeroCuentaOrigen("1234567890")
                        .cuentaOrigenId(1)
                        .monto(50.0)
                        .fecha(LocalDateTime.now())
                        .build()
        };
    }

    @Test
    public void testObtenerHistorial() {
        given(transaccionRepository.findAll())
                .willReturn(Flux.just(transacciones));

        StepVerifier.create(transaccionService.obtenerHistorialTransacciones())
                .expectNext(transacciones[0])
                .expectNext(transacciones[1])
                .verifyComplete();
    }

    @Test
    public void testRealizarDeposito() {
        Transaccion deposito = transacciones[0];

        given(accountClient.realizarDeposito(1, 100.0))
                .willReturn(Mono.empty());
        given(transaccionRepository.save(any(Transaccion.class)))
                .willReturn(Mono.just(deposito));

        StepVerifier.create(transaccionService.realizarDeposito(
                        deposito.getNumeroCuentaDestino(),
                        deposito.getCuentaDestinoId(),
                        deposito.getMonto()))
                .expectNextMatches(t ->
                        t.getTipo().equals(TipoTransaccion.DEPOSITO) &&
                                t.getMonto().equals(100.0) &&
                                t.getNumeroCuentaDestino().equals("1234567890")
                )
                .verifyComplete();
    }

    @Test
    public void testRealizarDepositoMontoInvalido() {
        StepVerifier.create(transaccionService.realizarDeposito(
                        "1234567890", 1, -100.0))
                .expectError(TransaccionException.class)
                .verify();

        verify(transaccionRepository, never()).save(any());
    }

    @Test
    public void testRealizarRetiro() {
        Transaccion retiro = transacciones[1];

        given(accountClient.realizarRetiro(1, 50.0))
                .willReturn(Mono.empty());
        given(transaccionRepository.save(any(Transaccion.class)))
                .willReturn(Mono.just(retiro));

        StepVerifier.create(transaccionService.realizarRetiro(
                        retiro.getNumeroCuentaOrigen(),
                        retiro.getCuentaOrigenId(),
                        retiro.getMonto()))
                .expectNextMatches(t ->
                        t.getTipo().equals(TipoTransaccion.RETIRO) &&
                                t.getMonto().equals(50.0) &&
                                t.getNumeroCuentaOrigen().equals("1234567890")
                )
                .verifyComplete();
    }

    @Test
    public void testRealizarTransferencia() {
        // Arrange
        String numeroCuentaOrigen = "1234567890";
        String numeroCuentaDestino = "0987654321";
        Integer cuentaOrigenId = 1;
        Integer cuentaDestinoId = 2;
        Double monto = 100.0;

        Transaccion transferencia = Transaccion.builder()
                .tipo(TipoTransaccion.TRANSFERENCIA)
                .numeroCuentaOrigen(numeroCuentaOrigen)
                .numeroCuentaDestino(numeroCuentaDestino)
                .cuentaOrigenId(cuentaOrigenId)
                .cuentaDestinoId(cuentaDestinoId)
                .monto(monto)
                .fecha(LocalDateTime.now())
                .build();

        given(accountClient.realizarRetiro(cuentaOrigenId, monto))
                .willReturn(Mono.empty());
        given(accountClient.realizarDeposito(cuentaDestinoId, monto))
                .willReturn(Mono.empty());
        given(transaccionRepository.save(any(Transaccion.class)))
                .willReturn(Mono.just(transferencia));

        StepVerifier.create(transaccionService.realizarTransferencia(
                        numeroCuentaOrigen, cuentaOrigenId,
                        numeroCuentaDestino, cuentaDestinoId, monto))
                .expectNextMatches(t ->
                        t.getTipo().equals(TipoTransaccion.TRANSFERENCIA) &&
                                t.getMonto().equals(monto) &&
                                t.getNumeroCuentaOrigen().equals(numeroCuentaOrigen) &&
                                t.getNumeroCuentaDestino().equals(numeroCuentaDestino))
                .verifyComplete();
    }

    @Test
    public void testRealizarTransferenciaMismaCuenta() {
        String numeroCuenta = "1234567890";
        Integer cuentaId = 1;
        Double monto = 100.0;

        StepVerifier.create(transaccionService.realizarTransferencia(
                        numeroCuenta, cuentaId,
                        numeroCuenta, cuentaId, monto))
                .expectError(TransaccionException.class)
                .verify();

        verify(accountClient, never()).realizarRetiro(any(), any());
        verify(accountClient, never()).realizarDeposito(any(), any());
        verify(transaccionRepository, never()).save(any());
    }

    @Test
    public void testRealizarTransferenciaMontoInvalido() {
        StepVerifier.create(transaccionService.realizarTransferencia(
                        "1234567890", 1,
                        "0987654321", 2,
                        -100.0))
                .expectError(TransaccionException.class)
                .verify();

        verify(accountClient, never()).realizarRetiro(any(), any());
        verify(accountClient, never()).realizarDeposito(any(), any());
    }
}