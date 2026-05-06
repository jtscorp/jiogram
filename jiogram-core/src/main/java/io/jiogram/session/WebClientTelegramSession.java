package io.jiogram.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.types.TelegramMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * {@link TelegramSession} implementation that uses Spring's {@link WebClient}
 * to make HTTP requests to the Telegram Bot API.
 */
public class WebClientTelegramSession implements TelegramSession {

    private static final String BASE_URL = "https://api.telegram.org";

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public WebClientTelegramSession(WebClient webClient) {
        WebClient checkedWebClient = Objects.requireNonNull(webClient, "webClient must not be null");
        this(checkedWebClient, defaultObjectMapper());
    }

    /**
     * Constructs a session with a caller-supplied {@link ObjectMapper}.
     *
     * <p><strong>Important:</strong> the supplied mapper MUST be configured with
     * {@link JsonInclude.Include#NON_NULL} serialization inclusion. The Telegram Bot
     * API rejects optional parameters that are explicitly set to JSON {@code null}
     * (e.g. it returns {@code "Bad Request: object expected as link preview options"}
     * when {@code link_preview_options: null} is sent). Prefer the single-argument
     * constructor or {@link #defaultObjectMapper()} unless you need custom modules.
     */
    public WebClientTelegramSession(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = Objects.requireNonNull(webClient, "webClient must not be null");
        this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper must not be null");
    }

    /**
     * Returns a fresh {@link ObjectMapper} configured for the Telegram Bot API:
     * null-valued properties are omitted from request bodies, and unknown response
     * properties are tolerated for forward compatibility with new API fields.
     */
    public static ObjectMapper defaultObjectMapper() {
        return new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
        String url = BASE_URL + "/bot" + token + "/" + method.apiMethod();

        JavaType resultType = resolveResultType(method);
        JavaType responseType = objectMapper.getTypeFactory()
            .constructParametricType(TelegramApiResponse.class, resultType);

        byte[] body;
        try {
            body = objectMapper.writeValueAsBytes(method);
        } catch (JsonProcessingException e) {
            return Mono.error(e);
        }

        return webClient.post()
            .uri(url)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(responseBody -> {
                    TelegramApiResponse<T> response;
                    try {
                        response = objectMapper.readValue(responseBody, responseType);
                    } catch (JsonProcessingException e) {
                        // Body is not a valid Telegram API response — surface raw HTTP status + body
                        int rawStatus = clientResponse.statusCode().value();
                        String snippet = responseBody.isEmpty() ? "<empty body>" : responseBody;
                        return Mono.error(new TelegramApiException(
                            rawStatus,
                            "Unparseable Telegram API response (HTTP " + rawStatus + "): " + snippet
                        ));
                    }
                    if (response.ok()) {
                        return Mono.justOrEmpty(response.result());
                    }
                    int errorCode = response.errorCode() != null ? response.errorCode() : -1;
                    String description = response.description() != null
                        ? response.description()
                        : "Unknown error";
                    return Mono.error(new TelegramApiException(errorCode, description));
                }));
    }

    @Override
    public Mono<Void> close() {
        return Mono.empty();
    }

    /**
     * Resolves the concrete type parameter T from a TelegramMethod implementation.
     * For example, if the method is {@code SendGame implements TelegramMethod<Message>},
     * this returns the JavaType for {@code Message}.
     */
    private <T> JavaType resolveResultType(TelegramMethod<T> method) {
        for (Type iface : method.getClass().getGenericInterfaces()) {
            if (iface instanceof ParameterizedType pt
                && pt.getRawType() == TelegramMethod.class) {
                Type actualType = pt.getActualTypeArguments()[0];
                return objectMapper.getTypeFactory().constructType(actualType);
            }
        }
        // Fallback: should not happen for properly implemented methods
        throw new IllegalArgumentException(
            "Cannot resolve return type for method: " + method.getClass().getName()
        );
    }
}
