package com.example;

import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import io.jiogram.types.User;

import java.util.Locale;

@TelegramController
public class LanguageBot {

    @OnMessage
    public SendMessage checkLanguage(Message message) {
        User from = message.from();
        String code = from == null || from.languageCode() == null
            ? "und"
            : from.languageCode();
        Locale locale = Locale.forLanguageTag(code);
        String languageName = locale.getDisplayLanguage(locale);
        String englishName = locale.getDisplayLanguage(Locale.ENGLISH);
        String country = locale.getCountry().isBlank() ? "Unknown" : locale.getCountry();

        String text = String.format("<b>Info about your language:</b>\n"
            + "<b>Code:</b> <code>%s</code>\n"
            + "<b>Territory:</b> <code>%s</code>\n"
            + "<b>Language name:</b> <code>%s</code>\n"
            + "<b>English language name:</b> <code>%s</code>\n",
            code, country, languageName, englishName);

        return SendMessage.of(ChatId.of(message.chat().id()), text);
    }
}
