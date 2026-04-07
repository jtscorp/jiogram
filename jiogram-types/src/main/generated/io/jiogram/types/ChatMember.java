package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "status")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ChatMemberAdministrator.class, name = "administrator"),
    @JsonSubTypes.Type(value = ChatMemberOwner.class, name = "creator"),
    @JsonSubTypes.Type(value = ChatMemberBanned.class, name = "kicked"),
    @JsonSubTypes.Type(value = ChatMemberLeft.class, name = "left"),
    @JsonSubTypes.Type(value = ChatMemberMember.class, name = "member"),
    @JsonSubTypes.Type(value = ChatMemberRestricted.class, name = "restricted")
})
public sealed interface ChatMember permits ChatMemberAdministrator, ChatMemberOwner, ChatMemberBanned, ChatMemberLeft, ChatMemberMember, ChatMemberRestricted {}
