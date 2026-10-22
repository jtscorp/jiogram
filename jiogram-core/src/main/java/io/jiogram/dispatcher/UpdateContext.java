package io.jiogram.dispatcher;

import io.jiogram.bot.Bot;
import io.jiogram.types.Update;
import org.jspecify.annotations.Nullable;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Holds the bot, update, and arbitrary key-value data for the duration of a single update processing cycle.
 */
public class UpdateContext {

    private final Bot bot;
    private final Update update;
    private final ConcurrentHashMap<String, Object> data;

    public UpdateContext(Bot bot, Update update) {
        this.bot = bot;
        this.update = update;
        this.data = new ConcurrentHashMap<>();
    }

    public Bot bot() {
        return bot;
    }

    public Update update() {
        return update;
    }

    /**
     * Stores a value in the context data map. A {@code null} value removes the key, so
     * {@link #get(String)} returns null for it either way.
     */
    public void put(String key, @Nullable Object value) {
        if (value == null) {
            data.remove(key);
        } else {
            data.put(key, value);
        }
    }

    /**
     * Retrieves a value from the context data map, or null if not present.
     */
    public Object get(String key) {
        return data.get(key);
    }

    /**
     * Retrieves a value from the context data map, casting it to the specified type.
     *
     * @throws ClassCastException if the value is not of the expected type
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key, Class<T> type) {
        Object value = data.get(key);
        if (value == null) {
            return null;
        }
        return type.cast(value);
    }

    /**
     * Returns an unmodifiable view of the context data map.
     */
    public Map<String, Object> data() {
        return Collections.unmodifiableMap(data);
    }

    /**
     * Merges the given map into the context data, with the same null handling as {@link #put}.
     */
    public void merge(@Nullable Map<String, Object> other) {
        if (other != null) {
            other.forEach(this::put);
        }
    }
}
