package com.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;

@TelegramController
public class ThrottlingBot {

    @OnMessage
    @Command("start")
    public SendMessage start(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "Test passed. This command is protected by antiflood middleware."
        );
    }
}
