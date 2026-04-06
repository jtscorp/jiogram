package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * Auto-configuration for the long-polling update receiver.
 * Active when {@code telegram.mode=polling} (the default).
 */
@AutoConfiguration(after = JiogramAutoConfiguration.class)
@ConditionalOnBean(Bot.class)
@ConditionalOnProperty(prefix = "telegram", name = "mode", havingValue = "polling", matchIfMissing = true)
public class PollingAutoConfiguration {

    @Bean
    public PollingRunner pollingRunner(Bot bot, Dispatcher dispatcher, JiogramProperties properties) {
        return new PollingRunner(bot, dispatcher, properties);
    }
}
