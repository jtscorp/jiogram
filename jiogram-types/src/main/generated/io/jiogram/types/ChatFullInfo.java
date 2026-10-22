package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.AcceptedGiftTypes;
import io.jiogram.types.Audio;
import io.jiogram.types.Birthdate;
import io.jiogram.types.BusinessIntro;
import io.jiogram.types.BusinessLocation;
import io.jiogram.types.BusinessOpeningHours;
import io.jiogram.types.Chat;
import io.jiogram.types.ChatLocation;
import io.jiogram.types.ChatPermissions;
import io.jiogram.types.ChatPhoto;
import io.jiogram.types.ChatType;
import io.jiogram.types.Message;
import io.jiogram.types.ReactionType;
import io.jiogram.types.UniqueGiftColors;
import io.jiogram.types.UserRating;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * This object contains full information about a chat.
 *
 * @param id Unique identifier for this chat. This number may have more than 32 significant bits and
 *     some programming languages may have difficulty/silent defects in interpreting it. But it has
 *     at most 52 significant bits, so a signed 64-bit integer or double-precision float type are
 *     safe for storing this identifier.
 * @param type Type of the chat, can be either 'private', 'group', 'supergroup' or 'channel'
 * @param title Title, for supergroups, channels and group chats
 * @param username Username, for private chats, supergroups and channels if available
 * @param firstName First name of the other party in a private chat
 * @param lastName Last name of the other party in a private chat
 * @param isForum True, if the supergroup chat is a forum (has topics enabled)
 * @param isDirectMessages True, if the chat is the direct messages chat of a channel
 * @param accentColorId Identifier of the accent color for the chat name and backgrounds of the chat
 *     photo, reply header, and link preview. See accent colors for more details.
 * @param maxReactionCount The maximum number of reactions that can be set on a message in the chat
 * @param photo Chat photo
 * @param activeUsernames If non-empty, the list of all active chat usernames; for private chats,
 *     supergroups and channels
 * @param birthdate For private chats, the date of birth of the user
 * @param businessIntro For private chats with business accounts, the intro of the business
 * @param businessLocation For private chats with business accounts, the location of the business
 * @param businessOpeningHours For private chats with business accounts, the opening hours of the
 *     business
 * @param personalChat For private chats, the personal channel of the user
 * @param parentChat Information about the corresponding channel chat; for direct messages chats
 *     only
 * @param availableReactions List of available reactions allowed in the chat. If omitted, then all
 *     emoji reactions are allowed.
 * @param backgroundCustomEmojiId Custom emoji identifier of the emoji chosen by the chat for the
 *     reply header and link preview background
 * @param profileAccentColorId Identifier of the accent color for the chat's profile background. See
 *     profile accent colors for more details.
 * @param profileBackgroundCustomEmojiId Custom emoji identifier of the emoji chosen by the chat for
 *     its profile background
 * @param emojiStatusCustomEmojiId Custom emoji identifier of the emoji status of the chat or the
 *     other party in a private chat
 * @param emojiStatusExpirationDate Expiration date of the emoji status of the chat or the other
 *     party in a private chat, in Unix time, if any
 * @param bio Bio of the other party in a private chat
 * @param hasPrivateForwards True, if privacy settings of the other party in the private chat allows
 *     to use tg://user?id=&lt;user_id&gt; links only in chats with the user
 * @param hasRestrictedVoiceAndVideoMessages True, if the privacy settings of the other party
 *     restrict sending voice and video note messages in the private chat
 * @param joinToSendMessages True, if users need to join the supergroup before they can send
 *     messages
 * @param joinByRequest True, if all users directly joining the supergroup without using an invite
 *     link need to be approved by supergroup administrators
 * @param description Description, for groups, supergroups and channel chats
 * @param inviteLink Primary invite link, for groups, supergroups and channel chats
 * @param pinnedMessage The most recent pinned message (by sending date)
 * @param permissions Default chat member permissions, for groups and supergroups
 * @param acceptedGiftTypes Information about types of gifts that are accepted by the chat or by the
 *     corresponding user for private chats
 * @param canSendPaidMedia True, if paid media messages can be sent or forwarded to the channel
 *     chat. The field is available only for channel chats.
 * @param slowModeDelay For supergroups, the minimum allowed delay between consecutive messages sent
 *     by each unprivileged user; in seconds
 * @param unrestrictBoostCount For supergroups, the minimum number of boosts that a
 *     non-administrator user needs to add in order to ignore slow mode and chat permissions
 * @param messageAutoDeleteTime The time after which all messages sent to the chat will be
 *     automatically deleted; in seconds
 * @param hasAggressiveAntiSpamEnabled True, if aggressive anti-spam checks are enabled in the
 *     supergroup. The field is only available to chat administrators.
 * @param hasHiddenMembers True, if non-administrators can only get the list of bots and
 *     administrators in the chat
 * @param hasProtectedContent True, if messages from the chat can't be forwarded to other chats
 * @param hasVisibleHistory True, if new chat members will have access to old messages; available
 *     only to chat administrators
 * @param stickerSetName For supergroups, name of the group sticker set
 * @param canSetStickerSet True, if the bot can change the group sticker set
 * @param customEmojiStickerSetName For supergroups, the name of the group's custom emoji sticker
 *     set. Custom emoji from this set can be used by all users and bots in the group.
 * @param linkedChatId Unique identifier for the linked chat, i.e. the discussion group identifier
 *     for a channel and vice versa; for supergroups and channel chats. This identifier may be
 *     greater than 32 bits and some programming languages may have difficulty/silent defects in
 *     interpreting it. But it is smaller than 52 bits, so a signed 64 bit integer or
 *     double-precision float type are safe for storing this identifier.
 * @param location For supergroups, the location to which the supergroup is connected
 * @param rating For private chats, the rating of the user if any
 * @param firstProfileAudio For private chats, the first audio added to the profile of the user
 * @param uniqueGiftColors The color scheme based on a unique gift that must be used for the chat's
 *     name, message replies and link previews
 * @param paidMessageStarCount The number of Telegram Stars a general user have to pay to send a
 *     message to the chat
 * @see <a href="https://core.telegram.org/bots/api#chatfullinfo">ChatFullInfo in the Bot API</a>
 */
