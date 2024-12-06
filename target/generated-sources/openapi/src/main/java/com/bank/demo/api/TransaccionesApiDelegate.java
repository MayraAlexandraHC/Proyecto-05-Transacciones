package com.bank.demo.api;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import com.bank.demo.model.Transaccion;
import com.bank.demo.model.TransaccionRequest;
import com.bank.demo.model.TransferenciaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link TransaccionesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-12-06T09:36:39.394312400-05:00[America/Lima]", comments = "Generator version: 7.10.0")
public interface TransaccionesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /transacciones/historial : Consultar historial de transacciones
     *
     * @param numeroCuenta  (optional)
     * @param fechaInicio  (optional)
     * @param fechaFin  (optional)
     * @return Historial de transacciones (status code 200)
     * @see TransaccionesApi#obtenerHistorial
     */
    default ResponseEntity<List<Transaccion>> obtenerHistorial(String numeroCuenta,
        LocalDate fechaInicio,
        LocalDate fechaFin) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"fecha\" : \"2000-01-23T04:56:07.000+00:00\", \"tipo\" : \"DEPOSITO\", \"numeroCuentaDestino\" : \"numeroCuentaDestino\", \"monto\" : 1.4658129805029452, \"id\" : \"id\", \"cuentaDestinoId\" : 6, \"numeroCuentaOrigen\" : \"numeroCuentaOrigen\", \"cuentaOrigenId\" : 0 }, { \"fecha\" : \"2000-01-23T04:56:07.000+00:00\", \"tipo\" : \"DEPOSITO\", \"numeroCuentaDestino\" : \"numeroCuentaDestino\", \"monto\" : 1.4658129805029452, \"id\" : \"id\", \"cuentaDestinoId\" : 6, \"numeroCuentaOrigen\" : \"numeroCuentaOrigen\", \"cuentaOrigenId\" : 0 } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transacciones/deposito : Registrar un depósito
     *
     * @param transaccionRequest  (required)
     * @return Depósito realizado exitosamente (status code 201)
     *         or Cuenta no encontrada (status code 404)
     *         or Datos inválidos (status code 400)
     * @see TransaccionesApi#realizarDeposito
     */
    default ResponseEntity<Transaccion> realizarDeposito(TransaccionRequest transaccionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fecha\" : \"2000-01-23T04:56:07.000+00:00\", \"tipo\" : \"DEPOSITO\", \"numeroCuentaDestino\" : \"numeroCuentaDestino\", \"monto\" : 1.4658129805029452, \"id\" : \"id\", \"cuentaDestinoId\" : 6, \"numeroCuentaOrigen\" : \"numeroCuentaOrigen\", \"cuentaOrigenId\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transacciones/retiro : Registrar un retiro
     *
     * @param transaccionRequest  (required)
     * @return Retiro realizado exitosamente (status code 201)
     *         or Cuenta no encontrada (status code 404)
     *         or Datos inválidos o saldo insuficiente (status code 400)
     * @see TransaccionesApi#realizarRetiro
     */
    default ResponseEntity<Transaccion> realizarRetiro(TransaccionRequest transaccionRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fecha\" : \"2000-01-23T04:56:07.000+00:00\", \"tipo\" : \"DEPOSITO\", \"numeroCuentaDestino\" : \"numeroCuentaDestino\", \"monto\" : 1.4658129805029452, \"id\" : \"id\", \"cuentaDestinoId\" : 6, \"numeroCuentaOrigen\" : \"numeroCuentaOrigen\", \"cuentaOrigenId\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /transacciones/transferencia : Registrar una transferencia
     *
     * @param transferenciaRequest  (required)
     * @return Transferencia realizada exitosamente (status code 201)
     *         or Cuenta no encontrada (status code 404)
     *         or Datos inválidos o saldo insuficiente (status code 400)
     * @see TransaccionesApi#realizarTransferencia
     */
    default ResponseEntity<Transaccion> realizarTransferencia(TransferenciaRequest transferenciaRequest) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"fecha\" : \"2000-01-23T04:56:07.000+00:00\", \"tipo\" : \"DEPOSITO\", \"numeroCuentaDestino\" : \"numeroCuentaDestino\", \"monto\" : 1.4658129805029452, \"id\" : \"id\", \"cuentaDestinoId\" : 6, \"numeroCuentaOrigen\" : \"numeroCuentaOrigen\", \"cuentaOrigenId\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
