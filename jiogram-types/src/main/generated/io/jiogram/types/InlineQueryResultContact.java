package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.InlineKeyboardMarkup;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputMessageContent;
import org.jspecify.annotations.Nullable;

public class InlineQueryResultContact implements InlineQueryResult {
    @JsonProperty("type") private final InlineQueryResultType type;
    @JsonProperty("id") private final String id;
    @JsonProperty("phone_number") private final String phoneNumber;
    @JsonProperty("first_name") private final String firstName;
    @JsonProperty("last_name") @Nullable private final String lastName;
    @JsonProperty("vcard") @Nullable private final String vcard;
    @JsonProperty("reply_markup") @Nullable private final InlineKeyboardMarkup replyMarkup;
    @JsonProperty("input_message_content") @Nullable private final InputMessageContent inputMessageContent;
    @JsonProperty("thumbnail_url") @Nullable private final String thumbnailUrl;
    @JsonProperty("thumbnail_width") @Nullable private final Long thumbnailWidth;
    @JsonProperty("thumbnail_height") @Nullable private final Long thumbnailHeight;

    @JsonCreator
    public InlineQueryResultContact(
            @JsonProperty("type") InlineQueryResultType type,
            @JsonProperty("id") String id,
            @JsonProperty("phone_number") String phoneNumber,
            @JsonProperty("first_name") String firstName,
            @JsonProperty("last_name") @Nullable String lastName,
            @JsonProperty("vcard") @Nullable String vcard,
            @JsonProperty("reply_markup") @Nullable InlineKeyboardMarkup replyMarkup,
            @JsonProperty("input_message_content") @Nullable InputMessageContent inputMessageContent,
            @JsonProperty("thumbnail_url") @Nullable String thumbnailUrl,
            @JsonProperty("thumbnail_width") @Nullable Long thumbnailWidth,
            @JsonProperty("thumbnail_height") @Nullable Long thumbnailHeight
    ) {
        this.type = type;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vcard = vcard;
        this.replyMarkup = replyMarkup;
        this.inputMessageContent = inputMessageContent;
        this.thumbnailUrl = thumbnailUrl;
        this.thumbnailWidth = thumbnailWidth;
        this.thumbnailHeight = thumbnailHeight;
    }

    public InlineQueryResultType type() {
        return this.type;
    }

    public String id() {
        return this.id;
    }

    public String phoneNumber() {
        return this.phoneNumber;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public String vcard() {
        return this.vcard;
    }

    public InlineKeyboardMarkup replyMarkup() {
        return this.replyMarkup;
    }

    public InputMessageContent inputMessageContent() {
        return this.inputMessageContent;
    }

    public String thumbnailUrl() {
        return this.thumbnailUrl;
    }

    public Long thumbnailWidth() {
        return this.thumbnailWidth;
    }

    public Long thumbnailHeight() {
        return this.thumbnailHeight;
    }
}
