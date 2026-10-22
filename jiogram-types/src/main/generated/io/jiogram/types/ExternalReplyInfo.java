package io.jiogram.types;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
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
import java.util.Objects;
import org.jspecify.annotations.Nullable;

/**
 * This object contains information about a message that is being replied to, which may come from
 * another chat or forum topic.
 *
 * @see <a href="https://core.telegram.org/bots/api#externalreplyinfo">ExternalReplyInfo in the Bot API</a>
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE)
public final class ExternalReplyInfo {

    @JsonProperty("origin")
    private final MessageOrigin origin;

    @JsonProperty("chat")
    private final @Nullable Chat chat;

    @JsonProperty("message_id")
    private final @Nullable Long messageId;

    @JsonProperty("link_preview_options")
    private final @Nullable LinkPreviewOptions linkPreviewOptions;

    @JsonProperty("animation")
    private final @Nullable Animation animation;

    @JsonProperty("audio")
    private final @Nullable Audio audio;

    @JsonProperty("document")
    private final @Nullable Document document;

    @JsonProperty("paid_media")
    private final @Nullable PaidMediaInfo paidMedia;

    @JsonProperty("photo")
    private final @Nullable List<PhotoSize> photo;

    @JsonProperty("sticker")
    private final @Nullable Sticker sticker;

    @JsonProperty("story")
    private final @Nullable Story story;

    @JsonProperty("video")
    private final @Nullable Video video;

    @JsonProperty("video_note")
    private final @Nullable VideoNote videoNote;

    @JsonProperty("voice")
    private final @Nullable Voice voice;

    @JsonProperty("has_media_spoiler")
    private final @Nullable Boolean hasMediaSpoiler;

    @JsonProperty("checklist")
    private final @Nullable Checklist checklist;

    @JsonProperty("contact")
    private final @Nullable Contact contact;

    @JsonProperty("dice")
    private final @Nullable Dice dice;

    @JsonProperty("game")
    private final @Nullable Game game;

    @JsonProperty("giveaway")
    private final @Nullable Giveaway giveaway;

    @JsonProperty("giveaway_winners")
    private final @Nullable GiveawayWinners giveawayWinners;

    @JsonProperty("invoice")
    private final @Nullable Invoice invoice;

    @JsonProperty("location")
    private final @Nullable Location location;

    @JsonProperty("poll")
    private final @Nullable Poll poll;

    @JsonProperty("venue")
    private final @Nullable Venue venue;

    /**
     * Creates a new {@code ExternalReplyInfo} instance.
     *
     * @param origin Origin of the message replied to by the given message
     * @param chat Chat the original message belongs to. Available only if the chat is a supergroup
     *     or a channel.
     * @param messageId Unique message identifier inside the original chat. Available only if the
     *     original chat is a supergroup or a channel.
     * @param linkPreviewOptions Options used for link preview generation for the original message,
     *     if it is a text message
     * @param animation Message is an animation, information about the animation
     * @param audio Message is an audio file, information about the file
     * @param document Message is a general file, information about the file
     * @param paidMedia Message contains paid media; information about the paid media
     * @param photo Message is a photo, available sizes of the photo
     * @param sticker Message is a sticker, information about the sticker
     * @param story Message is a forwarded story
     * @param video Message is a video, information about the video
     * @param videoNote Message is a video note, information about the video message
     * @param voice Message is a voice message, information about the file
     * @param hasMediaSpoiler True, if the message media is covered by a spoiler animation
     * @param checklist Message is a checklist
     * @param contact Message is a shared contact, information about the contact
     * @param dice Message is a dice with random value
     * @param game Message is a game, information about the game.
     * @param giveaway Message is a scheduled giveaway, information about the giveaway
     * @param giveawayWinners A giveaway with public winners was completed
     * @param invoice Message is an invoice for a payment, information about the invoice.
     * @param location Message is a shared location, information about the location
     * @param poll Message is a native poll, information about the poll
     * @param venue Message is a venue, information about the venue
     */
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
            @JsonProperty("venue") @Nullable Venue venue) {
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

    public static ExternalReplyInfo of(MessageOrigin origin) {
        return new ExternalReplyInfo(origin, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * Origin of the message replied to by the given message
     */
    public MessageOrigin origin() {
        return origin;
    }

    /**
     * Chat the original message belongs to. Available only if the chat is a supergroup or a
     * channel.
     */
    public @Nullable Chat chat() {
        return chat;
    }

    /**
     * Unique message identifier inside the original chat. Available only if the original chat is a
     * supergroup or a channel.
     */
    public @Nullable Long messageId() {
        return messageId;
    }

    /**
     * Options used for link preview generation for the original message, if it is a text message
     */
    public @Nullable LinkPreviewOptions linkPreviewOptions() {
        return linkPreviewOptions;
    }

    /**
     * Message is an animation, information about the animation
     */
    public @Nullable Animation animation() {
        return animation;
    }

    /**
     * Message is an audio file, information about the file
     */
    public @Nullable Audio audio() {
        return audio;
    }

    /**
     * Message is a general file, information about the file
     */
    public @Nullable Document document() {
        return document;
    }

    /**
     * Message contains paid media; information about the paid media
     */
    public @Nullable PaidMediaInfo paidMedia() {
        return paidMedia;
    }

    /**
     * Message is a photo, available sizes of the photo
     */
    public @Nullable List<PhotoSize> photo() {
        return photo;
    }

    /**
     * Message is a sticker, information about the sticker
     */
    public @Nullable Sticker sticker() {
        return sticker;
    }

    /**
     * Message is a forwarded story
     */
    public @Nullable Story story() {
        return story;
    }

    /**
     * Message is a video, information about the video
     */
    public @Nullable Video video() {
        return video;
    }

    /**
     * Message is a video note, information about the video message
     */
    public @Nullable VideoNote videoNote() {
        return videoNote;
    }

    /**
     * Message is a voice message, information about the file
     */
    public @Nullable Voice voice() {
        return voice;
    }

    /**
     * True, if the message media is covered by a spoiler animation
     */
    public @Nullable Boolean hasMediaSpoiler() {
        return hasMediaSpoiler;
    }

    /**
     * Message is a checklist
     */
    public @Nullable Checklist checklist() {
        return checklist;
    }

    /**
     * Message is a shared contact, information about the contact
     */
    public @Nullable Contact contact() {
        return contact;
    }

    /**
     * Message is a dice with random value
     */
    public @Nullable Dice dice() {
        return dice;
    }

    /**
     * Message is a game, information about the game.
     */
    public @Nullable Game game() {
        return game;
    }

    /**
     * Message is a scheduled giveaway, information about the giveaway
     */
    public @Nullable Giveaway giveaway() {
        return giveaway;
    }

    /**
     * A giveaway with public winners was completed
     */
    public @Nullable GiveawayWinners giveawayWinners() {
        return giveawayWinners;
    }

    /**
     * Message is an invoice for a payment, information about the invoice.
     */
    public @Nullable Invoice invoice() {
        return invoice;
    }

    /**
     * Message is a shared location, information about the location
     */
    public @Nullable Location location() {
        return location;
    }

    /**
     * Message is a native poll, information about the poll
     */
    public @Nullable Poll poll() {
        return poll;
    }

    /**
     * Message is a venue, information about the venue
     */
    public @Nullable Venue venue() {
        return venue;
    }

    public ExternalReplyInfo withOrigin(MessageOrigin origin) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withChat(@Nullable Chat chat) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withMessageId(@Nullable Long messageId) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withLinkPreviewOptions(@Nullable LinkPreviewOptions linkPreviewOptions) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withAnimation(@Nullable Animation animation) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withAudio(@Nullable Audio audio) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withDocument(@Nullable Document document) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withPaidMedia(@Nullable PaidMediaInfo paidMedia) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withPhoto(@Nullable List<PhotoSize> photo) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withSticker(@Nullable Sticker sticker) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withStory(@Nullable Story story) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withVideo(@Nullable Video video) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withVideoNote(@Nullable VideoNote videoNote) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withVoice(@Nullable Voice voice) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withHasMediaSpoiler(@Nullable Boolean hasMediaSpoiler) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withChecklist(@Nullable Checklist checklist) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withContact(@Nullable Contact contact) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withDice(@Nullable Dice dice) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withGame(@Nullable Game game) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withGiveaway(@Nullable Giveaway giveaway) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withGiveawayWinners(@Nullable GiveawayWinners giveawayWinners) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withInvoice(@Nullable Invoice invoice) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withLocation(@Nullable Location location) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withPoll(@Nullable Poll poll) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    public ExternalReplyInfo withVenue(@Nullable Venue venue) {
        return new ExternalReplyInfo(origin, chat, messageId, linkPreviewOptions, animation, audio, document, paidMedia, photo, sticker, story, video, videoNote, voice, hasMediaSpoiler, checklist, contact, dice, game, giveaway, giveawayWinners, invoice, location, poll, venue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExternalReplyInfo)) {
            return false;
        }
        ExternalReplyInfo that = (ExternalReplyInfo) o;
        return Objects.equals(this.origin, that.origin)
                && Objects.equals(this.chat, that.chat)
                && Objects.equals(this.messageId, that.messageId)
                && Objects.equals(this.linkPreviewOptions, that.linkPreviewOptions)
                && Objects.equals(this.animation, that.animation)
                && Objects.equals(this.audio, that.audio)
                && Objects.equals(this.document, that.document)
                && Objects.equals(this.paidMedia, that.paidMedia)
                && Objects.equals(this.photo, that.photo)
                && Objects.equals(this.sticker, that.sticker)
                && Objects.equals(this.story, that.story)
                && Objects.equals(this.video, that.video)
                && Objects.equals(this.videoNote, that.videoNote)
                && Objects.equals(this.voice, that.voice)
                && Objects.equals(this.hasMediaSpoiler, that.hasMediaSpoiler)
                && Objects.equals(this.checklist, that.checklist)
                && Objects.equals(this.contact, that.contact)
                && Objects.equals(this.dice, that.dice)
                && Objects.equals(this.game, that.game)
                && Objects.equals(this.giveaway, that.giveaway)
                && Objects.equals(this.giveawayWinners, that.giveawayWinners)
                && Objects.equals(this.invoice, that.invoice)
                && Objects.equals(this.location, that.location)
                && Objects.equals(this.poll, that.poll)
                && Objects.equals(this.venue, that.venue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.origin, this.chat, this.messageId, this.linkPreviewOptions, this.animation, this.audio, this.document, this.paidMedia, this.photo, this.sticker, this.story, this.video, this.videoNote, this.voice, this.hasMediaSpoiler, this.checklist, this.contact, this.dice, this.game, this.giveaway, this.giveawayWinners, this.invoice, this.location, this.poll, this.venue);
    }

    @Override
    public String toString() {
        return "ExternalReplyInfo[origin=" + this.origin
                + ", chat=" + this.chat
                + ", messageId=" + this.messageId
                + ", linkPreviewOptions=" + this.linkPreviewOptions
                + ", animation=" + this.animation
                + ", audio=" + this.audio
                + ", document=" + this.document
                + ", paidMedia=" + this.paidMedia
                + ", photo=" + this.photo
                + ", sticker=" + this.sticker
                + ", story=" + this.story
                + ", video=" + this.video
                + ", videoNote=" + this.videoNote
                + ", voice=" + this.voice
                + ", hasMediaSpoiler=" + this.hasMediaSpoiler
                + ", checklist=" + this.checklist
                + ", contact=" + this.contact
                + ", dice=" + this.dice
                + ", game=" + this.game
                + ", giveaway=" + this.giveaway
                + ", giveawayWinners=" + this.giveawayWinners
                + ", invoice=" + this.invoice
                + ", location=" + this.location
                + ", poll=" + this.poll
                + ", venue=" + this.venue
                + "]";
    }
}
