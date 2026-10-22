package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * This object contains information about one member of a chat. Currently, the following 6 types of
 * chat members are supported:
 * <br>- ChatMemberOwner
 * <br>- ChatMemberAdministrator
 * <br>- ChatMemberMember
 * <br>- ChatMemberRestricted
 * <br>- ChatMemberLeft
 * <br>- ChatMemberBanned
 *
 * @see <a href="https://core.telegram.org/bots/api#chatmember">ChatMember in the Bot API</a>
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "status", visible = true, defaultImpl = ChatMemberUnknown.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChatMemberAdministrator.class, name = "administrator"),
    @JsonSubTypes.Type(value = ChatMemberOwner.class, name = "creator"),
    @JsonSubTypes.Type(value = ChatMemberBanned.class, name = "kicked"),
    @JsonSubTypes.Type(value = ChatMemberLeft.class, name = "left"),
    @JsonSubTypes.Type(value = ChatMemberMember.class, name = "member"),
    @JsonSubTypes.Type(value = ChatMemberRestricted.class, name = "restricted")
})
public interface ChatMember {}
