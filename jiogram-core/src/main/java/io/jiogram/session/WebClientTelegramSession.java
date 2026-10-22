package io.jiogram.session;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.methods.GetUpdates;
import io.jiogram.types.InputFile;
import io.jiogram.types.TelegramMethod;
import org.jspecify.annotations.Nullable;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.Duration;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/**
 * {@link TelegramSession} implementation that uses Spring's {@link WebClient}
 * to make HTTP requests to the Telegram Bot API.
 */
public class WebClientTelegramSession implements TelegramSession {

    public static final String DEFAULT_BASE_URL = "https://api.telegram.org";

    /** Same default as aiogram's session timeout. */
    public static final Duration DEFAULT_REQUEST_TIMEOUT = Duration.ofSeconds(60);

    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final String baseUrl;
    private final Duration requestTimeout;

    public WebClientTelegramSession(WebClient webClient) {
        this(webClient, defaultObjectMapper(), DEFAULT_BASE_URL);
    }

    public WebClientTelegramSession(WebClient webClient, String baseUrl) {
        this(webClient, defaultObjectMapper(), baseUrl);
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
        this(webClient, objectMapper, DEFAULT_BASE_URL);
    }

    public WebClientTelegramSession(WebClient webClient, ObjectMapper objectMapper, String baseUrl) {
        this(webClient, objectMapper, baseUrl, DEFAULT_REQUEST_TIMEOUT);
    }

    /**
     * @param requestTimeout how long to wait for a response before failing the request with a
     *                       {@link TimeoutException}; {@code getUpdates} gets its long-polling
     *                       timeout on top
     */
    public WebClientTelegramSession(WebClient webClient, ObjectMapper objectMapper, String baseUrl,
                                    Duration requestTimeout) {
        this.webClient = Objects.requireNonNull(webClient, "webClient must not be null");
        this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper must not be null");
        this.baseUrl = normalizeBaseUrl(baseUrl);
        this.requestTimeout = Objects.requireNonNull(requestTimeout, "requestTimeout must not be null");
        if (requestTimeout.isNegative() || requestTimeout.isZero()) {
            throw new IllegalArgumentException("requestTimeout must be positive, got " + requestTimeout);
        }
    }

    /**
     * Returns a fresh {@link ObjectMapper} configured for the Telegram Bot API:
     * null-valued properties are omitted from request bodies, and unknown response
     * properties are tolerated for forward compatibility with new API fields.
     */
    public static ObjectMapper defaultObjectMapper() {
        return new ObjectMapper()
            // Same as the deprecated setSerializationInclusion(NON_NULL): only null property
            // values are skipped; nulls inside maps and collections are kept.
            .setDefaultPropertyInclusion(
                JsonInclude.Value.construct(JsonInclude.Include.NON_NULL, JsonInclude.Include.USE_DEFAULTS))
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public <T> Mono<T> makeRequest(String token, TelegramMethod<T> method) {
        String url = baseUrl + "/bot" + token + "/" + method.apiMethod();

        JavaType resultType = resolveResultType(method);
        Duration timeout = timeoutFor(method);
        // The result is bound in a second step, see readResult().
        JavaType responseType = objectMapper.getTypeFactory()
            .constructParametricType(TelegramApiResponse.class, JsonNode.class);

        // InputFile values serialize as "attach://<name>" and register themselves here;
        // when any were found the request goes out as multipart instead of JSON.
        InputFile.Attachments attachments = new InputFile.Attachments();
        WebClient.RequestHeadersSpec<?> request;
        try {
            byte[] json = objectMapper.writer()
                .withAttribute(InputFile.Attachments.ATTRIBUTE, attachments)
                .writeValueAsBytes(method);
            WebClient.RequestBodySpec post = webClient.post().uri(url);
            request = attachments.isEmpty()
                ? post.contentType(MediaType.APPLICATION_JSON).bodyValue(json)
                : post.contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData(multipartBody(json, attachments)));
        } catch (IOException e) {
            return Mono.error(e);
        }

        return request
            .<T>exchangeToMono(clientResponse -> clientResponse.bodyToMono(String.class)
                .defaultIfEmpty("")
                .flatMap(responseBody -> {
                    TelegramApiResponse<JsonNode> response;
                    try {
                        response = objectMapper.readValue(responseBody, responseType);
                    } catch (JsonProcessingException e) {
                        // Body is not a valid Telegram API response — surface raw HTTP status + body
                        int rawStatus = clientResponse.rawStatusCode();
                        String snippet = responseBody.isEmpty() ? "<empty body>" : responseBody;
                        return Mono.error(new TelegramApiException(
                            rawStatus,
                            "Unparseable Telegram API response (HTTP " + rawStatus + "): " + snippet
                        ));
                    }
                    if (response.ok()) {
                        return readResult(response.result(), resultType);
                    }
                    int errorCode = response.errorCode() != null ? response.errorCode() : -1;
                    String description = response.description() != null
                        ? response.description()
                        : "Unknown error";
                    return Mono.error(new TelegramApiException(errorCode, description));
                }))
            .timeout(timeout, Mono.error(() -> new TimeoutException(
                "No response from the Telegram Bot API to " + method.apiMethod() + " within " + timeout)));
    }

