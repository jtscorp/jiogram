package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public record User(
    @JsonProperty("id") long id,
    @JsonProperty("is_bot") boolean isBot,
    @JsonProperty("first_name") String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("language_code") @Nullable String languageCode,
    @JsonProperty("is_premium") @Nullable Boolean isPremium,
    @JsonProperty("added_to_attachment_menu") @Nullable Boolean addedToAttachmentMenu,
    @JsonProperty("can_join_groups") @Nullable Boolean canJoinGroups,
    @JsonProperty("can_read_all_group_messages") @Nullable Boolean canReadAllGroupMessages,
    @JsonProperty("supports_inline_queries") @Nullable Boolean supportsInlineQueries,
    @JsonProperty("can_connect_to_business") @Nullable Boolean canConnectToBusiness,
    @JsonProperty("has_main_web_app") @Nullable Boolean hasMainWebApp,
    @JsonProperty("has_topics_enabled") @Nullable Boolean hasTopicsEnabled,
    @JsonProperty("allows_users_to_create_topics") @Nullable Boolean allowsUsersToCreateTopics,
    @JsonProperty("can_manage_bots") @Nullable Boolean canManageBots
) {}
