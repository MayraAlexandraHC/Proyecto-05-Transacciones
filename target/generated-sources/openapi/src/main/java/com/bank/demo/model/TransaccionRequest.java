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
 * TransaccionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T09:36:39.394312400-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public class TransaccionRequest {

  private String numeroCuenta;

  private Integer cuentaId;

  private Double monto;

  public TransaccionRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public TransaccionRequest(String numeroCuenta, Integer cuentaId, Double monto) {
    this.numeroCuenta = numeroCuenta;
    this.cuentaId = cuentaId;
    this.monto = monto;
  }

  public TransaccionRequest numeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
    return this;
  }

  /**
   * Número de cuenta
   * @return numeroCuenta
   */
  @NotNull 
  @Schema(name = "numeroCuenta", description = "Número de cuenta", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("numeroCuenta")
  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public TransaccionRequest cuentaId(Integer cuentaId) {
    this.cuentaId = cuentaId;
    return this;
  }

  /**
   * ID de la cuenta
   * @return cuentaId
   */
  @NotNull 
  @Schema(name = "cuentaId", description = "ID de la cuenta", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cuentaId")
  public Integer getCuentaId() {
    return cuentaId;
  }

  public void setCuentaId(Integer cuentaId) {
    this.cuentaId = cuentaId;
  }

  public TransaccionRequest monto(Double monto) {
    this.monto = monto;
    return this;
  }

  /**
   * Monto de la transacción
   * @return monto
   */
  @NotNull 
  @Schema(name = "monto", description = "Monto de la transacción", requiredMode = Schema.RequiredMode.REQUIRED)
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
    TransaccionRequest transaccionRequest = (TransaccionRequest) o;
    return Objects.equals(this.numeroCuenta, transaccionRequest.numeroCuenta) &&
        Objects.equals(this.cuentaId, transaccionRequest.cuentaId) &&
        Objects.equals(this.monto, transaccionRequest.monto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numeroCuenta, cuentaId, monto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransaccionRequest {\n");
    sb.append("    numeroCuenta: ").append(toIndentedString(numeroCuenta)).append("\n");
    sb.append("    cuentaId: ").append(toIndentedString(cuentaId)).append("\n");
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

