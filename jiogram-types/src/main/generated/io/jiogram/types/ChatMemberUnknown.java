package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * A {@link ChatMember} variant unknown to this library version.
 * Holds the raw {@code status} value and all other fields as they were received.
 */
@JsonSerialize(using = UnknownVariant.Serializer.class)
public final class ChatMemberUnknown implements ChatMember, UnknownVariant {

    private final @Nullable String status;
    private final Map<String, Object> data;

    /**
     * Creates a new {@code ChatMemberUnknown} instance.
     *
     * @param status the raw discriminator value, or null if missing
     * @param data all other fields; copied, null means none
     */
    public ChatMemberUnknown(@Nullable String status, @Nullable Map<String, Object> data) {
        this.status = status;
        this.data = data == null ? new LinkedHashMap<>() : new LinkedHashMap<>(data);
    }

    /** Used by Jackson, which then adds the other fields with {@code addField}. */
    @JsonCreator
    private ChatMemberUnknown(@JsonProperty("status") @Nullable String status) {
        this(status, null);
    }

    @JsonAnySetter
    private void addField(String name, Object value) {
        data.put(name, value);
    }

    /**
     * Returns the raw {@code status} value, or null if it was missing.
     */
    public @Nullable String status() {
        return status;
    }

    @Override
    public Map<String, Object> data() {
        return Collections.unmodifiableMap(data);
    }

    @Override
    public String discriminatorName() {
        return "status";
    }

    @Override
    public @Nullable String discriminatorValue() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChatMemberUnknown)) {
            return false;
        }
        ChatMemberUnknown that = (ChatMemberUnknown) o;
        return Objects.equals(this.status, that.status)
                && this.data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.data);
    }

    @Override
    public String toString() {
        return "ChatMemberUnknown[status=" + this.status + ", data=" + this.data + "]";
    }
}
