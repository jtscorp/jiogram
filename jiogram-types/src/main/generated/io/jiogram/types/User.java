package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a Telegram user or bot.
 *
 * @param id Unique identifier for this user or bot. This number may have more than 32 significant
 *     bits and some programming languages may have difficulty/silent defects in interpreting it.
 *     But it has at most 52 significant bits, so a 64-bit integer or double-precision float type
 *     are safe for storing this identifier.
 * @param isBot True, if this user is a bot
 * @param firstName User's or bot's first name
 * @param lastName User's or bot's last name
 * @param username User's or bot's username
 * @param languageCode IETF language tag of the user's language
 * @param isPremium True, if this user is a Telegram Premium user
 * @param addedToAttachmentMenu True, if this user added the bot to the attachment menu
 * @param canJoinGroups True, if the bot can be invited to groups. Returned only in getMe.
 * @param canReadAllGroupMessages True, if privacy mode is disabled for the bot. Returned only in
 *     getMe.
 * @param supportsInlineQueries True, if the bot supports inline queries. Returned only in getMe.
 * @param canConnectToBusiness True, if the bot can be connected to a Telegram Business account to
 *     receive its messages. Returned only in getMe.
 * @param hasMainWebApp True, if the bot has a main Web App. Returned only in getMe.
 * @param hasTopicsEnabled True, if the bot has forum topic mode enabled in private chats. Returned
 *     only in getMe.
 * @param allowsUsersToCreateTopics True, if the bot allows users to create and delete topics in
 *     private chats. Returned only in getMe.
 * @param canManageBots True, if other bots can be created to be controlled by the bot. Returned
 *     only in getMe.
 * @see <a href="https://core.telegram.org/bots/api#user">User in the Bot API</a>
 */
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
) {

    public static User of(long id, boolean isBot, String firstName) {
        return new User(id, isBot, firstName, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public User withId(long id) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withIsBot(boolean isBot) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withFirstName(String firstName) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withLastName(@Nullable String lastName) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withUsername(@Nullable String username) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withLanguageCode(@Nullable String languageCode) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withIsPremium(@Nullable Boolean isPremium) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withAddedToAttachmentMenu(@Nullable Boolean addedToAttachmentMenu) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withCanJoinGroups(@Nullable Boolean canJoinGroups) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withCanReadAllGroupMessages(@Nullable Boolean canReadAllGroupMessages) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withSupportsInlineQueries(@Nullable Boolean supportsInlineQueries) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withCanConnectToBusiness(@Nullable Boolean canConnectToBusiness) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withHasMainWebApp(@Nullable Boolean hasMainWebApp) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withHasTopicsEnabled(@Nullable Boolean hasTopicsEnabled) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withAllowsUsersToCreateTopics(@Nullable Boolean allowsUsersToCreateTopics) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }

    public User withCanManageBots(@Nullable Boolean canManageBots) {
        return new User(id, isBot, firstName, lastName, username, languageCode, isPremium, addedToAttachmentMenu, canJoinGroups, canReadAllGroupMessages, supportsInlineQueries, canConnectToBusiness, hasMainWebApp, hasTopicsEnabled, allowsUsersToCreateTopics, canManageBots);
    }
}
