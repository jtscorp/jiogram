package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
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

public class ChatFullInfo {
    @JsonProperty("id") private final long id;
    @JsonProperty("type") private final ChatType type;
    @JsonProperty("title") @Nullable private final String title;
    @JsonProperty("username") @Nullable private final String username;
    @JsonProperty("first_name") @Nullable private final String firstName;
    @JsonProperty("last_name") @Nullable private final String lastName;
    @JsonProperty("is_forum") @Nullable private final Boolean isForum;
    @JsonProperty("is_direct_messages") @Nullable private final Boolean isDirectMessages;
    @JsonProperty("accent_color_id") private final long accentColorId;
    @JsonProperty("max_reaction_count") private final long maxReactionCount;
    @JsonProperty("photo") @Nullable private final ChatPhoto photo;
    @JsonProperty("active_usernames") @Nullable private final List<String> activeUsernames;
    @JsonProperty("birthdate") @Nullable private final Birthdate birthdate;
    @JsonProperty("business_intro") @Nullable private final BusinessIntro businessIntro;
    @JsonProperty("business_location") @Nullable private final BusinessLocation businessLocation;
    @JsonProperty("business_opening_hours") @Nullable private final BusinessOpeningHours businessOpeningHours;
    @JsonProperty("personal_chat") @Nullable private final Chat personalChat;
    @JsonProperty("parent_chat") @Nullable private final Chat parentChat;
    @JsonProperty("available_reactions") @Nullable private final List<ReactionType> availableReactions;
    @JsonProperty("background_custom_emoji_id") @Nullable private final String backgroundCustomEmojiId;
    @JsonProperty("profile_accent_color_id") @Nullable private final Long profileAccentColorId;
    @JsonProperty("profile_background_custom_emoji_id") @Nullable private final String profileBackgroundCustomEmojiId;
    @JsonProperty("emoji_status_custom_emoji_id") @Nullable private final String emojiStatusCustomEmojiId;
    @JsonProperty("emoji_status_expiration_date") @Nullable private final Long emojiStatusExpirationDate;
    @JsonProperty("bio") @Nullable private final String bio;
    @JsonProperty("has_private_forwards") @Nullable private final Boolean hasPrivateForwards;
    @JsonProperty("has_restricted_voice_and_video_messages") @Nullable private final Boolean hasRestrictedVoiceAndVideoMessages;
    @JsonProperty("join_to_send_messages") @Nullable private final Boolean joinToSendMessages;
    @JsonProperty("join_by_request") @Nullable private final Boolean joinByRequest;
    @JsonProperty("description") @Nullable private final String description;
    @JsonProperty("invite_link") @Nullable private final String inviteLink;
    @JsonProperty("pinned_message") @Nullable private final Message pinnedMessage;
    @JsonProperty("permissions") @Nullable private final ChatPermissions permissions;
    @JsonProperty("accepted_gift_types") private final AcceptedGiftTypes acceptedGiftTypes;
    @JsonProperty("can_send_paid_media") @Nullable private final Boolean canSendPaidMedia;
    @JsonProperty("slow_mode_delay") @Nullable private final Long slowModeDelay;
    @JsonProperty("unrestrict_boost_count") @Nullable private final Long unrestrictBoostCount;
    @JsonProperty("message_auto_delete_time") @Nullable private final Long messageAutoDeleteTime;
    @JsonProperty("has_aggressive_anti_spam_enabled") @Nullable private final Boolean hasAggressiveAntiSpamEnabled;
    @JsonProperty("has_hidden_members") @Nullable private final Boolean hasHiddenMembers;
    @JsonProperty("has_protected_content") @Nullable private final Boolean hasProtectedContent;
    @JsonProperty("has_visible_history") @Nullable private final Boolean hasVisibleHistory;
    @JsonProperty("sticker_set_name") @Nullable private final String stickerSetName;
    @JsonProperty("can_set_sticker_set") @Nullable private final Boolean canSetStickerSet;
    @JsonProperty("custom_emoji_sticker_set_name") @Nullable private final String customEmojiStickerSetName;
    @JsonProperty("linked_chat_id") @Nullable private final Long linkedChatId;
    @JsonProperty("location") @Nullable private final ChatLocation location;
    @JsonProperty("rating") @Nullable private final UserRating rating;
    @JsonProperty("first_profile_audio") @Nullable private final Audio firstProfileAudio;
    @JsonProperty("unique_gift_colors") @Nullable private final UniqueGiftColors uniqueGiftColors;
    @JsonProperty("paid_message_star_count") @Nullable private final Long paidMessageStarCount;

