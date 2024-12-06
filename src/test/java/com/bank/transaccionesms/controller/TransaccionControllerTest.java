package com.bank.transaccionesms.controller;

import com.bank.transaccionesms.exception.SaldoInsuficienteException;
import com.bank.transaccionesms.model.TipoTransaccion;
import com.bank.transaccionesms.model.Transaccion;
import com.bank.transaccionesms.repository.TransaccionRepository;
import com.bank.transaccionesms.service.TransaccionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@WebFluxTest(TransaccionController.class)
public class TransaccionControllerTest {

    @MockBean
    TransaccionService transaccionService;

    WebTestClient client;

    Transaccion[] transacciones;

    @BeforeEach
    void setUp(ApplicationContext context) {
        MockitoAnnotations.openMocks(this);
        client = WebTestClient.bindToController(new TransaccionController(transaccionService))
                .build();

        transacciones = new Transaccion[] {
                Transaccion.builder()
                        .tipo(TipoTransaccion.DEPOSITO)
                        .numeroCuentaDestino("1234567890")
                        .cuentaDestinoId(1)
                        .monto(100.0)
                        .fecha(LocalDateTime.now())
                        .build(),
                Transaccion.builder()
                        .tipo(TipoTransaccion.RETIRO)
                        .numeroCuentaOrigen("1234567890")
                        .cuentaOrigenId(1)
                        .monto(50.0)
                        .fecha(LocalDateTime.now())
                        .build()
        };
    }

    @Test
    public void testObtenerHistorial() {
        given(transaccionService.obtenerHistorialTransacciones())
                .willReturn(Flux.just(transacciones));

        client.get().uri("/transacciones/historial")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Transaccion.class)
                .hasSize(2);
    }

    @Test
    public void testRealizarDeposito() {
        Transaccion deposito = transacciones[0];

        given(transaccionService.realizarDeposito(
                deposito.getNumeroCuentaDestino(),
                deposito.getCuentaDestinoId(),
                deposito.getMonto()))
                .willReturn(Mono.just(deposito));

        client.post().uri("/transacciones/deposito")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(deposito)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Transaccion.class)
                .isEqualTo(deposito);
    }

    @Test
    public void testRealizarTransferencia() {
        Transaccion transferencia = Transaccion.builder()
                .tipo(TipoTransaccion.TRANSFERENCIA)
                .numeroCuentaOrigen("1234567890")
                .numeroCuentaDestino("0987654321")
                .cuentaOrigenId(1)
                .cuentaDestinoId(2)
                .monto(100.0)
                .fecha(LocalDateTime.now())
                .build();

        given(transaccionService.realizarTransferencia(
                any(), any(), any(), any(), any()))
                .willReturn(Mono.just(transferencia));

        client.post().uri("/transacciones/transferencia")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(transferencia)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Transaccion.class)
                .isEqualTo(transferencia);
    }
}