public record ChatFullInfo(
    @JsonProperty("id") long id,
    @JsonProperty("type") ChatType type,
    @JsonProperty("title") @Nullable String title,
    @JsonProperty("username") @Nullable String username,
    @JsonProperty("first_name") @Nullable String firstName,
    @JsonProperty("last_name") @Nullable String lastName,
    @JsonProperty("is_forum") @Nullable Boolean isForum,
    @JsonProperty("is_direct_messages") @Nullable Boolean isDirectMessages,
    @JsonProperty("accent_color_id") long accentColorId,
    @JsonProperty("max_reaction_count") long maxReactionCount,
    @JsonProperty("photo") @Nullable ChatPhoto photo,
    @JsonProperty("active_usernames") @Nullable List<String> activeUsernames,
    @JsonProperty("birthdate") @Nullable Birthdate birthdate,
    @JsonProperty("business_intro") @Nullable BusinessIntro businessIntro,
    @JsonProperty("business_location") @Nullable BusinessLocation businessLocation,
    @JsonProperty("business_opening_hours") @Nullable BusinessOpeningHours businessOpeningHours,
    @JsonProperty("personal_chat") @Nullable Chat personalChat,
    @JsonProperty("parent_chat") @Nullable Chat parentChat,
    @JsonProperty("available_reactions") @Nullable List<ReactionType> availableReactions,
    @JsonProperty("background_custom_emoji_id") @Nullable String backgroundCustomEmojiId,
    @JsonProperty("profile_accent_color_id") @Nullable Long profileAccentColorId,
    @JsonProperty("profile_background_custom_emoji_id") @Nullable String profileBackgroundCustomEmojiId,
    @JsonProperty("emoji_status_custom_emoji_id") @Nullable String emojiStatusCustomEmojiId,
    @JsonProperty("emoji_status_expiration_date") @Nullable Long emojiStatusExpirationDate,
    @JsonProperty("bio") @Nullable String bio,
    @JsonProperty("has_private_forwards") @Nullable Boolean hasPrivateForwards,
    @JsonProperty("has_restricted_voice_and_video_messages") @Nullable Boolean hasRestrictedVoiceAndVideoMessages,
    @JsonProperty("join_to_send_messages") @Nullable Boolean joinToSendMessages,
    @JsonProperty("join_by_request") @Nullable Boolean joinByRequest,
    @JsonProperty("description") @Nullable String description,
    @JsonProperty("invite_link") @Nullable String inviteLink,
    @JsonProperty("pinned_message") @Nullable Message pinnedMessage,
    @JsonProperty("permissions") @Nullable ChatPermissions permissions,
    @JsonProperty("accepted_gift_types") AcceptedGiftTypes acceptedGiftTypes,
    @JsonProperty("can_send_paid_media") @Nullable Boolean canSendPaidMedia,
    @JsonProperty("slow_mode_delay") @Nullable Long slowModeDelay,
    @JsonProperty("unrestrict_boost_count") @Nullable Long unrestrictBoostCount,
    @JsonProperty("message_auto_delete_time") @Nullable Long messageAutoDeleteTime,
    @JsonProperty("has_aggressive_anti_spam_enabled") @Nullable Boolean hasAggressiveAntiSpamEnabled,
    @JsonProperty("has_hidden_members") @Nullable Boolean hasHiddenMembers,
    @JsonProperty("has_protected_content") @Nullable Boolean hasProtectedContent,
    @JsonProperty("has_visible_history") @Nullable Boolean hasVisibleHistory,
    @JsonProperty("sticker_set_name") @Nullable String stickerSetName,
    @JsonProperty("can_set_sticker_set") @Nullable Boolean canSetStickerSet,
    @JsonProperty("custom_emoji_sticker_set_name") @Nullable String customEmojiStickerSetName,
    @JsonProperty("linked_chat_id") @Nullable Long linkedChatId,
    @JsonProperty("location") @Nullable ChatLocation location,
    @JsonProperty("rating") @Nullable UserRating rating,
    @JsonProperty("first_profile_audio") @Nullable Audio firstProfileAudio,
    @JsonProperty("unique_gift_colors") @Nullable UniqueGiftColors uniqueGiftColors,
    @JsonProperty("paid_message_star_count") @Nullable Long paidMessageStarCount
) {

    public ChatFullInfo withId(long id) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withType(ChatType type) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withTitle(@Nullable String title) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withUsername(@Nullable String username) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withFirstName(@Nullable String firstName) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withLastName(@Nullable String lastName) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withIsForum(@Nullable Boolean isForum) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withIsDirectMessages(@Nullable Boolean isDirectMessages) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withAccentColorId(long accentColorId) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withMaxReactionCount(long maxReactionCount) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withPhoto(@Nullable ChatPhoto photo) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withActiveUsernames(@Nullable List<String> activeUsernames) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withBirthdate(@Nullable Birthdate birthdate) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withBusinessIntro(@Nullable BusinessIntro businessIntro) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withBusinessLocation(@Nullable BusinessLocation businessLocation) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withBusinessOpeningHours(@Nullable BusinessOpeningHours businessOpeningHours) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withPersonalChat(@Nullable Chat personalChat) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withParentChat(@Nullable Chat parentChat) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withAvailableReactions(@Nullable List<ReactionType> availableReactions) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withBackgroundCustomEmojiId(@Nullable String backgroundCustomEmojiId) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withProfileAccentColorId(@Nullable Long profileAccentColorId) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withProfileBackgroundCustomEmojiId(@Nullable String profileBackgroundCustomEmojiId) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withEmojiStatusCustomEmojiId(@Nullable String emojiStatusCustomEmojiId) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withEmojiStatusExpirationDate(@Nullable Long emojiStatusExpirationDate) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withBio(@Nullable String bio) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withHasPrivateForwards(@Nullable Boolean hasPrivateForwards) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withHasRestrictedVoiceAndVideoMessages(@Nullable Boolean hasRestrictedVoiceAndVideoMessages) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withJoinToSendMessages(@Nullable Boolean joinToSendMessages) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withJoinByRequest(@Nullable Boolean joinByRequest) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withDescription(@Nullable String description) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withInviteLink(@Nullable String inviteLink) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withPinnedMessage(@Nullable Message pinnedMessage) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withPermissions(@Nullable ChatPermissions permissions) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withAcceptedGiftTypes(AcceptedGiftTypes acceptedGiftTypes) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withCanSendPaidMedia(@Nullable Boolean canSendPaidMedia) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withSlowModeDelay(@Nullable Long slowModeDelay) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withUnrestrictBoostCount(@Nullable Long unrestrictBoostCount) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withMessageAutoDeleteTime(@Nullable Long messageAutoDeleteTime) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withHasAggressiveAntiSpamEnabled(@Nullable Boolean hasAggressiveAntiSpamEnabled) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withHasHiddenMembers(@Nullable Boolean hasHiddenMembers) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withHasProtectedContent(@Nullable Boolean hasProtectedContent) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withHasVisibleHistory(@Nullable Boolean hasVisibleHistory) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withStickerSetName(@Nullable String stickerSetName) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withCanSetStickerSet(@Nullable Boolean canSetStickerSet) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withCustomEmojiStickerSetName(@Nullable String customEmojiStickerSetName) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withLinkedChatId(@Nullable Long linkedChatId) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withLocation(@Nullable ChatLocation location) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withRating(@Nullable UserRating rating) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withFirstProfileAudio(@Nullable Audio firstProfileAudio) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withUniqueGiftColors(@Nullable UniqueGiftColors uniqueGiftColors) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }

    public ChatFullInfo withPaidMessageStarCount(@Nullable Long paidMessageStarCount) {
        return new ChatFullInfo(id, type, title, username, firstName, lastName, isForum, isDirectMessages, accentColorId, maxReactionCount, photo, activeUsernames, birthdate, businessIntro, businessLocation, businessOpeningHours, personalChat, parentChat, availableReactions, backgroundCustomEmojiId, profileAccentColorId, profileBackgroundCustomEmojiId, emojiStatusCustomEmojiId, emojiStatusExpirationDate, bio, hasPrivateForwards, hasRestrictedVoiceAndVideoMessages, joinToSendMessages, joinByRequest, description, inviteLink, pinnedMessage, permissions, acceptedGiftTypes, canSendPaidMedia, slowModeDelay, unrestrictBoostCount, messageAutoDeleteTime, hasAggressiveAntiSpamEnabled, hasHiddenMembers, hasProtectedContent, hasVisibleHistory, stickerSetName, canSetStickerSet, customEmojiStickerSetName, linkedChatId, location, rating, firstProfileAudio, uniqueGiftColors, paidMessageStarCount);
    }
}
