package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

public class User {
    @JsonProperty("id") private final long id;
    @JsonProperty("is_bot") private final boolean isBot;
    @JsonProperty("first_name") private final String firstName;
    @JsonProperty("last_name") @Nullable private final String lastName;
    @JsonProperty("username") @Nullable private final String username;
    @JsonProperty("language_code") @Nullable private final String languageCode;
    @JsonProperty("is_premium") @Nullable private final Boolean isPremium;
    @JsonProperty("added_to_attachment_menu") @Nullable private final Boolean addedToAttachmentMenu;
    @JsonProperty("can_join_groups") @Nullable private final Boolean canJoinGroups;
    @JsonProperty("can_read_all_group_messages") @Nullable private final Boolean canReadAllGroupMessages;
    @JsonProperty("supports_inline_queries") @Nullable private final Boolean supportsInlineQueries;
    @JsonProperty("can_connect_to_business") @Nullable private final Boolean canConnectToBusiness;
    @JsonProperty("has_main_web_app") @Nullable private final Boolean hasMainWebApp;
    @JsonProperty("has_topics_enabled") @Nullable private final Boolean hasTopicsEnabled;
    @JsonProperty("allows_users_to_create_topics") @Nullable private final Boolean allowsUsersToCreateTopics;
    @JsonProperty("can_manage_bots") @Nullable private final Boolean canManageBots;

    @JsonCreator
    public User(
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
    ) {
        this.id = id;
        this.isBot = isBot;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.languageCode = languageCode;
        this.isPremium = isPremium;
        this.addedToAttachmentMenu = addedToAttachmentMenu;
        this.canJoinGroups = canJoinGroups;
        this.canReadAllGroupMessages = canReadAllGroupMessages;
        this.supportsInlineQueries = supportsInlineQueries;
        this.canConnectToBusiness = canConnectToBusiness;
        this.hasMainWebApp = hasMainWebApp;
        this.hasTopicsEnabled = hasTopicsEnabled;
        this.allowsUsersToCreateTopics = allowsUsersToCreateTopics;
        this.canManageBots = canManageBots;
    }

    public long id() {
        return this.id;
    }

    public boolean isBot() {
        return this.isBot;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public String username() {
        return this.username;
    }

    public String languageCode() {
        return this.languageCode;
    }

    public Boolean isPremium() {
        return this.isPremium;
    }

    public Boolean addedToAttachmentMenu() {
        return this.addedToAttachmentMenu;
    }

    public Boolean canJoinGroups() {
        return this.canJoinGroups;
    }

    public Boolean canReadAllGroupMessages() {
        return this.canReadAllGroupMessages;
    }

    public Boolean supportsInlineQueries() {
        return this.supportsInlineQueries;
    }

    public Boolean canConnectToBusiness() {
        return this.canConnectToBusiness;
    }

    public Boolean hasMainWebApp() {
        return this.hasMainWebApp;
    }

    public Boolean hasTopicsEnabled() {
        return this.hasTopicsEnabled;
    }

    public Boolean allowsUsersToCreateTopics() {
        return this.allowsUsersToCreateTopics;
    }

    public Boolean canManageBots() {
        return this.canManageBots;
    }
}
