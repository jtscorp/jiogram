package uz.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.SendChatAction;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatAction;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@TelegramController
public class ProxyBot {

    private static final String GET_IP_URL = "https://api.ipify.org";

    private final WebClient webClient;

    public ProxyBot(WebClient webClient) {
        this.webClient = webClient;
    }

    @OnMessage
    @Command("start")
    public Mono<Void> start(Message message, Bot bot) {
        ChatId chatId = ChatId.of(message.chat().id());
        return bot.execute(SendChatAction.of(chatId, ChatAction.TYPING))
            .then(webClient.get().uri(GET_IP_URL).retrieve().bodyToMono(String.class))
            .flatMap(ip -> bot.execute(SendMessage.of(
                chatId,
                emojize(":globe_showing_Americas: *IP:* `" + ip + "`")
            )))
            .then();
    }

    private static String emojize(String text) {
        return text
            .replace(":globe_showing_Americas:", "\uD83C\uDF0E")
            .replace(":locked_with_key:", "\uD83D\uDD10");
    }
}
