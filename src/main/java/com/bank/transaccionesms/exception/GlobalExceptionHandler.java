package com.bank.transaccionesms.exception;

import com.bank.transaccionesms.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MontoInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ErrorResponse> handleMontoInvalidoException(MontoInvalidoException ex) {
        return Mono.just(new ErrorResponse(
                ex.getMessage(),
                "MONTO_INVALIDO",
                HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(CuentaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<ErrorResponse> handleCuentaNotFoundException(CuentaNotFoundException ex) {
        return Mono.just(new ErrorResponse(
                ex.getMessage(),
                "CUENTA_NO_ENCONTRADA",
                HttpStatus.NOT_FOUND.value()
        ));
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ErrorResponse> handleSaldoInsuficienteException(SaldoInsuficienteException ex) {
        return Mono.just(new ErrorResponse(
                ex.getMessage(),
                "SALDO_INSUFICIENTE",
                HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(TransaccionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ErrorResponse> handleTransaccionException(TransaccionException ex) {
        return Mono.just(new ErrorResponse(
                ex.getMessage(),
                "ERROR_TRANSACCION",
                HttpStatus.BAD_REQUEST.value()
        ));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mono<ErrorResponse> handleAllExceptions(Exception ex) {
        return Mono.just(new ErrorResponse(
                "Error interno del servidor",
                "ERROR_INTERNO",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        ));
    }
}