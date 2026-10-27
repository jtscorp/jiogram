package io.jiogram.session;

import io.micrometer.common.KeyValue;
import org.springframework.web.reactive.function.client.ClientRequestObservationContext;
import org.springframework.web.reactive.function.client.DefaultClientRequestObservationConvention;

import java.util.regex.Pattern;

/**
 * WebClient observation convention that keeps the bot token out of metrics and traces.
 * <p>
 * The Bot API puts the token in the request path ({@code /bot<token>/sendMessage}), and the
 * default convention copies the full URL into the {@code http.url} key value of every span.
 * This one replaces the token with {@code {token}} there and in the {@code uri} tag.
 * <p>
 * The Spring Boot starter sets it on the session's WebClient. A session built by hand gets it
 * the same way: {@code WebClient.builder().observationConvention(new TokenMaskingObservationConvention())}.
 */
public class TokenMaskingObservationConvention extends DefaultClientRequestObservationConvention {

    private static final Pattern TOKEN_IN_PATH = Pattern.compile("/bot\\d+:[^/]+/");
    private static final String MASKED = "/bot{token}/";

    public TokenMaskingObservationConvention() {
    }

    /**
     * @param name the observation name, which is also the metric name
     *             ({@code http.client.requests} by default)
     */
    public TokenMaskingObservationConvention(String name) {
        super(name);
    }

    @Override
    protected KeyValue uri(ClientRequestObservationContext context) {
        return mask(super.uri(context));
    }

    @Override
    protected KeyValue httpUrl(ClientRequestObservationContext context) {
        return mask(super.httpUrl(context));
    }

    private static KeyValue mask(KeyValue keyValue) {
        String masked = TOKEN_IN_PATH.matcher(keyValue.getValue()).replaceAll(MASKED);
        return KeyValue.of(keyValue.getKey(), masked);
    }
}
