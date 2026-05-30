package com.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.User;
import org.springframework.context.MessageSource;

import java.util.Locale;

@TelegramController
public class I18nBot {

    private final MessageSource messageSource;

    public I18nBot(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @OnMessage
    @Command("start")
    public SendMessage start(Message message) {
        User from = message.from();
        String firstName = from == null ? "there" : from.firstName();
        String languageCode = from == null || from.languageCode() == null
            ? "en"
            : from.languageCode();
        Locale locale = Locale.forLanguageTag(languageCode);

        String greeting = messageSource.getMessage("greeting", new Object[] { firstName }, locale);
        String language = messageSource.getMessage("language", new Object[] { languageCode }, locale);
        return SendMessage.of(ChatId.of(message.chat().id()), greeting + "\n" + language);
    }
}
