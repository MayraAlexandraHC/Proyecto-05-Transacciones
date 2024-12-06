/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.10.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bank.demo.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import com.bank.demo.model.Transaccion;
import com.bank.demo.model.TransaccionRequest;
import com.bank.demo.model.TransferenciaRequest;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T09:36:39.394312400-05:00[America/Lima]", comments = "Generator version: 7.10.0")
@Validated
@Tag(name = "transacciones", description = "the transacciones API")
public interface TransaccionesApi {

    default TransaccionesApiDelegate getDelegate() {
        return new TransaccionesApiDelegate() {};
    }

    /**
     * GET /transacciones/historial : Consultar historial de transacciones
     *
     * @param numeroCuenta  (optional)
     * @param fechaInicio  (optional)
     * @param fechaFin  (optional)
     * @return Historial de transacciones (status code 200)
     */
    @Operation(
        operationId = "obtenerHistorial",
        summary = "Consultar historial de transacciones",
        responses = {
            @ApiResponse(responseCode = "200", description = "Historial de transacciones", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Transaccion.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/transacciones/historial",
        produces = { "application/json" }
    )
    
    default ResponseEntity<List<Transaccion>> obtenerHistorial(
        @Parameter(name = "numeroCuenta", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "numeroCuenta", required = false) String numeroCuenta,
        @Parameter(name = "fechaInicio", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "fechaInicio", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
        @Parameter(name = "fechaFin", description = "", in = ParameterIn.QUERY) @Valid @RequestParam(value = "fechaFin", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin
    ) {
        return getDelegate().obtenerHistorial(numeroCuenta, fechaInicio, fechaFin);
    }


    /**
     * POST /transacciones/deposito : Registrar un depósito
     *
     * @param transaccionRequest  (required)
     * @return Depósito realizado exitosamente (status code 201)
     *         or Cuenta no encontrada (status code 404)
     *         or Datos inválidos (status code 400)
     */
    @Operation(
        operationId = "realizarDeposito",
        summary = "Registrar un depósito",
        responses = {
            @ApiResponse(responseCode = "201", description = "Depósito realizado exitosamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Transaccion.class))
            }),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/transacciones/deposito",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Transaccion> realizarDeposito(
        @Parameter(name = "TransaccionRequest", description = "", required = true) @Valid @RequestBody TransaccionRequest transaccionRequest
    ) {
        return getDelegate().realizarDeposito(transaccionRequest);
    }


    /**
     * POST /transacciones/retiro : Registrar un retiro
     *
     * @param transaccionRequest  (required)
     * @return Retiro realizado exitosamente (status code 201)
     *         or Cuenta no encontrada (status code 404)
     *         or Datos inválidos o saldo insuficiente (status code 400)
     */
    @Operation(
        operationId = "realizarRetiro",
        summary = "Registrar un retiro",
        responses = {
            @ApiResponse(responseCode = "201", description = "Retiro realizado exitosamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Transaccion.class))
            }),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o saldo insuficiente")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/transacciones/retiro",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Transaccion> realizarRetiro(
        @Parameter(name = "TransaccionRequest", description = "", required = true) @Valid @RequestBody TransaccionRequest transaccionRequest
    ) {
        return getDelegate().realizarRetiro(transaccionRequest);
    }


    /**
     * POST /transacciones/transferencia : Registrar una transferencia
     *
     * @param transferenciaRequest  (required)
     * @return Transferencia realizada exitosamente (status code 201)
     *         or Cuenta no encontrada (status code 404)
     *         or Datos inválidos o saldo insuficiente (status code 400)
     */
    @Operation(
        operationId = "realizarTransferencia",
        summary = "Registrar una transferencia",
        responses = {
            @ApiResponse(responseCode = "201", description = "Transferencia realizada exitosamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Transaccion.class))
            }),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos o saldo insuficiente")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/transacciones/transferencia",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Transaccion> realizarTransferencia(
        @Parameter(name = "TransferenciaRequest", description = "", required = true) @Valid @RequestBody TransferenciaRequest transferenciaRequest
    ) {
        return getDelegate().realizarTransferencia(transferenciaRequest);
    }

}