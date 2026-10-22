package com.example;

import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.dispatcher.Router;
import io.jiogram.filter.Filters;
import io.jiogram.methods.GetMe;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.regex.Pattern;

@Configuration
public class RegexpConfig {

    private static final Pattern ITEM_COMMAND = Pattern.compile("^/item_([0-9]+)(?:@\\w+)?(?:\\s.*)?$");
    private static final Pattern START_ITEM = Pattern.compile("^/start\\s+item_([0-9]+)$");

    @Bean
    public Router regexpRouter(Dispatcher dispatcher) {
        Router router = new Router("regexp");

        router.onMessage()
            .filter(Filters.regex("^/item_[0-9]+"))
            .handle((message, context) -> {
                var matcher = ITEM_COMMAND.matcher(message.text());
                if (!matcher.matches()) {
                    return context.bot().execute(SendMessage.of(
                        ChatId.of(message.chat().id()),
                        "Use /item_1234"
                    )).then();
                }
                String itemId = matcher.group(1);
                return context.bot().execute(SendMessage.of(
                    ChatId.of(message.chat().id()),
                    "You have requested item <code>" + itemId + "</code>"
                )).then();
            });

        router.onMessage()
            .filter(Filters.command("start"))
            .handle((message, context) -> {
                var matcher = START_ITEM.matcher(message.text());
                if (matcher.matches()) {
                    return context.bot().execute(SendMessage.of(
                        ChatId.of(message.chat().id()),
                        "Deep link item id: <code>" + matcher.group(1) + "</code>"
                    )).then();
                }

                return context.bot().execute(new GetMe())
                    .flatMap(me -> {
                        String username = me.username() == null ? "your_bot" : me.username();
                        String text = "Send /item_1234 or open https://t.me/"
                            + username
                            + "?start=item_1234";
                        return context.bot().execute(SendMessage.of(ChatId.of(message.chat().id()), text));
                    })
                    .then();
            });

        dispatcher.includeRouter(router);
        return router;
    }
}
