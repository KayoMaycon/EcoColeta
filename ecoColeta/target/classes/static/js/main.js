'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null; //web socket
var username = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

//quando clicar em conect, cria conexão

function connect(event){
    username = document.querySelector('#name').value.trim(); //remover espaços
    if (username) {
        usernamePage.classList.add('hidden'); //oculta elemento <s/ display>
        chatPage.classList.remove('hidden');

        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);

        stompClient.connect({}, onConnected, onError);
    }
    event.preventDefault();
}

function onConnected() {
    //inscrever no tópico público
    stompClient.subscribe('/topic/public', onMessageReceived);

    // informar username ao servidor já q ele se juntou
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )

    connectingElement.classList.add('hidden');
}

function onError() {
    connectingElement.textContent = 'Não conseguimos nos conectar ao servidor. Por favor, atualize a página!';
    connectingElement.style.color = 'red';
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body); //extrair o corpo da carga útil para JSON

    var messageElement = document.createElement('li'); //fará parte da lista

    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' juntou-se!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' saiu!';
    } else {
        messageElement.classList.add('chat-message');//add ao chat

        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);//avatar com inicial
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);

        messageElement.appendChild(avatarElement);

        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }

    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);

    messageElement.appendChild(textElement);

    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}

function sendMessage() {

    var messageContent = messageInput.value.trim();

    if(messageContent && stompClient) { //se tenho menssagem e conexão
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };
    stompClient.send(
        '/app/chat.sendMessage',
        {},
        JSON.stringify(chatMessage)
        );
        messageInput.value = ''; //esvazia novamente o campo
    }
    event.preventDefault();

}

function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}

usernameForm.addEventListener('submit', connect, true);
messageForm.addEventListener('submit', sendMessage, true);