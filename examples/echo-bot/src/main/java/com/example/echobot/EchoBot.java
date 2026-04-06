package com.example.echobot;

import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;

/**
 * Simplest possible bot: echoes back any text message the user sends.
 */
@TelegramController
public class EchoBot {

    @OnMessage
    public SendMessage echo(Message message) {
        String text = message.text();
        if (text == null) {
            return null; // Ignore non-text messages
        }
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            text
        );
    }
}
