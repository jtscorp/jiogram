package io.jiogram.bot;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.session.TelegramSession;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.ParseMode;
import io.jiogram.types.TelegramMethod;
import reactor.core.publisher.Mono;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

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

        try {
            Constructor<?> constructor = findJsonConstructor(method.getClass());
            if (constructor == null) {
                return method;
            }

            Object[] args = new Object[constructor.getParameterCount()];
            boolean changed = false;

            Parameter[] parameters = constructor.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                JsonProperty jsonProperty = parameters[i].getAnnotation(JsonProperty.class);
                if (jsonProperty == null) {
                    return method;
                }

                String propertyName = jsonProperty.value();
                Field field = findJsonPropertyField(method.getClass(), propertyName);
                if (field == null) {
                    return method;
                }

                field.setAccessible(true);
                Object value = field.get(method);

                if ("parse_mode".equals(propertyName)
                    && value == null
                    && defaults.parseMode() != null
                    && parameters[i].getType().isAssignableFrom(ParseMode.class)) {
                    value = defaults.parseMode();
                    changed = true;
                } else if ("protect_content".equals(propertyName)
                    && value == null
                    && defaults.protectContent()
                    && parameters[i].getType().isAssignableFrom(Boolean.class)) {
                    value = Boolean.TRUE;
                    changed = true;
                } else if ("link_preview_options".equals(propertyName)
                    && value == null
                    && !defaults.linkPreview()
                    && parameters[i].getType().isAssignableFrom(LinkPreviewOptions.class)) {
                    value = new LinkPreviewOptions(true, null, null, null, null);
                    changed = true;
                }

                args[i] = value;
            }

            if (!changed) {
                return method;
            }

            constructor.setAccessible(true);
            return (TelegramMethod<T>) constructor.newInstance(args);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException(
                "Failed to apply default bot properties to " + method.getClass().getName(), e
            );
        }
    }

    private static Constructor<?> findJsonConstructor(Class<?> type) {
        for (Constructor<?> constructor : type.getDeclaredConstructors()) {
            if (constructor.getAnnotation(com.fasterxml.jackson.annotation.JsonCreator.class) != null) {
                return constructor;
            }
        }
        return null;
    }

    private static Field findJsonPropertyField(Class<?> type, String propertyName) {
        for (Field field : type.getDeclaredFields()) {
            JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
            if (jsonProperty != null && propertyName.equals(jsonProperty.value())) {
                return field;
            }
        }
        return null;
    }
}
