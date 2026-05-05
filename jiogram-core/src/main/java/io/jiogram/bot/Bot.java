package io.jiogram.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import reactor.core.publisher.Mono;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;

/**
 * Represents a Telegram bot with a token, session, and default properties.
 */
public class Bot {

    private final String token;
    private final long id;
    private final TelegramSession session;
    private final DefaultBotProperties defaults;

    public Bot(String token, TelegramSession session) {
        this(token, session, DefaultBotProperties.defaults());
    }

    public Bot(String token, TelegramSession session, DefaultBotProperties defaults) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Bot token must not be null or blank");
        }
        this.token = token;
        this.id = extractBotId(token);
        this.session = session;
        this.defaults = defaults;
    }

    /**
     * Executes a Telegram API method using this bot's session and token.
     *
     * @param method the API method to invoke
     * @param <T>    the expected return type
     * @return a Mono emitting the deserialized result
     */
    public <T> Mono<T> execute(TelegramMethod<T> method) {
        return session.makeRequest(token, applyDefaults(method));
    }

    public String token() {
        return token;
    }

    public long id() {
        return id;
    }

    public TelegramSession session() {
        return session;
    }

    public DefaultBotProperties defaults() {
        return defaults;
    }

    /**
     * Extracts the bot ID from a token in the format "123456789:ABCDEFghijklmnop".
     *
     * @param token the bot token
     * @return the numeric bot ID
     * @throws IllegalArgumentException if the token does not contain a colon or the prefix is not numeric
     */
    private static long extractBotId(String token) {
        int colonIndex = token.indexOf(':');
        if (colonIndex <= 0) {
            throw new IllegalArgumentException(
                "Invalid bot token format: expected 'id:hash' but no colon found"
            );
        }
        String idPart = token.substring(0, colonIndex);
        try {
            return Long.parseLong(idPart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "Invalid bot token format: prefix before colon is not a valid number", e
            );
        }
    }

    @SuppressWarnings("unchecked")
    private <T> TelegramMethod<T> applyDefaults(TelegramMethod<T> method) {
        if (defaults.parseMode() == null && !defaults.protectContent() && defaults.linkPreview()) {
            return method;
        }

        Class<?> methodType = method.getClass();
        if (!methodType.isRecord()) {
            return method;
        }

        try {
            RecordComponent[] components = methodType.getRecordComponents();
            Class<?>[] parameterTypes = new Class<?>[components.length];
            Object[] args = new Object[components.length];
            boolean changed = false;

            for (int i = 0; i < components.length; i++) {
                RecordComponent component = components[i];
                parameterTypes[i] = component.getType();
                Object value = component.getAccessor().invoke(method);

                JsonProperty jsonProperty = component.getAccessor().getAnnotation(JsonProperty.class);
                if (jsonProperty == null) {
                    jsonProperty = component.getAnnotation(JsonProperty.class);
                }
                if (jsonProperty == null) {
                    args[i] = value;
                    continue;
                }

                String propertyName = jsonProperty.value();
                if ("parse_mode".equals(propertyName)
                    && value == null
                    && defaults.parseMode() != null
                    && component.getType().isAssignableFrom(ParseMode.class)) {
                    value = defaults.parseMode();
                    changed = true;
                } else if ("protect_content".equals(propertyName)
                    && value == null
                    && defaults.protectContent()
                    && component.getType().isAssignableFrom(Boolean.class)) {
                    value = Boolean.TRUE;
                    changed = true;
                } else if ("link_preview_options".equals(propertyName)
                    && value == null
                    && !defaults.linkPreview()
                    && component.getType().isAssignableFrom(LinkPreviewOptions.class)) {
                    value = new LinkPreviewOptions(true, null, null, null, null);
                    changed = true;
                }

                args[i] = value;
            }

            if (!changed) {
                return method;
            }

            Constructor<?> constructor = methodType.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
            return (TelegramMethod<T>) constructor.newInstance(args);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(
                "Failed to apply default bot properties to " + method.getClass().getName(), e
            );
        }
    }
}
