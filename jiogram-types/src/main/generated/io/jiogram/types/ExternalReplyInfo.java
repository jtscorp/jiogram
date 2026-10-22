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

/**
 * This object contains information about a message that is being replied to, which may come from
 * another chat or forum topic.
 *
 * @param origin Origin of the message replied to by the given message
 * @param chat Chat the original message belongs to. Available only if the chat is a supergroup or a
 *     channel.
 * @param messageId Unique message identifier inside the original chat. Available only if the
 *     original chat is a supergroup or a channel.
 * @param linkPreviewOptions Options used for link preview generation for the original message, if
 *     it is a text message
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
 * @see <a href="https://core.telegram.org/bots/api#externalreplyinfo">ExternalReplyInfo in the Bot API</a>
 */
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
) {

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
}
