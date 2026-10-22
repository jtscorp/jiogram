package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineQueryChatType;
import io.jiogram.types.Location;
import io.jiogram.types.User;
import org.jspecify.annotations.Nullable;

/**
 * This object represents an incoming inline query. When the user sends an empty query, your bot
 * could return some default or trending results.
 *
 * @param id Unique identifier for this query
 * @param from Sender
 * @param query Text of the query (up to 256 characters)
 * @param offset Offset of the results to be returned, can be controlled by the bot
 * @param chatType Type of the chat from which the inline query was sent. Can be either 'sender' for
 *     a private chat with the inline query sender, 'private', 'group', 'supergroup', or 'channel'.
 *     The chat type should be always known for requests sent from official clients and most
 *     third-party clients, unless the request was sent from a secret chat
 * @param location Sender location, only for bots that request user location
 * @see <a href="https://core.telegram.org/bots/api#inlinequery">InlineQuery in the Bot API</a>
 */
public record InlineQuery(
    @JsonProperty("id") String id,
    @JsonProperty("from") User from,
    @JsonProperty("query") String query,
    @JsonProperty("offset") String offset,
    @JsonProperty("chat_type") @Nullable InlineQueryChatType chatType,
    @JsonProperty("location") @Nullable Location location
) {

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
}
