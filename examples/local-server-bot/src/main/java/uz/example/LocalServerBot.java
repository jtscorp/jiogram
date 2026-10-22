package uz.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.GetMe;
import io.jiogram.methods.LogOut;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

@TelegramController
public class LocalServerBot {

    @OnMessage
    @Command("start")
    public Mono<Void> start(Message message, Bot bot) {
        ChatId chatId = ChatId.of(message.chat().id());
        return bot.execute(new GetMe())
            .flatMap(me -> bot.execute(SendMessage.of(
                chatId,
                "Connected as @" + me.username() + " through the configured Bot API endpoint."
            )))
            .then();
    }

    @OnMessage
    @Command("logout")
    public Mono<Void> logout(Message message, Bot bot) {
        ChatId chatId = ChatId.of(message.chat().id());
        return bot.execute(new LogOut())
            .then(bot.execute(SendMessage.of(
                chatId,
                "logOut request sent. Start your local Bot API server before polling again."
            )))
            .then();
    }
}
