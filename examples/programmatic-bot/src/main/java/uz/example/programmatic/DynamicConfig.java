package uz.example.programmatic;

import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.dispatcher.Router;
import io.jiogram.filter.Filter;
import io.jiogram.filter.FilterResult;
import io.jiogram.filter.Filters;
import io.jiogram.methods.AnswerCallbackQuery;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * Demonstrates the programmatic (non-annotation) API for registering handlers.
 * Use this approach when you need dynamic handler registration, or prefer
 * explicit wiring over annotation scanning.
 */
@Configuration
public class DynamicConfig {

    @Bean
    public Router programmaticRouter(Dispatcher dispatcher) {
        Router router = new Router("programmatic");

        // Handle /start command
        router.onMessage()
            .filter(Filters.command("start"))
            .handle((message, context) -> {
                var reply = SendMessage.of(
                    ChatId.of(message.chat().id()),
                    "Hello from the programmatic API! Try:\n"
                        + "/ping - Get a pong\n"
                        + "/upper <text> - Convert text to uppercase\n"
                        + "Or just send any message with a number in it."
                );
                return context.bot().execute(reply).then();
            });

        // Handle /ping command
        router.onMessage()
            .filter(Filters.command("ping"))
            .handle((message, context) -> {
                var reply = SendMessage.of(
                    ChatId.of(message.chat().id()),
                    "pong!"
                );
                return context.bot().execute(reply).then();
            });

        // Handle /upper command -- demonstrates accessing command_args from filter data
        router.onMessage()
            .filter(Filters.command("upper"))
            .handle((message, context) -> {
                // The CommandFilter puts "command_args" into the context
                String args = (String) context.get("command_args");
                String response = (args == null || args.isBlank())
                    ? "Usage: /upper <text>"
                    : args.toUpperCase();
                var reply = SendMessage.of(
                    ChatId.of(message.chat().id()),
                    response
                );
                return context.bot().execute(reply).then();
            });

        // Custom filter: match messages containing a number
        Filter<Message> containsNumber = (message, context) -> {
            String text = message.text();
            if (text != null && text.matches(".*\\d+.*")) {
                return Mono.just(FilterResult.passed());
            }
            return Mono.just(FilterResult.failed());
        };

        router.onMessage()
            .filter(containsNumber)
            .handle((message, context) -> {
                var reply = SendMessage.of(
                    ChatId.of(message.chat().id()),
                    "I noticed a number in your message!"
                );
                return context.bot().execute(reply).then();
            });

        // Composing filters: regex AND not a command
        Filter<Message> notCommand = Filters.command().negate();
        Filter<Message> hasEmail = Filters.regex("[\\w.+-]+@[\\w-]+\\.[\\w.]+");
        Filter<Message> emailNotCommand = hasEmail.and(notCommand);

        router.onMessage()
            .filter(emailNotCommand)
            .handle((message, context) -> {
                var reply = SendMessage.of(
                    ChatId.of(message.chat().id()),
                    "Looks like you sent an email address!"
                );
                return context.bot().execute(reply).then();
            });

        // Handle callback queries programmatically
        router.onCallbackQuery()
            .filter(Filters.callbackData("hello"))
            .handle((callback, context) -> {
                var answer = AnswerCallbackQuery.of(callback.id());
                return context.bot().execute(answer).then();
            });

        dispatcher.includeRouter(router);
        return router;
    }
}
