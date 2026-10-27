package io.jiogram.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.fsm.middleware.FSMMiddleware;
import io.jiogram.fsm.storage.MemoryStateStorage;
import io.jiogram.fsm.storage.StateStorage;
import io.jiogram.handler.HandlerRegistry;
import io.jiogram.methods.GetMe;
import io.jiogram.methods.SetWebhook;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import io.jiogram.types.Update;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import io.micrometer.observation.ObservationRegistry;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.web.reactive.function.client.ClientRequestObservationContext;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

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
                .rootCause()
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
     * the "jiogram-handler" bounded elastic pool on Java 17 (which this branch also supports).
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
            Update update = new ObjectMapper().readValue("""
                {"update_id": 1, "message": {"message_id": 1, "date": 1, "chat": {"id": 5, "type": "private"}, "text": "hi"}}
                """, Update.class);
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
                .rootCause()
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

    private final ApplicationContextRunner sessionRunner = new ApplicationContextRunner()
        .withConfiguration(AutoConfigurations.of(JiogramAutoConfiguration.class))
        .withPropertyValues("telegram.token=123456789:ABCDEFghijklmnop");

    @Test
    void observedClientRequests_doNotContainTheToken() {
        DisposableServer server = botApiRespondingWith("""
            {"ok": true, "result": {"id": 123456789, "is_bot": true, "first_name": "Bot"}}""");
        AtomicReference<ClientRequestObservationContext> observed = new AtomicReference<>();
        ObservationRegistry registry = ObservationRegistry.create();
        registry.observationConfig().observationHandler(new ObservationHandler<>() {
            @Override
            public boolean supportsContext(Observation.Context context) {
                return context instanceof ClientRequestObservationContext;
            }

            @Override
            public void onStop(Observation.Context context) {
                observed.set((ClientRequestObservationContext) context);
            }
        });
        try {
            sessionRunner
                // Stands in for Boot's builder, which carries the registry when actuator is present.
                .withBean(WebClient.Builder.class, () -> WebClient.builder().observationRegistry(registry))
                .withPropertyValues(
                    "telegram.api.base-url=http://localhost:" + server.port(),
                    "management.observations.http.client.requests.name=telegram.client.requests")
                .run(context -> {
                    context.getBean(Bot.class).execute(new GetMe()).block(Duration.ofSeconds(10));

                    ClientRequestObservationContext request = observed.get();
                    assertThat(request.getName()).isEqualTo("telegram.client.requests");
                    assertThat(request.getLowCardinalityKeyValue("uri").getValue()).isEqualTo("/bot{token}/getMe");
                    assertThat(request.getHighCardinalityKeyValue("http.url").getValue())
                        .isEqualTo("http://localhost:" + server.port() + "/bot{token}/getMe");
                });
        } finally {
            server.disposeNow();
        }
    }

    private static DisposableServer botApiRespondingWith(String body) {
        return HttpServer.create()
            .port(0)
            .handle((request, response) -> request.receive().then(
                response.header("Content-Type", "application/json").sendString(Mono.just(body)).then()))
            .bindNow();
    }
}
