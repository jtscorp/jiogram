package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryChatType;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an incoming inline query. When the user sends an empty query, your bot
 * could return some default or trending results.
 *
 * @see <a href="https://core.telegram.org/bots/api#inlinequery">InlineQuery in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class InlineQuery {

    @JsonProperty("id")
    private final String id;

    @JsonProperty("from")
    private final User from;

    @JsonProperty("query")
    private final String query;

    @JsonProperty("offset")
    private final String offset;

    @JsonProperty("chat_type")
    private final @Nullable InlineQueryChatType chatType;

    @JsonProperty("location")
    private final @Nullable Location location;

    /**
     * Creates a new {@code InlineQuery} instance.
     *
     * @param id Unique identifier for this query
     * @param from Sender
     * @param query Text of the query (up to 256 characters)
     * @param offset Offset of the results to be returned, can be controlled by the bot
     * @param chatType Type of the chat from which the inline query was sent. Can be either 'sender'
     *     for a private chat with the inline query sender, 'private', 'group', 'supergroup', or
     *     'channel'. The chat type should be always known for requests sent from official clients
     *     and most third-party clients, unless the request was sent from a secret chat
     * @param location Sender location, only for bots that request user location
     */
    @JsonCreator
    public InlineQuery(
            @JsonProperty("id") String id,
            @JsonProperty("from") User from,
            @JsonProperty("query") String query,
            @JsonProperty("offset") String offset,
            @JsonProperty("chat_type") @Nullable InlineQueryChatType chatType,
            @JsonProperty("location") @Nullable Location location) {
        this.id = id;
        this.from = from;
        this.query = query;
        this.offset = offset;
        this.chatType = chatType;
        this.location = location;
    }

    public static InlineQuery of(String id, User from, String query, String offset) {
        return new InlineQuery(id, from, query, offset, null, null);
    }

    /**
     * Unique identifier for this query
     */
    public String id() {
        return id;
    }

    /**
     * Sender
     */
    public User from() {
        return from;
    }

    /**
     * Text of the query (up to 256 characters)
     */
    public String query() {
        return query;
    }

    /**
     * Offset of the results to be returned, can be controlled by the bot
     */
    public String offset() {
        return offset;
    }

    /**
     * Type of the chat from which the inline query was sent. Can be either 'sender' for a private
     * chat with the inline query sender, 'private', 'group', 'supergroup', or 'channel'. The chat
     * type should be always known for requests sent from official clients and most third-party
     * clients, unless the request was sent from a secret chat
     */
    public @Nullable InlineQueryChatType chatType() {
        return chatType;
    }

    /**
     * Sender location, only for bots that request user location
     */
    public @Nullable Location location() {
        return location;
    }

    public InlineQuery withId(String id) {
        return new InlineQuery(id, from, query, offset, chatType, location);
    }

    public InlineQuery withFrom(User from) {
        return new InlineQuery(id, from, query, offset, chatType, location);
    }

    public InlineQuery withQuery(String query) {
        return new InlineQuery(id, from, query, offset, chatType, location);
    }

    public InlineQuery withOffset(String offset) {
        return new InlineQuery(id, from, query, offset, chatType, location);
    }

    public InlineQuery withChatType(@Nullable InlineQueryChatType chatType) {
        return new InlineQuery(id, from, query, offset, chatType, location);
    }

    public InlineQuery withLocation(@Nullable Location location) {
        return new InlineQuery(id, from, query, offset, chatType, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InlineQuery)) {
            return false;
        }
        InlineQuery that = (InlineQuery) o;
        return Objects.equals(this.id, that.id)
                && Objects.equals(this.from, that.from)
                && Objects.equals(this.query, that.query)
                && Objects.equals(this.offset, that.offset)
                && Objects.equals(this.chatType, that.chatType)
                && Objects.equals(this.location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.from, this.query, this.offset, this.chatType, this.location);
    }

    @Override
    public String toString() {
        return "InlineQuery[id=" + this.id
                + ", from=" + this.from
                + ", query=" + this.query
                + ", offset=" + this.offset
                + ", chatType=" + this.chatType
                + ", location=" + this.location
                + "]";
    }
}
