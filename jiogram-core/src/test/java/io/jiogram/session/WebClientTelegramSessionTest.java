package io.jiogram.session;

import com.fasterxml.jackson.databind.JsonMappingException;
import io.jiogram.methods.EditMessageText;
import io.jiogram.methods.GetMe;
import io.jiogram.methods.GetUpdates;
import io.jiogram.methods.SendMediaGroup;
import io.jiogram.methods.SendPhoto;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFile;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMedia;
import io.jiogram.types.InputMediaPhoto;
import io.jiogram.types.Message;
import io.jiogram.types.Update;
import io.jiogram.types.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;
import reactor.test.StepVerifier;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Sends real HTTP requests to a local server standing in for the Bot API and checks the
 * wire format: JSON without files, {@code multipart/form-data} with {@code attach://} parts
 * when an {@link InputFile} is present anywhere in the request.
 */
class WebClientTelegramSessionTest {

    private static final String TOKEN = "123:abc";
    private static final String MESSAGE_JSON = """
            {"message_id": 1, "chat": {"id": 42, "type": "private"}, "date": 1775538971}""";

    private final AtomicReference<String> contentType = new AtomicReference<>();
    private final AtomicReference<String> body = new AtomicReference<>();
    private DisposableServer server;

    @AfterEach
    void stopServer() {
        if (server != null) {
            server.disposeNow();
        }
    }

    @Test
    void requestWithoutFiles_isSentAsJson() {
        WebClientTelegramSession session = sessionRespondingWith("""
                {"id": 123, "is_bot": true, "first_name": "Bot"}""");

        User me = session.makeRequest(TOKEN, new GetMe()).block(Duration.ofSeconds(10));

        assertEquals(123L, me.id());
        assertTrue(contentType.get().startsWith("application/json"), contentType.get());
    }

    @Test
    void topLevelUpload_isSentAsMultipartWithAttachReference() {
        WebClientTelegramSession session = sessionRespondingWith(MESSAGE_JSON);
        byte[] photo = "fake-jpeg-bytes".getBytes(StandardCharsets.UTF_8);

        Message sent = session.makeRequest(TOKEN, SendPhoto.of(ChatId.of(42),
                InputFileOrString.of(InputFile.fromBytes("cat.jpg", photo)))).block(Duration.ofSeconds(10));

        assertEquals(1L, sent.messageId());
        assertTrue(contentType.get().startsWith("multipart/form-data"), contentType.get());
        String sentBody = body.get();
        assertPart(sentBody, "chat_id", "42");
        assertPart(sentBody, "photo", "attach://file0");
        assertTrue(sentBody.contains("name=\"file0\"; filename=\"cat.jpg\""), sentBody);
        assertTrue(sentBody.contains("fake-jpeg-bytes"), sentBody);
    }

    @Test
    void nestedUploadInMediaGroup_isAttachedNextToFileIds(@TempDir Path dir) throws Exception {
        WebClientTelegramSession session = sessionRespondingWith("[" + MESSAGE_JSON + "]");
        Path file = Files.writeString(dir.resolve("dog.png"), "fake-png-bytes");
        List<InputMedia> media = List.of(
                new InputMediaPhoto(null, InputFileOrString.of(InputFile.fromPath(file)), "local", null, null, null, null),
                new InputMediaPhoto(null, InputFileOrString.of("AgADBAAD"), "remote", null, null, null, null));

        List<Message> sent = session.makeRequest(TOKEN, SendMediaGroup.of(ChatId.of(42), media))
                .block(Duration.ofSeconds(10));

        assertEquals(1, sent.size());
        String sentBody = body.get();
        assertTrue(sentBody.contains("{\"type\":\"photo\",\"media\":\"attach://file0\",\"caption\":\"local\"}"), sentBody);
        assertTrue(sentBody.contains("{\"type\":\"photo\",\"media\":\"AgADBAAD\",\"caption\":\"remote\"}"), sentBody);
        assertTrue(sentBody.contains("name=\"file0\"; filename=\"dog.png\""), sentBody);
        assertTrue(sentBody.contains("fake-png-bytes"), sentBody);
    }

    @Test
    void messageOrTrueMethod_onInlineMessage_completesEmpty() {
        WebClientTelegramSession session = sessionRespondingWith("true");

        StepVerifier.create(session.makeRequest(TOKEN, EditMessageText.of("edited")))
                .expectComplete()
                .verify(Duration.ofSeconds(10));
    }

    @Test
    void messageOrTrueMethod_onRegularMessage_returnsTheMessage() {
        WebClientTelegramSession session = sessionRespondingWith(MESSAGE_JSON);

        Message edited = session.makeRequest(TOKEN, EditMessageText.of("edited")).block(Duration.ofSeconds(10));

        assertEquals(1L, edited.messageId());
    }

    @Test
    void requestWithoutAResponseInTime_failsWithATimeout() {
        String baseUrl = serverRespondingWith("{\"id\": 123, \"is_bot\": true, \"first_name\": \"Bot\"}",
                Duration.ofSeconds(3));
        var session = new WebClientTelegramSession(WebClient.create(),
                WebClientTelegramSession.defaultObjectMapper(), baseUrl, Duration.ofMillis(300));

        StepVerifier.create(session.makeRequest(TOKEN, new GetMe()))
                .expectErrorSatisfies(error -> {
                    assertInstanceOf(TimeoutException.class, error);
                    assertTrue(error.getMessage().contains("getMe"), error.getMessage());
                })
                .verify(Duration.ofSeconds(10));
    }

    @Test
    void longPoll_getsItsPollingTimeoutOnTopOfTheRequestTimeout() {
        // Answered after 1.2s: later than the 300ms request timeout, within 300ms + the 2s long poll.
        String baseUrl = serverRespondingWith("[]", Duration.ofMillis(1200));
        var session = new WebClientTelegramSession(WebClient.create(),
                WebClientTelegramSession.defaultObjectMapper(), baseUrl, Duration.ofMillis(300));

        List<Update> updates = session.makeRequest(TOKEN, new GetUpdates(null, null, 2L, null))
                .block(Duration.ofSeconds(10));

        assertEquals(List.of(), updates);
    }

    @Test
    void nonPositiveRequestTimeout_isRejected() {
        assertThrows(IllegalArgumentException.class, () -> new WebClientTelegramSession(WebClient.create(),
                WebClientTelegramSession.defaultObjectMapper(), null, Duration.ZERO));
    }

    @Test
    void inputFile_cannotBeSerializedOutsideASession() {
        var upload = SendPhoto.of(ChatId.of(42), InputFileOrString.of(InputFile.fromBytes("a.jpg", new byte[1])));

        assertThrows(JsonMappingException.class,
                () -> WebClientTelegramSession.defaultObjectMapper().writeValueAsString(upload));
    }

    private WebClientTelegramSession sessionRespondingWith(String resultJson) {
        return new WebClientTelegramSession(WebClient.create(), serverRespondingWith(resultJson, Duration.ZERO));
    }

    /** Starts the stand-in Bot API server and returns its base URL. */
    private String serverRespondingWith(String resultJson, Duration delay) {
        server = HttpServer.create()
                .port(0)
                .handle((request, response) -> request.receive().aggregate().asString(StandardCharsets.UTF_8)
                        .defaultIfEmpty("")
                        .delayElement(delay)
                        .flatMap(received -> {
                            contentType.set(request.requestHeaders().get("Content-Type"));
                            body.set(received);
                            return response.header("Content-Type", "application/json")
                                    .sendString(Mono.just("{\"ok\": true, \"result\": " + resultJson + "}"))
                                    .then();
                        }))
                .bindNow();
        return "http://localhost:" + server.port();
    }

    private static void assertPart(String multipartBody, String name, String value) {
        String header = "name=\"" + name + "\"";
        int at = multipartBody.indexOf(header);
        assertTrue(at >= 0, "missing part " + name + " in:\n" + multipartBody);
        String afterHeaders = multipartBody.substring(multipartBody.indexOf("\r\n\r\n", at) + 4);
        assertEquals(value, afterHeaders.substring(0, afterHeaders.indexOf("\r\n")));
    }
}
