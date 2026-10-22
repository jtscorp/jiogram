package com.example.commandbot;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnCallbackQuery;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.AnswerCallbackQuery;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.InlineKeyboardButton;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Demonstrates handling commands, inline keyboards, and callback queries.
 */
@TelegramController
public class CommandBot {

    @OnMessage
    @Command("start")
    public SendMessage onStart(Message message) {
        return SendMessage.answer(
            message,
            "Welcome! Use /help to see available commands."
        );
    }

    @OnMessage
    @Command("help")
    public SendMessage onHelp(Message message) {
        String helpText = """
            <b>Available commands:</b>
            /start - Start the bot
            /help - Show this help message
            /settings - Open settings menu""";
        return SendMessage.answer(
            message,
            helpText
        );
    }

    @OnMessage
    @Command("settings")
    public Mono<Void> onSettings(Message message, Bot bot) {
        var keyboard = new InlineKeyboardMarkup(List.of(
            List.of(
                InlineKeyboardButton.of("Language").withCallbackData("settings_lang"),
                InlineKeyboardButton.of("Notifications").withCallbackData("settings_notif")
            ),
            List.of(
                InlineKeyboardButton.of("About").withCallbackData("settings_about")
            )
        ));

        return bot.execute(SendMessage.answer(message, "Settings:").withReplyMarkup(keyboard)).then();
    }

    @OnCallbackQuery(prefix = "settings_")
    public Mono<Void> onSettingsCallback(CallbackQuery callback, Bot bot) {
        String data = callback.data(); // e.g., "settings_lang"
        String section = data.substring("settings_".length());

        String responseText = switch (section) {
            case "lang" -> "Language settings: English (default)";
            case "notif" -> "Notifications: enabled";
            case "about" -> "Command Bot v1.0 -- built with Jiogram";
            default -> "Unknown setting";
        };

        // Answer the callback query (removes the loading indicator)
        var answer = AnswerCallbackQuery.of(callback.id()).withText(responseText);

        return bot.execute(answer).then();
    }
}
