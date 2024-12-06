package com.bank.transaccionesms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transacciones")
public class Transaccion {
    @BsonId
    private String id;

    private TipoTransaccion tipo;

    private String numeroCuentaOrigen;

    private Integer cuentaOrigenId;

    private String numeroCuentaDestino;

    private Integer cuentaDestinoId;

    private Double monto;

    private LocalDateTime fecha;
}