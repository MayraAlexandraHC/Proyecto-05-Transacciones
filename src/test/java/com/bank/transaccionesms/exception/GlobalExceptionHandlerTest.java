package com.bank.transaccionesms.exception;

import com.bank.transaccionesms.model.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Test
    void handleTransaccionException() {
        TransaccionException ex = new TransaccionException("Error en la transacción");

        Mono<ErrorResponse> result = globalExceptionHandler.handleTransaccionException(ex);

        StepVerifier.create(result)
                .expectNextMatches(response ->
                        response.getMensaje().equals("Error en la transacción") &&
                                response.getCodigo().equals("ERROR_TRANSACCION") &&
                                response.getStatus() == 400)
                .verifyComplete();
    }

    @Test
    void handleSaldoInsuficienteException() {
        SaldoInsuficienteException ex = new SaldoInsuficienteException("Saldo insuficiente");

        Mono<ErrorResponse> result = globalExceptionHandler.handleSaldoInsuficienteException(ex);

        StepVerifier.create(result)
                .expectNextMatches(response ->
                        response.getMensaje().equals("Saldo insuficiente") &&
                                response.getCodigo().equals("SALDO_INSUFICIENTE") &&
                                response.getStatus() == 400)
                .verifyComplete();
    }

    @Test
    void handleAllExceptions() {
        Exception ex = new RuntimeException("Error inesperado");

        Mono<ErrorResponse> result = globalExceptionHandler.handleAllExceptions(ex);

        StepVerifier.create(result)
                .expectNextMatches(response ->
                        response.getMensaje().equals("Error interno del servidor") &&
                                response.getCodigo().equals("ERROR_INTERNO") &&
                                response.getStatus() == 500)
                .verifyComplete();
    }
}