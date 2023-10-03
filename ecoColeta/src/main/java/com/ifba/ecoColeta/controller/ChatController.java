package com.ifba.ecoColeta.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.ifba.ecoColeta.chat.ChatMessage;

@Controller
public class ChatController {

    //método para enviar uma mensagem
    //Toda vez que recebemos uma mensagem, como carga útil, ela é enviada automaticamente para a barra de tópico pública
    @MessageMapping("/chat.sendMessage") //quero usar para invocar o método de enviar mensagem
    @SendTo("/topic/public") //para onde[tópico ou fila] enviar a mensagem
    public ChatMessage sendMessage(
            @Payload ChatMessage chatMessage //uma carga útil
    ) {
        return chatMessage; //retorna a mensagem de bate-papo
    }

    //método para adiconar usuário
    @MessageMapping("/chat.addUser") //caso um novo usuário entre, será possível estabelecer conexão entre ele e o websocket
    @SendTo("/topic/public")
    public ChatMessage addUser(
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor //acessador de cabeçalho
    ) {
       //add username na sessão websocket
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());//ponto de acesso obtem os atributos da sessão e atribui o nome do usuário/ ponto da mensagem remetente
        return chatMessage;
    }


}
