package edu.kirkwood.shared.chat;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint(
        value="/chat/endpoint",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class}
)
public class ChatEndpoint {


    @OnOpen
    public void onOpen(Session session) {

    }

    @OnClose
    public void onClose(Session session) {

    }

    @OnMessage
    public void onMessage(Message message, Session session) {

    }

    @OnError
    public void onError(Throwable throwable) {

    }

}
