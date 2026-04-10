package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonCreator;
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

public class ExternalReplyInfo {
    @JsonProperty("origin") private final MessageOrigin origin;
    @JsonProperty("chat") @Nullable private final Chat chat;
    @JsonProperty("message_id") @Nullable private final Long messageId;
    @JsonProperty("link_preview_options") @Nullable private final LinkPreviewOptions linkPreviewOptions;
    @JsonProperty("animation") @Nullable private final Animation animation;
    @JsonProperty("audio") @Nullable private final Audio audio;
    @JsonProperty("document") @Nullable private final Document document;
    @JsonProperty("paid_media") @Nullable private final PaidMediaInfo paidMedia;
    @JsonProperty("photo") @Nullable private final List<PhotoSize> photo;
    @JsonProperty("sticker") @Nullable private final Sticker sticker;
    @JsonProperty("story") @Nullable private final Story story;
    @JsonProperty("video") @Nullable private final Video video;
    @JsonProperty("video_note") @Nullable private final VideoNote videoNote;
    @JsonProperty("voice") @Nullable private final Voice voice;
    @JsonProperty("has_media_spoiler") @Nullable private final Boolean hasMediaSpoiler;
    @JsonProperty("checklist") @Nullable private final Checklist checklist;
    @JsonProperty("contact") @Nullable private final Contact contact;
    @JsonProperty("dice") @Nullable private final Dice dice;
    @JsonProperty("game") @Nullable private final Game game;
    @JsonProperty("giveaway") @Nullable private final Giveaway giveaway;
    @JsonProperty("giveaway_winners") @Nullable private final GiveawayWinners giveawayWinners;
    @JsonProperty("invoice") @Nullable private final Invoice invoice;
    @JsonProperty("location") @Nullable private final Location location;
    @JsonProperty("poll") @Nullable private final Poll poll;
    @JsonProperty("venue") @Nullable private final Venue venue;

    @JsonCreator
    public ExternalReplyInfo(
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
    ) {
        this.origin = origin;
        this.chat = chat;
        this.messageId = messageId;
        this.linkPreviewOptions = linkPreviewOptions;
        this.animation = animation;
        this.audio = audio;
        this.document = document;
        this.paidMedia = paidMedia;
        this.photo = photo;
        this.sticker = sticker;
        this.story = story;
        this.video = video;
        this.videoNote = videoNote;
        this.voice = voice;
        this.hasMediaSpoiler = hasMediaSpoiler;
        this.checklist = checklist;
        this.contact = contact;
        this.dice = dice;
        this.game = game;
        this.giveaway = giveaway;
        this.giveawayWinners = giveawayWinners;
        this.invoice = invoice;
        this.location = location;
        this.poll = poll;
        this.venue = venue;
    }

    public MessageOrigin origin() {
        return this.origin;
    }

    public Chat chat() {
        return this.chat;
    }

    public Long messageId() {
        return this.messageId;
    }

    public LinkPreviewOptions linkPreviewOptions() {
        return this.linkPreviewOptions;
    }

    public Animation animation() {
        return this.animation;
    }

    public Audio audio() {
        return this.audio;
    }

    public Document document() {
        return this.document;
    }

    public PaidMediaInfo paidMedia() {
        return this.paidMedia;
    }

    public List<PhotoSize> photo() {
        return this.photo;
    }

    public Sticker sticker() {
        return this.sticker;
    }

    public Story story() {
        return this.story;
    }

    public Video video() {
        return this.video;
    }

    public VideoNote videoNote() {
        return this.videoNote;
    }

    public Voice voice() {
        return this.voice;
    }

    public Boolean hasMediaSpoiler() {
        return this.hasMediaSpoiler;
    }

    public Checklist checklist() {
        return this.checklist;
    }

    public Contact contact() {
        return this.contact;
    }

    public Dice dice() {
        return this.dice;
    }

    public Game game() {
        return this.game;
    }

    public Giveaway giveaway() {
        return this.giveaway;
    }

    public GiveawayWinners giveawayWinners() {
        return this.giveawayWinners;
    }

    public Invoice invoice() {
        return this.invoice;
    }

    public Location location() {
        return this.location;
    }

    public Poll poll() {
        return this.poll;
    }

    public Venue venue() {
        return this.venue;
    }
}
