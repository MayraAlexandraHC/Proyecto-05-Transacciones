package com.bank.transaccionesms.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SaldoInsuficienteExceptionTest {

    @Test
    void testSaldoInsuficienteException() {
        String mensaje = "Saldo insuficiente";
        SaldoInsuficienteException exception = new SaldoInsuficienteException(mensaje);

        assertEquals(mensaje, exception.getMessage());
    }
}