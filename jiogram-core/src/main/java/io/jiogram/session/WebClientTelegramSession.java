package io.jiogram.session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jiogram.types.TelegramMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * {@link TelegramSession} implementation that uses Spring's {@link WebClient}
 * to make HTTP requests to the Telegram Bot API.
 */
public class WebClientTelegramSession implements TelegramSession {

    private static final String BASE_URL = "https://api.telegram.org";

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    public WebClientTelegramSession(WebClient webClient) {
        this(webClient, new ObjectMapper());
    }

    public WebClientTelegramSession(WebClient webClient, ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
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
            .retrieve()
            .bodyToMono(String.class)
            .flatMap(responseBody -> {
                try {
                    TelegramApiResponse<T> response = objectMapper.readValue(responseBody, responseType);
                    if (response.ok()) {
                        return Mono.justOrEmpty(response.result());
                    } else {
                        int errorCode = response.errorCode() != null ? response.errorCode() : -1;
                        String description = response.description() != null
                            ? response.description()
                            : "Unknown error";
                        return Mono.error(new TelegramApiException(errorCode, description));
                    }
                } catch (JsonProcessingException e) {
                    return Mono.error(e);
                }
            });
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
