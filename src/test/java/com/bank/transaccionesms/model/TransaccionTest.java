package com.bank.transaccionesms.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TransaccionTest {

    @Test
    void testTransaccionBuilder() {
        LocalDateTime fecha = LocalDateTime.now();

        Transaccion transaccion = Transaccion.builder()
                .tipo(TipoTransaccion.DEPOSITO)
                .numeroCuentaDestino("1234567890")
                .cuentaDestinoId(1)
                .monto(100.0)
                .fecha(fecha)
                .build();

        assertNotNull(transaccion);
        assertEquals(TipoTransaccion.DEPOSITO, transaccion.getTipo());
        assertEquals("1234567890", transaccion.getNumeroCuentaDestino());
        assertEquals(1, transaccion.getCuentaDestinoId());
        assertEquals(100.0, transaccion.getMonto());
        assertEquals(fecha, transaccion.getFecha());
    }

    @Test
    void testTransaccionEquals() {
        Transaccion t1 = new Transaccion();
        t1.setId("1");
        t1.setTipo(TipoTransaccion.DEPOSITO);
        t1.setMonto(100.0);

        Transaccion t2 = new Transaccion();
        t2.setId("1");
        t2.setTipo(TipoTransaccion.DEPOSITO);
        t2.setMonto(100.0);

        assertEquals(t1, t2);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testTransaccionNotEquals() {
        Transaccion t1 = new Transaccion();
        t1.setId("1");

        Transaccion t2 = new Transaccion();
        t2.setId("2");

        assertNotEquals(t1, t2);
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

    @Test
    void testTransaccionToString() {
        Transaccion transaccion = Transaccion.builder()
                .id("1")
                .tipo(TipoTransaccion.DEPOSITO)
                .numeroCuentaDestino("1234567890")
                .cuentaDestinoId(1)
                .monto(100.0)
                .fecha(LocalDateTime.now())
                .build();

        String toString = transaccion.toString();

        assertNotNull(toString);
        assertTrue(toString.contains("1")); // id
        assertTrue(toString.contains("DEPOSITO")); // tipo
        assertTrue(toString.contains("1234567890")); // numeroCuenta
        assertTrue(toString.contains("100.0")); // monto
    }

    @Test
    void testTransaccionNoArgsConstructor() {
        Transaccion transaccion = new Transaccion();

        assertNotNull(transaccion);
        assertNull(transaccion.getId());
        assertNull(transaccion.getTipo());
        assertNull(transaccion.getMonto());
    }

    @Test
    void testTransaccionAllArgsConstructor() {
        LocalDateTime fecha = LocalDateTime.now();

        Transaccion transaccion = new Transaccion(
                "1",
                TipoTransaccion.DEPOSITO,
                "1234567890",
                1,
                "0987654321",
                2,
                100.0,
                fecha
        );

        assertNotNull(transaccion);
        assertEquals("1", transaccion.getId());
        assertEquals(TipoTransaccion.DEPOSITO, transaccion.getTipo());
        assertEquals("1234567890", transaccion.getNumeroCuentaOrigen());
        assertEquals(1, transaccion.getCuentaOrigenId());
        assertEquals("0987654321", transaccion.getNumeroCuentaDestino());
        assertEquals(2, transaccion.getCuentaDestinoId());
        assertEquals(100.0, transaccion.getMonto());
        assertEquals(fecha, transaccion.getFecha());
    }
}
