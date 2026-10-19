package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.fsm.middleware.FSMMiddleware;
import io.jiogram.fsm.storage.MemoryStateStorage;
import io.jiogram.fsm.storage.StateStorage;
import io.jiogram.handler.HandlerRegistry;
import io.jiogram.methods.SetWebhook;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.TelegramMethod;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;

class JiogramAutoConfigurationTest {

    static class StubTelegramSession implements TelegramSession {
        TelegramMethod<?> lastMethod;

        @Override
        public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
            this.lastMethod = method;
            return Mono.empty();
        }

        @Override
        public Mono<Void> close() {
            return Mono.empty();
        }
    }

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
                "telegram.mode=webhook",
                "telegram.webhook.secret-token=configured_secret"
            )
            .run(context -> {
                assertThat(context).doesNotHaveBean(PollingRunner.class);
                assertThat(context).hasSingleBean(WebhookController.class);
                assertThat(context.getBean(WebhookAutoConfiguration.WebhookSecretToken.class).value())
                    .isEqualTo("configured_secret");
            });
    }

    @Test
    void whenWebhookModeHasNeitherUrlNorSecret_startupFails() {
        new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                JiogramAutoConfiguration.class,
                WebhookAutoConfiguration.class
            ))
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.mode=webhook"
            )
            .run(context -> assertThat(context).getFailure()
                .rootCause()
                .hasMessageContaining("telegram.webhook.secret-token"));
    }

    @Test
    void whenWebhookUrlIsSetWithoutSecret_generatedSecretIsRegisteredWithTelegram() {
        new ApplicationContextRunner()
            .withBean(TelegramSession.class, StubTelegramSession::new)
            .withConfiguration(AutoConfigurations.of(
                JiogramAutoConfiguration.class,
                WebhookAutoConfiguration.class
            ))
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.mode=webhook",
                "telegram.webhook.url=https://example.com/bot/webhook"
            )
            .run(context -> {
                String generated = context.getBean(WebhookAutoConfiguration.WebhookSecretToken.class).value();
                assertThat(generated).matches("[A-Za-z0-9_-]{43}");

                StubTelegramSession session = (StubTelegramSession) context.getBean(TelegramSession.class);
                assertThat(session.lastMethod).isInstanceOfSatisfying(SetWebhook.class,
                    setWebhook -> assertThat(setWebhook.secretToken()).isEqualTo(generated));
            });
    }

    @Test
    void applicationWebClientBean_isNotReplacedOrReused() {
        WebClient appClient = WebClient.create("http://my-other-service");
        contextRunner
            .withBean("appClient", WebClient.class, () -> appClient)
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop")
            .run(context -> {
                assertThat(context).hasSingleBean(WebClient.class);
                assertThat(context.getBean(WebClient.class)).isSameAs(appClient);
                assertThat(context).hasSingleBean(TelegramSession.class);
            });
    }

    @Test
    void whenWebhookUrlIsPresent_webhookRegistrarShouldBeCreated() {
        new ApplicationContextRunner()
            .withBean(TelegramSession.class, StubTelegramSession::new)
            .withConfiguration(AutoConfigurations.of(
                JiogramAutoConfiguration.class,
                WebhookAutoConfiguration.class
            ))
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.mode=webhook",
                "telegram.webhook.url=https://example.com/bot/webhook"
            )
            .run(context -> assertThat(context).hasSingleBean(WebhookRegistrar.class));
    }
}