    /** A long poll is answered only after its own timeout, so that is added to the request timeout. */
    private Duration timeoutFor(TelegramMethod<?> method) {
        if (method instanceof GetUpdates) {
            Long longPollTimeout = ((GetUpdates) method).timeout();
            if (longPollTimeout != null) {
                return requestTimeout.plusSeconds(longPollTimeout);
            }
        }
        return requestTimeout;
    }

    /**
     * Binds a successful result to the method's return type. Methods documented as returning
     * "Message or True" (editMessageText, editMessageCaption, stopMessageLiveLocation, setGameScore,
     * ...) return {@code true} instead of the message when they target an inline message; that
     * completes the Mono empty rather than failing to bind {@code true} to a Message.
     */
    private <T> Mono<T> readResult(@Nullable JsonNode result, JavaType resultType) {
        if (result == null || result.isNull()) {
            return Mono.empty();
        }
        if (result.isBoolean() && resultType.getRawClass() != Boolean.class) {
            return Mono.empty();
        }
        try {
            // Assigned first: passed inline, readValue's type would be inferred as Optional.
            T value = objectMapper.readerFor(resultType).readValue(result);
            return Mono.justOrEmpty(value);
        } catch (IOException e) {
            return Mono.error(new TelegramApiException(-1,
                "Cannot read Telegram API result as " + resultType.toCanonical() + ": " + e.getMessage()));
        }
    }

    /**
     * Turns the serialized request into form fields (scalars as-is, objects and arrays as
     * JSON text, as the Bot API expects) plus one part per attached file.
     */
    private MultiValueMap<String, HttpEntity<?>> multipartBody(byte[] json, InputFile.Attachments attachments)
            throws IOException {
        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        Iterator<Map.Entry<String, JsonNode>> fields = objectMapper.readTree(json).fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            JsonNode value = field.getValue();
            builder.part(field.getKey(), value.isValueNode() ? value.asText() : value.toString());
        }
        for (Map.Entry<String, InputFile> file : attachments.files().entrySet()) {
            Resource content = file.getValue() instanceof InputFile.FromPath
                ? new FileSystemResource(((InputFile.FromPath) file.getValue()).path())
                : new ByteArrayResource(((InputFile.FromBytes) file.getValue()).content());
            builder.part(file.getKey(), content, MediaType.APPLICATION_OCTET_STREAM)
                .filename(file.getValue().filename());
        }
        return builder.build();
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
            if (iface instanceof ParameterizedType
                && ((ParameterizedType) iface).getRawType() == TelegramMethod.class) {
                Type actualType = ((ParameterizedType) iface).getActualTypeArguments()[0];
                return objectMapper.getTypeFactory().constructType(actualType);
            }
        }
        // Fallback: should not happen for properly implemented methods
        throw new IllegalArgumentException(
            "Cannot resolve return type for method: " + method.getClass().getName()
        );
    }

    private static String normalizeBaseUrl(String baseUrl) {
        if (baseUrl == null || baseUrl.isBlank()) {
            return DEFAULT_BASE_URL;
        }
        String trimmed = baseUrl.trim();
        while (trimmed.endsWith("/")) {
            trimmed = trimmed.substring(0, trimmed.length() - 1);
        }
        return trimmed;
    }
}
