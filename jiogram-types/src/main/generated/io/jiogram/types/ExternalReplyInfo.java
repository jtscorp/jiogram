package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.jiogram.types.Animation;
import io.jiogram.types.Audio;
import io.jiogram.types.Chat;
import io.jiogram.types.Checklist;
import io.jiogram.types.Contact;
import io.jiogram.types.Dice;
import io.jiogram.types.Document;
import io.jiogram.types.Game;
import io.jiogram.types.Giveaway;
import io.jiogram.types.GiveawayWinners;
import io.jiogram.types.Invoice;
import io.jiogram.types.LinkPreviewOptions;
import io.jiogram.types.Location;
import io.jiogram.types.MessageOrigin;
import io.jiogram.types.PaidMediaInfo;
import io.jiogram.types.PhotoSize;
import io.jiogram.types.Poll;
import io.jiogram.types.Sticker;
import io.jiogram.types.Story;
import io.jiogram.types.Venue;
import io.jiogram.types.Video;
import io.jiogram.types.VideoNote;
import io.jiogram.types.Voice;
import java.util.List;
import org.jspecify.annotations.Nullable;

public record ExternalReplyInfo(
    @JsonProperty("origin") MessageOrigin origin,
    @JsonProperty("chat") @Nullable Chat chat,
    @JsonProperty("message_id") @Nullable Long messageId,
    @JsonProperty("link_preview_options") @Nullable LinkPreviewOptions linkPreviewOptions,
    @JsonProperty("animation") @Nullable Animation animation,
    @JsonProperty("audio") @Nullable Audio audio,
    @JsonProperty("document") @Nullable Document document,
    @JsonProperty("paid_media") @Nullable PaidMediaInfo paidMedia,
    @JsonProperty("photo") @Nullable List<PhotoSize> photo,
    @JsonProperty("sticker") @Nullable Sticker sticker,
    @JsonProperty("story") @Nullable Story story,
    @JsonProperty("video") @Nullable Video video,
    @JsonProperty("video_note") @Nullable VideoNote videoNote,
    @JsonProperty("voice") @Nullable Voice voice,
    @JsonProperty("has_media_spoiler") @Nullable Boolean hasMediaSpoiler,
    @JsonProperty("checklist") @Nullable Checklist checklist,
    @JsonProperty("contact") @Nullable Contact contact,
    @JsonProperty("dice") @Nullable Dice dice,
    @JsonProperty("game") @Nullable Game game,
    @JsonProperty("giveaway") @Nullable Giveaway giveaway,
    @JsonProperty("giveaway_winners") @Nullable GiveawayWinners giveawayWinners,
    @JsonProperty("invoice") @Nullable Invoice invoice,
    @JsonProperty("location") @Nullable Location location,
    @JsonProperty("poll") @Nullable Poll poll,
    @JsonProperty("venue") @Nullable Venue venue
) {}
