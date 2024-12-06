package com.bank.transaccionesms.exception;

public class CuentaNotFoundException extends TransaccionException {
    public CuentaNotFoundException(String message) {
        super(message);
    }
}
