package com.bank.transaccionesms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${accountms.url}")
    private String cuentaServiceUrl;

    @Bean("cuentaWebClient")
    public WebClient accountWebClient() {
        System.out.println("Configurando WebClient para AccountMs");
        return WebClient.builder()
                .baseUrl(cuentaServiceUrl)
                .build();
    }
}