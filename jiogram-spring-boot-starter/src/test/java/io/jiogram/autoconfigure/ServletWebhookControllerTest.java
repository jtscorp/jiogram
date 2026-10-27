package io.jiogram.autoconfigure;

import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.Message;
import io.jiogram.types.TelegramMethod;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.unit.DataSize;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ServletWebhookControllerTest {

    private static final String SECRET = "s3cret_token-1";
    private static final String UPDATE_JSON = """
            {
              "update_id": 1,
              "message": {
                "message_id": 5,
                "from": {"id": 7000000000, "is_bot": false, "first_name": "Alice"},
                "chat": {"id": 7000000000, "type": "private"},
                "date": 1775538971,
                "text": "hello"
              }
            }
            """;

    private final AtomicReference<Message> received = new AtomicReference<>();

    @Test
    void validSecret_dispatchesRealTelegramUpdate() throws Exception {
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller(DataSize.ofMegabytes(1))).build();

        MvcResult result = mvc.perform(post("/bot/webhook")
                        .header("X-Telegram-Bot-Api-Secret-Token", SECRET)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(UPDATE_JSON))
                .andReturn();
        mvc.perform(asyncDispatch(result)).andExpect(status().isOk());

        assertThat(received.get()).isNotNull();
        assertThat(received.get().text()).isEqualTo("hello");
    }

    @Test
    void wrongSecret_isRejectedBeforeTheBodyIsRead() throws Exception {
        MockHttpServletRequest request = request("wrong", UPDATE_JSON);
        var notToBeRead = new HttpServletRequestWrapper(request) {
            @Override
            public ServletInputStream getInputStream() {
                throw new AssertionError("the body must not be read");
            }
        };

        assertThat(statusOf(controller(DataSize.ofMegabytes(1)).handleUpdate(notToBeRead)))
                .isEqualTo(HttpStatus.UNAUTHORIZED);
        assertThat(received.get()).isNull();
    }

    @Test
    void bodyLargerThanTheLimit_isRejectedWith413WithoutDispatching() throws Exception {
        assertThat(statusOf(controller(DataSize.ofBytes(100)).handleUpdate(request(SECRET, UPDATE_JSON))))
                .isEqualTo(HttpStatus.CONTENT_TOO_LARGE);
        assertThat(received.get()).isNull();
    }

    @Test
    void chunkedBodyLargerThanTheLimit_isRejectedWith413() throws Exception {
        // No Content-Length: the limit applies while the body is read.
        var chunked = new HttpServletRequestWrapper(request(SECRET, UPDATE_JSON)) {
            @Override
            public long getContentLengthLong() {
                return -1;
            }
        };

        assertThat(statusOf(controller(DataSize.ofBytes(100)).handleUpdate(chunked)))
                .isEqualTo(HttpStatus.CONTENT_TOO_LARGE);
        assertThat(received.get()).isNull();
    }

    @Test
    void bodyOfExactlyTheLimit_isDispatched() throws Exception {
        byte[] body = UPDATE_JSON.getBytes(StandardCharsets.UTF_8);

        assertThat(statusOf(controller(DataSize.ofBytes(body.length)).handleUpdate(request(SECRET, UPDATE_JSON))))
                .isEqualTo(HttpStatus.OK);
        assertThat(received.get()).isNotNull();
    }

    private ServletWebhookController controller(DataSize maxBodySize) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.onMessage().handle((message, context) -> Mono.fromRunnable(() -> received.set(message)));
        return new ServletWebhookController(bot(), dispatcher, SECRET, maxBodySize);
    }

    private static MockHttpServletRequest request(String secret, String body) {
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/bot/webhook");
        request.addHeader("X-Telegram-Bot-Api-Secret-Token", secret);
        request.setContentType(MediaType.APPLICATION_JSON_VALUE);
        request.setContent(body.getBytes(StandardCharsets.UTF_8));
        return request;
    }

    private static HttpStatus statusOf(Mono<ResponseEntity<Void>> response) {
        return HttpStatus.valueOf(response.block(Duration.ofSeconds(5)).getStatusCode().value());
    }

    private static Bot bot() {
        return new Bot("123:abc", new TelegramSession() {
            @Override
            public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
                return Mono.empty();
            }

            @Override
            public Mono<Void> close() {
                return Mono.empty();
            }
        });
    }
}
