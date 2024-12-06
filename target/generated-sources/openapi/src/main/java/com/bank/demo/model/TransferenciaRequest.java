package com.bank.demo.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * TransferenciaRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T09:36:39.394312400-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public class TransferenciaRequest {

  private String numeroCuentaOrigen;

  private Integer cuentaOrigenId;

  private String numeroCuentaDestino;

  private Integer cuentaDestinoId;

  private Double monto;

  public TransferenciaRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TransferenciaRequest(String numeroCuentaOrigen, Integer cuentaOrigenId, String numeroCuentaDestino, Integer cuentaDestinoId, Double monto) {
    this.numeroCuentaOrigen = numeroCuentaOrigen;
    this.cuentaOrigenId = cuentaOrigenId;
    this.numeroCuentaDestino = numeroCuentaDestino;
    this.cuentaDestinoId = cuentaDestinoId;
    this.monto = monto;
  }

  public TransferenciaRequest numeroCuentaOrigen(String numeroCuentaOrigen) {
    this.numeroCuentaOrigen = numeroCuentaOrigen;
    return this;
  }

  /**
   * Número de cuenta origen
   * @return numeroCuentaOrigen
   */
  @NotNull 
  @Schema(name = "numeroCuentaOrigen", description = "Número de cuenta origen", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroCuentaOrigen")
  public String getNumeroCuentaOrigen() {
    return numeroCuentaOrigen;
  }

  public void setNumeroCuentaOrigen(String numeroCuentaOrigen) {
    this.numeroCuentaOrigen = numeroCuentaOrigen;
  }

  public TransferenciaRequest cuentaOrigenId(Integer cuentaOrigenId) {
    this.cuentaOrigenId = cuentaOrigenId;
    return this;
  }

  /**
   * ID de la cuenta origen
   * @return cuentaOrigenId
   */
  @NotNull 
  @Schema(name = "cuentaOrigenId", description = "ID de la cuenta origen", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cuentaOrigenId")
  public Integer getCuentaOrigenId() {
    return cuentaOrigenId;
  }

  public void setCuentaOrigenId(Integer cuentaOrigenId) {
    this.cuentaOrigenId = cuentaOrigenId;
  }

  public TransferenciaRequest numeroCuentaDestino(String numeroCuentaDestino) {
    this.numeroCuentaDestino = numeroCuentaDestino;
    return this;
  }

  /**
   * Número de cuenta destino
   * @return numeroCuentaDestino
   */
  @NotNull 
  @Schema(name = "numeroCuentaDestino", description = "Número de cuenta destino", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroCuentaDestino")
  public String getNumeroCuentaDestino() {
    return numeroCuentaDestino;
  }

  public void setNumeroCuentaDestino(String numeroCuentaDestino) {
    this.numeroCuentaDestino = numeroCuentaDestino;
  }

  public TransferenciaRequest cuentaDestinoId(Integer cuentaDestinoId) {
    this.cuentaDestinoId = cuentaDestinoId;
    return this;
  }

  /**
   * ID de la cuenta destino
   * @return cuentaDestinoId
   */
  @NotNull 
  @Schema(name = "cuentaDestinoId", description = "ID de la cuenta destino", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cuentaDestinoId")
  public Integer getCuentaDestinoId() {
    return cuentaDestinoId;
  }

  public void setCuentaDestinoId(Integer cuentaDestinoId) {
    this.cuentaDestinoId = cuentaDestinoId;
  }

  public TransferenciaRequest monto(Double monto) {
    this.monto = monto;
    return this;
  }

  /**
   * Monto a transferir
   * @return monto
   */
  @NotNull 
  @Schema(name = "monto", description = "Monto a transferir", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("monto")
  public Double getMonto() {
    return monto;
  }

  public void setMonto(Double monto) {
    this.monto = monto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferenciaRequest transferenciaRequest = (TransferenciaRequest) o;
    return Objects.equals(this.numeroCuentaOrigen, transferenciaRequest.numeroCuentaOrigen) &&
        Objects.equals(this.cuentaOrigenId, transferenciaRequest.cuentaOrigenId) &&
        Objects.equals(this.numeroCuentaDestino, transferenciaRequest.numeroCuentaDestino) &&
        Objects.equals(this.cuentaDestinoId, transferenciaRequest.cuentaDestinoId) &&
        Objects.equals(this.monto, transferenciaRequest.monto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroCuentaOrigen, cuentaOrigenId, numeroCuentaDestino, cuentaDestinoId, monto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferenciaRequest {\n");
    sb.append("    numeroCuentaOrigen: ").append(toIndentedString(numeroCuentaOrigen)).append("\n");
    sb.append("    cuentaOrigenId: ").append(toIndentedString(cuentaOrigenId)).append("\n");
    sb.append("    numeroCuentaDestino: ").append(toIndentedString(numeroCuentaDestino)).append("\n");
    sb.append("    cuentaDestinoId: ").append(toIndentedString(cuentaDestinoId)).append("\n");
    sb.append("    monto: ").append(toIndentedString(monto)).append("\n");
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