    @JsonCreator
    public ChatFullInfo(
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
        this.id = id;
        this.type = type;
        this.title = title;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isForum = isForum;
        this.isDirectMessages = isDirectMessages;
        this.accentColorId = accentColorId;
        this.maxReactionCount = maxReactionCount;
        this.photo = photo;
        this.activeUsernames = activeUsernames;
        this.birthdate = birthdate;
        this.businessIntro = businessIntro;
        this.businessLocation = businessLocation;
        this.businessOpeningHours = businessOpeningHours;
        this.personalChat = personalChat;
        this.parentChat = parentChat;
        this.availableReactions = availableReactions;
        this.backgroundCustomEmojiId = backgroundCustomEmojiId;
        this.profileAccentColorId = profileAccentColorId;
        this.profileBackgroundCustomEmojiId = profileBackgroundCustomEmojiId;
        this.emojiStatusCustomEmojiId = emojiStatusCustomEmojiId;
        this.emojiStatusExpirationDate = emojiStatusExpirationDate;
        this.bio = bio;
        this.hasPrivateForwards = hasPrivateForwards;
        this.hasRestrictedVoiceAndVideoMessages = hasRestrictedVoiceAndVideoMessages;
        this.joinToSendMessages = joinToSendMessages;
        this.joinByRequest = joinByRequest;
        this.description = description;
        this.inviteLink = inviteLink;
        this.pinnedMessage = pinnedMessage;
        this.permissions = permissions;
        this.acceptedGiftTypes = acceptedGiftTypes;
        this.canSendPaidMedia = canSendPaidMedia;
        this.slowModeDelay = slowModeDelay;
        this.unrestrictBoostCount = unrestrictBoostCount;
        this.messageAutoDeleteTime = messageAutoDeleteTime;
        this.hasAggressiveAntiSpamEnabled = hasAggressiveAntiSpamEnabled;
        this.hasHiddenMembers = hasHiddenMembers;
        this.hasProtectedContent = hasProtectedContent;
        this.hasVisibleHistory = hasVisibleHistory;
        this.stickerSetName = stickerSetName;
        this.canSetStickerSet = canSetStickerSet;
        this.customEmojiStickerSetName = customEmojiStickerSetName;
        this.linkedChatId = linkedChatId;
        this.location = location;
        this.rating = rating;
        this.firstProfileAudio = firstProfileAudio;
        this.uniqueGiftColors = uniqueGiftColors;
        this.paidMessageStarCount = paidMessageStarCount;
    }

    public long id() {
        return this.id;
    }

    public ChatType type() {
        return this.type;
    }

    public String title() {
        return this.title;
    }

    public String username() {
        return this.username;
    }

    public String firstName() {
        return this.firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public Boolean isForum() {
        return this.isForum;
    }

    public Boolean isDirectMessages() {
        return this.isDirectMessages;
    }

    public long accentColorId() {
        return this.accentColorId;
    }

    public long maxReactionCount() {
        return this.maxReactionCount;
    }

    public ChatPhoto photo() {
        return this.photo;
    }

    public List<String> activeUsernames() {
        return this.activeUsernames;
    }

    public Birthdate birthdate() {
        return this.birthdate;
    }

    public BusinessIntro businessIntro() {
        return this.businessIntro;
    }

    public BusinessLocation businessLocation() {
        return this.businessLocation;
    }

    public BusinessOpeningHours businessOpeningHours() {
        return this.businessOpeningHours;
    }

    public Chat personalChat() {
        return this.personalChat;
    }

    public Chat parentChat() {
        return this.parentChat;
    }

    public List<ReactionType> availableReactions() {
        return this.availableReactions;
    }

    public String backgroundCustomEmojiId() {
        return this.backgroundCustomEmojiId;
    }

    public Long profileAccentColorId() {
        return this.profileAccentColorId;
    }

    public String profileBackgroundCustomEmojiId() {
        return this.profileBackgroundCustomEmojiId;
    }

    public String emojiStatusCustomEmojiId() {
        return this.emojiStatusCustomEmojiId;
    }

    public Long emojiStatusExpirationDate() {
        return this.emojiStatusExpirationDate;
    }

    public String bio() {
        return this.bio;
    }

    public Boolean hasPrivateForwards() {
        return this.hasPrivateForwards;
    }

    public Boolean hasRestrictedVoiceAndVideoMessages() {
        return this.hasRestrictedVoiceAndVideoMessages;
    }

    public Boolean joinToSendMessages() {
        return this.joinToSendMessages;
    }

    public Boolean joinByRequest() {
        return this.joinByRequest;
    }

    public String description() {
        return this.description;
    }

    public String inviteLink() {
        return this.inviteLink;
    }

    public Message pinnedMessage() {
        return this.pinnedMessage;
    }

    public ChatPermissions permissions() {
        return this.permissions;
    }

    public AcceptedGiftTypes acceptedGiftTypes() {
        return this.acceptedGiftTypes;
    }

    public Boolean canSendPaidMedia() {
        return this.canSendPaidMedia;
    }

    public Long slowModeDelay() {
        return this.slowModeDelay;
    }

    public Long unrestrictBoostCount() {
        return this.unrestrictBoostCount;
    }

    public Long messageAutoDeleteTime() {
        return this.messageAutoDeleteTime;
    }

    public Boolean hasAggressiveAntiSpamEnabled() {
        return this.hasAggressiveAntiSpamEnabled;
    }

    public Boolean hasHiddenMembers() {
        return this.hasHiddenMembers;
    }

    public Boolean hasProtectedContent() {
        return this.hasProtectedContent;
    }

    public Boolean hasVisibleHistory() {
        return this.hasVisibleHistory;
    }

    public String stickerSetName() {
        return this.stickerSetName;
    }

    public Boolean canSetStickerSet() {
        return this.canSetStickerSet;
    }

    public String customEmojiStickerSetName() {
        return this.customEmojiStickerSetName;
    }

    public Long linkedChatId() {
        return this.linkedChatId;
    }

    public ChatLocation location() {
        return this.location;
    }

    public UserRating rating() {
        return this.rating;
    }

    public Audio firstProfileAudio() {
        return this.firstProfileAudio;
    }

    public UniqueGiftColors uniqueGiftColors() {
        return this.uniqueGiftColors;
    }

    public Long paidMessageStarCount() {
        return this.paidMessageStarCount;
    }
}
