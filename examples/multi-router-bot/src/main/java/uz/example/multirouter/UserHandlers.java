package uz.example.multirouter;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnCallbackQuery;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.AnswerCallbackQuery;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.CallbackQuery;
import io.jiogram.types.ChatId;
import io.jiogram.types.InlineKeyboardButton;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Handles user-facing commands and interactions.
 */
@TelegramController
public class UserHandlers {

    @OnMessage
    @Command("start")
    public SendMessage onStart(Message message) {
        String name = message.from() != null ? message.from().firstName() : "there";
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "Hello, " + name + "! I am a multi-router bot.\n\n"
                + "User commands: /start, /help, /menu\n"
                + "Admin commands: /stats, /broadcast"
        );
    }

    @OnMessage
    @Command("help")
    public SendMessage onHelp(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "This bot demonstrates splitting handlers across multiple @TelegramController classes.\n\n"
                + "Each class handles a different domain of commands."
        );
    }

    @OnMessage
    @Command("menu")
    public Mono<Void> onMenu(Message message, Bot bot) {
        var keyboard = new InlineKeyboardMarkup(List.of(
            List.of(
                new InlineKeyboardButton(
                    "Profile", null, null, null,
                    "menu_profile", null, null, null,
                    null, null, null, null, null
                ),
                new InlineKeyboardButton(
                    "Settings", null, null, null,
                    "menu_settings", null, null, null,
                    null, null, null, null, null
                )
            )
        ));

        var send = new SendMessage(
            null,
            ChatId.of(message.chat().id()),
            null, null,
            "Main menu:",
            null, null, null, null, null, null, null, null, null,
            keyboard
        );

        return bot.execute(send).then();
    }

    @OnCallbackQuery(prefix = "menu_")
    public AnswerCallbackQuery onMenuCallback(CallbackQuery callback) {
        String section = callback.data().substring("menu_".length());
        String text;
        switch (section) {
            case "profile":
                text = "Your profile: User #" + callback.from().id();
                break;
            case "settings":
                text = "Settings panel (coming soon)";
                break;
            default:
                text = "Unknown menu item";
        }
        return new AnswerCallbackQuery(callback.id(), text, false, null, null);
    }
}
