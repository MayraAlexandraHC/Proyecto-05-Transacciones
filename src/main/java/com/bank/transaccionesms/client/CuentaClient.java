package com.bank.transaccionesms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class CuentaClient {

    private final WebClient webClient;

    @Autowired
    public CuentaClient(@Qualifier("cuentaWebClient") WebClient webClient) {  // Aquí referenciamos el bean por su nombre
        this.webClient = webClient;
    }

    public Mono<Void> realizarDeposito(Integer cuentaId, Double monto) {
        return webClient.put()
                .uri("/cuentas/{cuentaId}/depositar", cuentaId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"monto\": " + monto + "}")
                .retrieve()
                .bodyToMono(Void.class)
                .onErrorResume(error -> Mono.error(new RuntimeException("Error al realizar el depósito: " + error.getMessage())));
    }

    public Mono<Void> realizarRetiro(Integer cuentaId, Double monto) {
        return webClient.put()
                .uri("/cuentas/{cuentaId}/retirar", cuentaId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"monto\": " + monto + "}")
                .retrieve()
                .bodyToMono(Void.class)
                .onErrorResume(error -> Mono.error(new RuntimeException("Error al realizar el retiro: " + error.getMessage())));
    }
}