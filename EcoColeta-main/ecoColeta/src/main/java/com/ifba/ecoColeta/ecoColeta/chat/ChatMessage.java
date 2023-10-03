package com.ecocoleta.chat.chat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@Builder
public class ChatMessage {

    private  String content; //conteúdo
    private String sender;
    private MessageType type; //criar enum q permite q a mensagem seja privada
}
