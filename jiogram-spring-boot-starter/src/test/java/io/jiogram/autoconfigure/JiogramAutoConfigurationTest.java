package io.jiogram.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.fsm.FSMStrategy;
import io.jiogram.fsm.middleware.FSMMiddleware;
import io.jiogram.fsm.storage.MemoryStateStorage;
import io.jiogram.fsm.storage.StateStorage;
import io.jiogram.handler.HandlerRegistry;
import io.jiogram.methods.GetUpdates;
import io.jiogram.methods.SetWebhook;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import io.jiogram.types.UpdateType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.core.io.buffer.DataBufferLimitException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        new ReactiveWebApplicationContextRunner()
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
        new ReactiveWebApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                JiogramAutoConfiguration.class,
                WebhookAutoConfiguration.class
            ))
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.mode=webhook"
            )
            .run(context -> assertThat(context).getFailure()
                .getRootCause()
                .hasMessageContaining("telegram.webhook.secret-token"));
    }

    @Test
    void whenWebhookUrlIsSetWithoutSecret_generatedSecretIsRegisteredWithTelegram() {
        new ReactiveWebApplicationContextRunner()
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
    void propertiesToString_masksTokenAndWebhookSecret() {
        contextRunner
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.webhook.secret-token=very_secret")
            .run(context -> {
                String text = context.getBean(JiogramProperties.class).toString();
                assertThat(text).doesNotContain("ABCDEFghijklmnop").doesNotContain("very_secret");
                assertThat(text).contains("token=****").contains("secretToken=****");
            });
    }

    /**
     * The properties are constructor-bound classes on this branch (records on sb3); every nested
     * group must still be created with its defaults when none of its keys is set.
     */
    @Test
    void properties_withOnlyTheToken_getEveryDefault() {
        contextRunner
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop")
            .run(context -> {
                JiogramProperties properties = context.getBean(JiogramProperties.class);
                assertThat(properties.mode()).isEqualTo(JiogramProperties.Mode.POLLING);

                JiogramProperties.PollingProperties polling = properties.polling();
                assertThat(polling.timeout()).isEqualTo(30);
                assertThat(polling.backoff()).isEqualTo(1000L);
                assertThat(polling.limit()).isEqualTo(100);
                assertThat(polling.allowedUpdates()).isNull();
                assertThat(polling.concurrency()).isEqualTo(32);
                assertThat(polling.shutdownTimeout()).isEqualTo(Duration.ofSeconds(10));

                JiogramProperties.WebhookProperties webhook = properties.webhook();
                assertThat(webhook.url()).isNull();
                assertThat(webhook.path()).isEqualTo("/bot/webhook");
                assertThat(webhook.secretToken()).isNull();
                assertThat(webhook.maxConnections()).isEqualTo(40);

                assertThat(properties.api().baseUrl()).isEqualTo("https://api.telegram.org");
                assertThat(properties.api().requestTimeout()).isEqualTo(Duration.ofSeconds(60));

                assertThat(properties.defaults().parseMode()).isNull();
                assertThat(properties.defaults().protectContent()).isFalse();
                assertThat(properties.defaults().linkPreview()).isTrue();

                JiogramProperties.FsmProperties fsm = properties.fsm();
                assertThat(fsm.enabled()).isTrue();
                assertThat(fsm.strategy()).isEqualTo(FSMStrategy.USER_IN_CHAT);
                assertThat(fsm.storage()).isEqualTo("memory");
                assertThat(fsm.redis().keyPrefix()).isEqualTo("jiogram:fsm");
                assertThat(fsm.redis().stateTtl()).isNull();
                assertThat(fsm.redis().dataTtl()).isNull();

                assertThat(properties.handlers().virtualThreads()).isTrue();
            });
    }

    @Test
    void properties_bindNestedGroupsFromKebabCaseKeys() {
        contextRunner
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.polling.concurrency=4",
                "telegram.polling.shutdown-timeout=2s",
                "telegram.polling.allowed-updates=MESSAGE,CALLBACK_QUERY",
                "telegram.api.request-timeout=5s",
                "telegram.fsm.strategy=CHAT",
                "telegram.fsm.redis.state-ttl=1h",
                "telegram.handlers.virtual-threads=false")
            .run(context -> {
                JiogramProperties properties = context.getBean(JiogramProperties.class);
                assertThat(properties.polling().concurrency()).isEqualTo(4);
                assertThat(properties.polling().timeout()).isEqualTo(30);
                assertThat(properties.polling().shutdownTimeout()).isEqualTo(Duration.ofSeconds(2));
                assertThat(properties.polling().allowedUpdates())
                    .containsExactly(UpdateType.MESSAGE, UpdateType.CALLBACK_QUERY);
                assertThat(properties.api().requestTimeout()).isEqualTo(Duration.ofSeconds(5));
                assertThat(properties.api().baseUrl()).isEqualTo("https://api.telegram.org");
                assertThat(properties.fsm().strategy()).isEqualTo(FSMStrategy.CHAT);
                assertThat(properties.fsm().redis().stateTtl()).isEqualTo(Duration.ofHours(1));
                assertThat(properties.fsm().redis().keyPrefix()).isEqualTo("jiogram:fsm");
                assertThat(properties.handlers().virtualThreads()).isFalse();
            });
    }

    @TelegramController
    static class PingController {
        @OnMessage
        public void onMessage(Message message) {
        }
    }

    @Test
    void telegramControllerHandlers_areRegisteredWhenContextStarts() {
        contextRunner
            .withBean(PingController.class)
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop")
            .run(context -> assertThat(context.getBean(Dispatcher.class).messageObserver().hasHandlers()).isTrue());
    }

    @Test
    @ExtendWith(OutputCaptureExtension.class)
    void handlerRegistry_doesNotCreateOtherBeansBeforeAllPostProcessorsAreRegistered(CapturedOutput output) {
        contextRunner
            .withBean(PingController.class)
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop")
            .run(context -> {
                assertThat(context).hasNotFailed();
                assertThat(context.getBean(Dispatcher.class).messageObserver().hasHandlers()).isTrue();
            });
        assertThat(output).doesNotContain("is not eligible for getting processed by all BeanPostProcessors");
    }

    @TelegramController
    static class ThreadRecordingController {
        volatile Boolean ranOnHandlerScheduler;

        @OnMessage
        public void onMessage(Message message) {
            ranOnHandlerScheduler = onHandlerScheduler(Thread.currentThread());
        }
    }

    /**
     * Whether the thread belongs to the blocking handler scheduler: a virtual thread on Java 21+,
     * the "jiogram-handler" bounded elastic pool on Java 11 to 20 (which this branch supports).
     */
    private static boolean onHandlerScheduler(Thread thread) {
        try {
            return (Boolean) Thread.class.getMethod("isVirtual").invoke(thread);
        } catch (NoSuchMethodException e) {
            return thread.getName().startsWith("jiogram-handler");
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(e);
        }
    }


    @ParameterizedTest
    @CsvSource({"true, true", "false, false", ", true"})
    void handlerVirtualThreadsProperty_choosesTheHandlerThread(String property, boolean expectVirtual) {
        ApplicationContextRunner runner = contextRunner
            .withBean(ThreadRecordingController.class)
            .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop");
        if (property != null) {
            runner = runner.withPropertyValues("telegram.handlers.virtual-threads=" + property);
        }
        runner.run(context -> {
            Update update = new ObjectMapper().readValue(
                "{\"update_id\": 1, \"message\": {\"message_id\": 1, \"date\": 1, "
                    + "\"chat\": {\"id\": 5, \"type\": \"private\"}, \"text\": \"hi\"}}\n",
                Update.class);
            context.getBean(Dispatcher.class).feedUpdate(context.getBean(Bot.class), update).block();
            assertThat(context.getBean(ThreadRecordingController.class).ranOnHandlerScheduler).isEqualTo(expectVirtual);
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
    void whenWebhookModeRunsWithoutAWebServer_startupFailsWithAHint() {
        new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(
                JiogramAutoConfiguration.class,
                WebhookAutoConfiguration.class
            ))
            .withPropertyValues(
                "telegram.token=123456789:ABCDEFghijklmnop",
                "telegram.mode=webhook",
                "telegram.webhook.secret-token=configured_secret"
            )
            .run(context -> assertThat(context).getFailure()
                .getRootCause()
                .hasMessageContaining("spring-boot-starter-webflux"));
    }

    @Test
    void whenWebhookUrlIsPresent_webhookRegistrarShouldBeCreated() {
        new ReactiveWebApplicationContextRunner()
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

    /** A getUpdates answer of about 300 KB, more than WebClient's default limit of 256 KB. */
    private static final String LARGE_RESPONSE = "{\"ok\": true, \"result\": []" + " ".repeat(300_000) + "}";

    private final ApplicationContextRunner sessionRunner = new ApplicationContextRunner()
        .withConfiguration(AutoConfigurations.of(JiogramAutoConfiguration.class))
        .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop");

    @Test
    void responseLargerThanWebClientsDefaultLimit_isRead() {
        DisposableServer server = botApiRespondingWith(LARGE_RESPONSE);
        try {
            sessionRunner
                .withPropertyValues("telegram.api.base-url=http://localhost:" + server.port())
                .run(context -> assertThat(context.getBean(Bot.class)
                    .execute(new GetUpdates(null, 100L, 0L, null)).block(Duration.ofSeconds(10)))
                    .isEqualTo(List.of()));
        } finally {
            server.disposeNow();
        }
    }

    @Test
    void responseLargerThanMaxResponseSize_fails() {
        DisposableServer server = botApiRespondingWith(LARGE_RESPONSE);
        try {
            sessionRunner
                .withPropertyValues(
                    "telegram.api.base-url=http://localhost:" + server.port(),
                    "telegram.api.max-response-size=100KB")
                .run(context -> assertThatThrownBy(() -> context.getBean(Bot.class)
                    .execute(new GetUpdates(null, 100L, 0L, null)).block(Duration.ofSeconds(10)))
                    .isInstanceOf(DataBufferLimitException.class));
        } finally {
            server.disposeNow();
        }
    }

    @Test
    void apiPropertiesCreatedWithThe020Constructor_getTheDefaultMaxResponseSize() {
        JiogramProperties.ApiProperties api =
            new JiogramProperties.ApiProperties("https://api.telegram.org", Duration.ofSeconds(60));

        assertThat(api.maxResponseSize()).isEqualTo(JiogramProperties.ApiProperties.DEFAULT_MAX_RESPONSE_SIZE);
    }

    private static DisposableServer botApiRespondingWith(String body) {
        return HttpServer.create()
            .port(0)
            .handle((request, response) -> request.receive().then(
                response.header("Content-Type", "application/json").sendString(Mono.just(body)).then()))
            .bindNow();
    }
}
