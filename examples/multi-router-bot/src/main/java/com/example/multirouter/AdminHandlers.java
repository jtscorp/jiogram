package com.example.multirouter;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;

/**
 * Handles admin-related commands.
 * In a real bot, you would add authorization checks.
 */
@TelegramController
public class AdminHandlers {

    @OnMessage
    @Command("stats")
    public SendMessage onStats(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "Bot statistics:\n- Users: 42\n- Messages today: 128"
        );
    }

    @OnMessage
    @Command("broadcast")
    public SendMessage onBroadcast(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "Broadcast feature is not yet implemented."
        );
    }
}
