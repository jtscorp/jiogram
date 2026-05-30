package com.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.SendChatAction;
import io.jiogram.methods.SendMediaGroup;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatAction;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputMedia;
import io.jiogram.types.InputMediaPhoto;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@TelegramController
public class MediaGroupBot {

    @OnMessage
    @Command("start")
    public Mono<Void> start(Message message, Bot bot) {
        ChatId chatId = ChatId.of(message.chat().id());
        List<InputMedia> media = List.of(
            new InputMediaPhoto(
                InputMediaType.PHOTO,
                "https://picsum.photos/id/1025/800/500",
                "Photo from URL",
                null,
                null,
                null,
                null
            ),
            new InputMediaPhoto(
                InputMediaType.PHOTO,
                "https://picsum.photos/id/1062/800/500",
                "Another photo",
                null,
                null,
                null,
                null
            )
        );

        return bot.execute(SendMessage.of(chatId, "Sending a media group..."))
            .then(bot.execute(SendChatAction.of(chatId, ChatAction.UPLOAD_PHOTO)))
            .then(Mono.delay(Duration.ofSeconds(1)))
            .then(bot.execute(SendMediaGroup.of(chatId, media)))
            .then();
    }
}
