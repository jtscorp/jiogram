package com.example;

import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;

@TelegramController
public class WebhookEchoBot {

    @OnMessage
    public SendMessage echo(Message message) {
        String text = message.text();
        if (text == null) {
            return null;
        }
        return SendMessage.of(ChatId.of(message.chat().id()), text);
    }
}
