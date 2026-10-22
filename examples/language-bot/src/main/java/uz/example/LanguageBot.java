package uz.example;

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

        String text = """
            <b>Info about your language:</b>
            <b>Code:</b> <code>%s</code>
            <b>Territory:</b> <code>%s</code>
            <b>Language name:</b> <code>%s</code>
            <b>English language name:</b> <code>%s</code>
            """.formatted(code, country, languageName, englishName);

        return SendMessage.of(ChatId.of(message.chat().id()), text);
    }
}
