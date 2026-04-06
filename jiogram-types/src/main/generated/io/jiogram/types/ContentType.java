package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ContentType {
    TEXT("text"),
    ANIMATION("animation"),
    AUDIO("audio"),
    DOCUMENT("document"),
    PHOTO("photo"),
    STICKER("sticker"),
    STORY("story"),
    VIDEO("video"),
    VIDEO_NOTE("video_note"),
    VOICE("voice"),
    CONTACT("contact"),
    DICE("dice"),
    GAME("game"),
    POLL("poll"),
    VENUE("venue"),
    LOCATION("location"),
    INVOICE("invoice"),
    SUCCESSFUL_PAYMENT("successful_payment"),
    NEW_CHAT_MEMBERS("new_chat_members"),
    LEFT_CHAT_MEMBER("left_chat_member"),
    NEW_CHAT_TITLE("new_chat_title"),
    NEW_CHAT_PHOTO("new_chat_photo"),
    DELETE_CHAT_PHOTO("delete_chat_photo"),
    GROUP_CHAT_CREATED("group_chat_created"),
    SUPERGROUP_CHAT_CREATED("supergroup_chat_created"),
    CHANNEL_CHAT_CREATED("channel_chat_created"),
    PINNED_MESSAGE("pinned_message"),
    WEB_APP_DATA("web_app_data");

    private final String value;

    ContentType(String value) {
        this.value = value;
    }

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static ContentType fromValue(String value) {
        for (ContentType e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown ContentType: " + value);
    }
}
