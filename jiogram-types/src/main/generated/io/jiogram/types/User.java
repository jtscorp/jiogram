package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object represents a Telegram user or bot.
 *
 * @see <a href="https://core.telegram.org/bots/api#user">User in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class User {

    @JsonProperty("id")
    private final long id;

    @JsonProperty("is_bot")
    private final boolean isBot;

    @JsonProperty("first_name")
    private final String firstName;

    @JsonProperty("last_name")
    private final @Nullable String lastName;

    @JsonProperty("username")
    private final @Nullable String username;

    @JsonProperty("language_code")
    private final @Nullable String languageCode;

    @JsonProperty("is_premium")
    private final @Nullable Boolean isPremium;

    @JsonProperty("added_to_attachment_menu")
    private final @Nullable Boolean addedToAttachmentMenu;

    @JsonProperty("can_join_groups")
    private final @Nullable Boolean canJoinGroups;

    @JsonProperty("can_read_all_group_messages")
    private final @Nullable Boolean canReadAllGroupMessages;

    @JsonProperty("supports_inline_queries")
    private final @Nullable Boolean supportsInlineQueries;

    @JsonProperty("can_connect_to_business")
    private final @Nullable Boolean canConnectToBusiness;

    @JsonProperty("has_main_web_app")
    private final @Nullable Boolean hasMainWebApp;

    @JsonProperty("has_topics_enabled")
    private final @Nullable Boolean hasTopicsEnabled;

    @JsonProperty("allows_users_to_create_topics")
    private final @Nullable Boolean allowsUsersToCreateTopics;

    @JsonProperty("can_manage_bots")
    private final @Nullable Boolean canManageBots;

    /**
     * Creates a new {@code User} instance.
     *
     * @param id Unique identifier for this user or bot. This number may have more than 32
     *     significant bits and some programming languages may have difficulty/silent defects in
     *     interpreting it. But it has at most 52 significant bits, so a 64-bit integer or
     *     double-precision float type are safe for storing this identifier.
     * @param isBot True, if this user is a bot
     * @param firstName User's or bot's first name
     * @param lastName User's or bot's last name
     * @param username User's or bot's username
     * @param languageCode IETF language tag of the user's language
     * @param isPremium True, if this user is a Telegram Premium user
     * @param addedToAttachmentMenu True, if this user added the bot to the attachment menu
     * @param canJoinGroups True, if the bot can be invited to groups. Returned only in getMe.
     * @param canReadAllGroupMessages True, if privacy mode is disabled for the bot. Returned only
     *     in getMe.
     * @param supportsInlineQueries True, if the bot supports inline queries. Returned only in
     *     getMe.
     * @param canConnectToBusiness True, if the bot can be connected to a Telegram Business account
     *     to receive its messages. Returned only in getMe.
     * @param hasMainWebApp True, if the bot has a main Web App. Returned only in getMe.
     * @param hasTopicsEnabled True, if the bot has forum topic mode enabled in private chats.
     *     Returned only in getMe.
     * @param allowsUsersToCreateTopics True, if the bot allows users to create and delete topics in
     *     private chats. Returned only in getMe.
     * @param canManageBots True, if other bots can be created to be controlled by the bot. Returned
     *     only in getMe.
     */
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
            @JsonProperty("can_manage_bots") @Nullable Boolean canManageBots) {
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

    public static User of(long id, boolean isBot, String firstName) {
        return new User(id, isBot, firstName, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Unique identifier for this user or bot. This number may have more than 32 significant bits
     * and some programming languages may have difficulty/silent defects in interpreting it. But it
     * has at most 52 significant bits, so a 64-bit integer or double-precision float type are safe
     * for storing this identifier.
     */
    public long id() {
        return id;
    }

    /**
     * True, if this user is a bot
     */
    public boolean isBot() {
        return isBot;
    }

    /**
     * User's or bot's first name
     */
    public String firstName() {
        return firstName;
    }

    /**
     * User's or bot's last name
     */
    public @Nullable String lastName() {
        return lastName;
    }

    /**
     * User's or bot's username
     */
    public @Nullable String username() {
        return username;
    }

    /**
     * IETF language tag of the user's language
     */
    public @Nullable String languageCode() {
        return languageCode;
    }

    /**
     * True, if this user is a Telegram Premium user
     */
    public @Nullable Boolean isPremium() {
        return isPremium;
    }

    /**
     * True, if this user added the bot to the attachment menu
     */
    public @Nullable Boolean addedToAttachmentMenu() {
        return addedToAttachmentMenu;
    }

    /**
     * True, if the bot can be invited to groups. Returned only in getMe.
     */
    public @Nullable Boolean canJoinGroups() {
        return canJoinGroups;
    }

    /**
     * True, if privacy mode is disabled for the bot. Returned only in getMe.
     */
    public @Nullable Boolean canReadAllGroupMessages() {
        return canReadAllGroupMessages;
    }

    /**
     * True, if the bot supports inline queries. Returned only in getMe.
     */
    public @Nullable Boolean supportsInlineQueries() {
        return supportsInlineQueries;
    }

    /**
     * True, if the bot can be connected to a Telegram Business account to receive its messages.
     * Returned only in getMe.
     */
    public @Nullable Boolean canConnectToBusiness() {
        return canConnectToBusiness;
    }

    /**
     * True, if the bot has a main Web App. Returned only in getMe.
     */
    public @Nullable Boolean hasMainWebApp() {
        return hasMainWebApp;
    }

    /**
     * True, if the bot has forum topic mode enabled in private chats. Returned only in getMe.
     */
    public @Nullable Boolean hasTopicsEnabled() {
        return hasTopicsEnabled;
    }

    /**
     * True, if the bot allows users to create and delete topics in private chats. Returned only in
     * getMe.
     */
    public @Nullable Boolean allowsUsersToCreateTopics() {
        return allowsUsersToCreateTopics;
    }

    /**
     * True, if other bots can be created to be controlled by the bot. Returned only in getMe.
     */
    public @Nullable Boolean canManageBots() {
        return canManageBots;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User that = (User) o;
        return this.id == that.id
                && this.isBot == that.isBot
                && Objects.equals(this.firstName, that.firstName)
                && Objects.equals(this.lastName, that.lastName)
                && Objects.equals(this.username, that.username)
                && Objects.equals(this.languageCode, that.languageCode)
                && Objects.equals(this.isPremium, that.isPremium)
                && Objects.equals(this.addedToAttachmentMenu, that.addedToAttachmentMenu)
                && Objects.equals(this.canJoinGroups, that.canJoinGroups)
                && Objects.equals(this.canReadAllGroupMessages, that.canReadAllGroupMessages)
                && Objects.equals(this.supportsInlineQueries, that.supportsInlineQueries)
                && Objects.equals(this.canConnectToBusiness, that.canConnectToBusiness)
                && Objects.equals(this.hasMainWebApp, that.hasMainWebApp)
                && Objects.equals(this.hasTopicsEnabled, that.hasTopicsEnabled)
                && Objects.equals(this.allowsUsersToCreateTopics, that.allowsUsersToCreateTopics)
                && Objects.equals(this.canManageBots, that.canManageBots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.isBot, this.firstName, this.lastName, this.username, this.languageCode, this.isPremium, this.addedToAttachmentMenu, this.canJoinGroups, this.canReadAllGroupMessages, this.supportsInlineQueries, this.canConnectToBusiness, this.hasMainWebApp, this.hasTopicsEnabled, this.allowsUsersToCreateTopics, this.canManageBots);
    }

    @Override
    public String toString() {
        return "User[id=" + this.id
                + ", isBot=" + this.isBot
                + ", firstName=" + this.firstName
                + ", lastName=" + this.lastName
                + ", username=" + this.username
                + ", languageCode=" + this.languageCode
                + ", isPremium=" + this.isPremium
                + ", addedToAttachmentMenu=" + this.addedToAttachmentMenu
                + ", canJoinGroups=" + this.canJoinGroups
                + ", canReadAllGroupMessages=" + this.canReadAllGroupMessages
                + ", supportsInlineQueries=" + this.supportsInlineQueries
                + ", canConnectToBusiness=" + this.canConnectToBusiness
                + ", hasMainWebApp=" + this.hasMainWebApp
                + ", hasTopicsEnabled=" + this.hasTopicsEnabled
                + ", allowsUsersToCreateTopics=" + this.allowsUsersToCreateTopics
                + ", canManageBots=" + this.canManageBots
                + "]";
    }
}
