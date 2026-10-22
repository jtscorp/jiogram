package uz.example;

import io.jiogram.bot.Bot;
import io.jiogram.methods.SendMessage;
import io.jiogram.session.TelegramApiException;
import io.jiogram.types.ChatId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BroadcastRunner implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(BroadcastRunner.class);

    private final Bot bot;
    private final boolean enabled;
    private final String userIds;
    private final String text;

    public BroadcastRunner(
            Bot bot,
            @Value("${broadcast.enabled:false}") boolean enabled,
            @Value("${broadcast.user-ids:}") String userIds,
            @Value("${broadcast.text:<b>Hello from Jiogram!</b>}") String text) {
        this.bot = bot;
        this.enabled = enabled;
        this.userIds = userIds;
        this.text = text;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (!enabled) {
            log.info("Broadcast is disabled. Set BROADCAST_ENABLED=true to send messages.");
            return;
        }

        List<Long> targets = parseUserIds(userIds);
        Flux.fromIterable(targets)
            .delayElements(Duration.ofMillis(50))
            .flatMap(this::sendSafely, 1)
            .count()
            .doOnNext(count -> log.info("Broadcast completed. Successful messages: {}", count))
            .subscribe();
    }

    private Mono<Long> sendSafely(long userId) {
        return bot.execute(SendMessage.of(ChatId.of(userId), text))
            .doOnSuccess(ignored -> log.info("Target {}: success", userId))
            .thenReturn(userId)
            .onErrorResume(TelegramApiException.class, e -> {
                log.warn("Target {}: Telegram API error {} - {}", userId, e.errorCode(), e.getMessage());
                return Mono.empty();
            })
            .onErrorResume(e -> {
                log.warn("Target {}: failed - {}", userId, e.getMessage());
                return Mono.empty();
            });
    }

    private static List<Long> parseUserIds(String raw) {
        if (raw == null || raw.isBlank()) {
            return List.of();
        }
        return Arrays.stream(raw.split(","))
            .map(String::trim)
            .filter(value -> !value.isEmpty())
            .map(Long::parseLong)
            .collect(Collectors.toList());
    }
}
