package com.bank.transaccionesms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String mensaje;

    private String codigo;

    private int status;

    private LocalDateTime timestamp;

    public ErrorResponse(String mensaje, String codigo, int status) {
        this.mensaje = mensaje;
        this.codigo = codigo;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
