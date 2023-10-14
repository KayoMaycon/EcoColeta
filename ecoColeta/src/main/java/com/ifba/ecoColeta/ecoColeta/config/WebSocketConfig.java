package com.ifba.ecoColeta.ecoColeta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //classe de configuração
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override //substituindo métodos implementados
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS(); //o caminho que aponta para a configuração segura
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); //adiciona o destino do app
        registry.enableSimpleBroker("/topic"); //esse tópico é o q vai pro controlador
    }
}
