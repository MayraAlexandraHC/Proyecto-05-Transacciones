package com.bank.transaccionesms.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionExceptionTest {

    @Test
    void testTransaccionException() {
        String mensaje = "Error en la transacción";
        TransaccionException exception = new TransaccionException(mensaje);

        assertEquals(mensaje, exception.getMessage());
    }
}