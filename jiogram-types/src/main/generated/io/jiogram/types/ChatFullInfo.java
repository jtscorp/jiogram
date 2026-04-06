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
import io.jiogram.types.Message;
import io.jiogram.types.ReactionType;
import io.jiogram.types.UniqueGiftColors;
import io.jiogram.types.UserRating;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ChatFullInfo(
    @JsonProperty("id") long id,
    @JsonProperty("type") String type,
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
) {}
