package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.fsm.middleware.FSMMiddleware;
import io.jiogram.fsm.storage.MemoryStateStorage;
import io.jiogram.fsm.storage.StateStorage;
import io.jiogram.handler.HandlerRegistry;
import io.jiogram.session.TelegramSession;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class JiogramAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
        .withConfiguration(AutoConfigurations.of(
            JiogramAutoConfiguration.class,
            FSMAutoConfiguration.class,
            PollingAutoConfiguration.class
        ));

    @Test
    void whenTokenIsPresent_allCoreBeansShouldBeCreated() {
        contextRunner
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop")
            .run(context -> {
                assertThat(context).hasSingleBean(Bot.class);
                assertThat(context).hasSingleBean(TelegramSession.class);
                assertThat(context).hasSingleBean(Dispatcher.class);
                assertThat(context).hasSingleBean(HandlerRegistry.class);
            });
    }

    @Test
    void whenTokenIsMissing_noCoreBeansShouldBeCreated() {
        contextRunner
            .run(context -> {
                assertThat(context).doesNotHaveBean(Bot.class);
                assertThat(context).doesNotHaveBean(Dispatcher.class);
            });
    }

    @Test
    void whenFsmEnabled_fsmBeansShouldBeCreated() {
        contextRunner
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop")
            .run(context -> {
                assertThat(context).hasSingleBean(StateStorage.class);
                assertThat(context).hasSingleBean(FSMMiddleware.class);
                assertThat(context).getBean(StateStorage.class)
                    .isInstanceOf(MemoryStateStorage.class);
            });
    }

    @Test
    void whenFsmDisabled_noFsmBeansShouldBeCreated() {
        contextRunner
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.fsm.enabled=false"
            )
            .run(context -> {
                assertThat(context).doesNotHaveBean(StateStorage.class);
                assertThat(context).doesNotHaveBean(FSMMiddleware.class);
            });
    }

    @Test
    void whenPollingMode_pollingRunnerShouldBeCreated() {
        contextRunner
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop")
            .run(context -> {
                assertThat(context).hasSingleBean(PollingRunner.class);
            });
    }

    @Test
    void whenWebhookMode_pollingRunnerShouldNotBeCreated() {
        new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                JiogramAutoConfiguration.class,
                PollingAutoConfiguration.class,
                WebhookAutoConfiguration.class
            ))
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.mode=webhook"
            )
            .run(context -> {
                assertThat(context).doesNotHaveBean(PollingRunner.class);
                assertThat(context).hasSingleBean(WebhookController.class);
            });
    }
}
