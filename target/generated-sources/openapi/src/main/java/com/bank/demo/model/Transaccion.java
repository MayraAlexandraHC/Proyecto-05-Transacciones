package com.bank.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Transaccion
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T09:36:39.394312400-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public class Transaccion {

  private String id;

  /**
   * Gets or Sets tipo
   */
  public enum TipoEnum {
    DEPOSITO("DEPOSITO"),
    
    RETIRO("RETIRO"),
    
    TRANSFERENCIA("TRANSFERENCIA");

    private String value;

    TipoEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TipoEnum fromValue(String value) {
      for (TipoEnum b : TipoEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private TipoEnum tipo;

  private String numeroCuentaOrigen;

  private Integer cuentaOrigenId;

  private String numeroCuentaDestino;

  private Integer cuentaDestinoId;

  private Double monto;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime fecha;

  public Transaccion id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Transaccion tipo(TipoEnum tipo) {
    this.tipo = tipo;
    return this;
  }

  /**
   * Get tipo
   * @return tipo
   */
  
  @Schema(name = "tipo", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tipo")
  public TipoEnum getTipo() {
    return tipo;
  }

  public void setTipo(TipoEnum tipo) {
    this.tipo = tipo;
  }

  public Transaccion numeroCuentaOrigen(String numeroCuentaOrigen) {
    this.numeroCuentaOrigen = numeroCuentaOrigen;
    return this;
  }

  /**
   * Get numeroCuentaOrigen
   * @return numeroCuentaOrigen
   */
  
  @Schema(name = "numeroCuentaOrigen", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numeroCuentaOrigen")
  public String getNumeroCuentaOrigen() {
    return numeroCuentaOrigen;
  }

  public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
    this.numeroCuentaOrigen = numeroCuentaOrigen;
  }

  public Transaccion cuentaOrigenId(Integer cuentaOrigenId) {
    this.cuentaOrigenId = cuentaOrigenId;
    return this;
  }

  /**
   * Get cuentaOrigenId
   * @return cuentaOrigenId
   */
  
  @Schema(name = "cuentaOrigenId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cuentaOrigenId")
  public Integer getCuentaOrigenId() {
    return cuentaOrigenId;
  }

  public void setCuentaOrigenId(Integer cuentaOrigenId) {
    this.cuentaOrigenId = cuentaOrigenId;
  }

  public Transaccion numeroCuentaDestino(String numeroCuentaDestino) {
    this.numeroCuentaDestino = numeroCuentaDestino;
    return this;
  }

  /**
   * Get numeroCuentaDestino
   * @return numeroCuentaDestino
   */
  
  @Schema(name = "numeroCuentaDestino", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("numeroCuentaDestino")
  public String getNumeroCuentaDestino() {
    return numeroCuentaDestino;
  }

  public void setNumeroCuentaDestino(String numeroCuentaDestino) {
    this.numeroCuentaDestino = numeroCuentaDestino;
  }

  public Transaccion cuentaDestinoId(Integer cuentaDestinoId) {
    this.cuentaDestinoId = cuentaDestinoId;
    return this;
  }

  /**
   * Get cuentaDestinoId
   * @return cuentaDestinoId
   */
  
  @Schema(name = "cuentaDestinoId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cuentaDestinoId")
  public Integer getCuentaDestinoId() {
    return cuentaDestinoId;
  }

  public void setCuentaDestinoId(Integer cuentaDestinoId) {
    this.cuentaDestinoId = cuentaDestinoId;
  }

  public Transaccion monto(Double monto) {
    this.monto = monto;
    return this;
  }

  /**
   * Get monto
   * @return monto
   */
  
  @Schema(name = "monto", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("monto")
  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  public Transaccion fecha(OffsetDateTime fecha) {
    this.fecha = fecha;
    return this;
  }

  /**
   * Get fecha
   * @return fecha
   */
  @Valid 
  @Schema(name = "fecha", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fecha")
  public OffsetDateTime getFecha() {
    return fecha;
  }

  public void setFecha(OffsetDateTime fecha) {
    this.fecha = fecha;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaccion transaccion = (Transaccion) o;
    return Objects.equals(this.id, transaccion.id) &&
        Objects.equals(this.tipo, transaccion.tipo) &&
        Objects.equals(this.numeroCuentaOrigen, transaccion.numeroCuentaOrigen) &&
        Objects.equals(this.cuentaOrigenId, transaccion.cuentaOrigenId) &&
        Objects.equals(this.numeroCuentaDestino, transaccion.numeroCuentaDestino) &&
        Objects.equals(this.cuentaDestinoId, transaccion.cuentaDestinoId) &&
        Objects.equals(this.monto, transaccion.monto) &&
        Objects.equals(this.fecha, transaccion.fecha);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, tipo, numeroCuentaOrigen, cuentaOrigenId, numeroCuentaDestino, cuentaDestinoId, monto, fecha);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaccion {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    numeroCuentaOrigen: ").append(toIndentedString(numeroCuentaOrigen)).append("\n");
    sb.append("    cuentaOrigenId: ").append(toIndentedString(cuentaOrigenId)).append("\n");
    sb.append("    numeroCuentaDestino: ").append(toIndentedString(numeroCuentaDestino)).append("\n");
    sb.append("    cuentaDestinoId: ").append(toIndentedString(cuentaDestinoId)).append("\n");
    sb.append("    monto: ").append(toIndentedString(monto)).append("\n");
    sb.append("    fecha: ").append(toIndentedString(fecha)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

