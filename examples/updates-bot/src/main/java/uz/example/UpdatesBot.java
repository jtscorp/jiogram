package uz.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnBusinessConnection;
import io.jiogram.annotation.OnBusinessMessage;
import io.jiogram.annotation.OnChannelPost;
import io.jiogram.annotation.OnChatBoost;
import io.jiogram.annotation.OnChatJoinRequest;
import io.jiogram.annotation.OnChatMember;
import io.jiogram.annotation.OnChosenInlineResult;
import io.jiogram.annotation.OnDeletedBusinessMessages;
import io.jiogram.annotation.OnEditedBusinessMessage;
import io.jiogram.annotation.OnEditedChannelPost;
import io.jiogram.annotation.OnEditedMessage;
import io.jiogram.annotation.OnManagedBot;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.OnMessageReaction;
import io.jiogram.annotation.OnMessageReactionCount;
import io.jiogram.annotation.OnMyChatMember;
import io.jiogram.annotation.OnPoll;
import io.jiogram.annotation.OnPollAnswer;
import io.jiogram.annotation.OnPurchasedPaidMedia;
import io.jiogram.annotation.OnRemovedChatBoost;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.SendMessage;
import io.jiogram.methods.SendPoll;
import io.jiogram.types.BusinessConnection;
import io.jiogram.types.BusinessMessagesDeleted;
import io.jiogram.types.ChatBoostRemoved;
import io.jiogram.types.ChatBoostUpdated;
import io.jiogram.types.ChatId;
import io.jiogram.types.ChatJoinRequest;
import io.jiogram.types.ChatMemberUpdated;
import io.jiogram.types.ChosenInlineResult;
import io.jiogram.types.InputPollOption;
import io.jiogram.types.ManagedBotUpdated;
import io.jiogram.types.Message;
import io.jiogram.types.MessageReactionCountUpdated;
import io.jiogram.types.MessageReactionUpdated;
import io.jiogram.types.PaidMediaPurchased;
import io.jiogram.types.Poll;
import io.jiogram.types.PollAnswer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

@TelegramController
public class UpdatesBot {

    private static final Logger log = LoggerFactory.getLogger(UpdatesBot.class);

    @OnMessage
    @Command("start")
    public SendMessage start(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            """
            <b>Updates bot</b>
            Use /poll to send a poll.
            Edit a message, react to messages, use inline mode feedback, or add the bot to a group/channel to see update-specific handlers.
            """
        );
    }

    @OnMessage
    @Command("poll")
    public SendPoll poll(Message message) {
        return SendPoll.of(
            ChatId.of(message.chat().id()),
            "Which Jiogram API style do you prefer?",
            List.of(
                new InputPollOption("Annotations", null, null),
                new InputPollOption("Programmatic router", null, null),
                new InputPollOption("Both", null, null)
            )
        );
    }

    @OnEditedMessage
    public SendMessage editedMessage(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "You edited message <code>" + message.messageId() + "</code>."
        );
    }

    @OnChannelPost
    public void channelPost(Message message) {
        log.info("Channel post {} in chat {}", message.messageId(), message.chat().id());
    }

    @OnEditedChannelPost
    public void editedChannelPost(Message message) {
        log.info("Edited channel post {} in chat {}", message.messageId(), message.chat().id());
    }

    @OnBusinessConnection
    public SendMessage businessConnection(BusinessConnection connection) {
        if (!connection.isEnabled()) {
            log.info("Business connection {} was disabled", connection.id());
            return null;
        }
        return SendMessage.of(
            ChatId.of(connection.userChatId()),
            "Business connection <code>" + connection.id() + "</code> is enabled."
        );
    }

    @OnBusinessMessage
    public SendMessage businessMessage(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "Received a business message."
        );
    }

    @OnEditedBusinessMessage
    public void editedBusinessMessage(Message message) {
        log.info("Edited business message {} in chat {}", message.messageId(), message.chat().id());
    }

    @OnDeletedBusinessMessages
    public void deletedBusinessMessages(BusinessMessagesDeleted deleted) {
        log.info(
            "Business connection {} deleted messages {} in chat {}",
            deleted.businessConnectionId(),
            deleted.messageIds(),
            deleted.chat().id()
        );
    }

    @OnMessageReaction
    public void messageReaction(MessageReactionUpdated reaction) {
        log.info(
            "Reaction changed for message {} in chat {}: {} -> {}",
            reaction.messageId(),
            reaction.chat().id(),
            reaction.oldReaction(),
            reaction.newReaction()
        );
    }

    @OnMessageReactionCount
    public void messageReactionCount(MessageReactionCountUpdated reactionCount) {
        log.info(
            "Anonymous reaction counts changed for message {} in chat {}: {}",
            reactionCount.messageId(),
            reactionCount.chat().id(),
            reactionCount.reactions()
        );
    }

    @OnChosenInlineResult
    public void chosenInlineResult(ChosenInlineResult result) {
        log.info(
            "User {} chose inline result {} for query '{}'",
            result.from().id(),
            result.resultId(),
            result.query()
        );
    }

    @OnPurchasedPaidMedia
    public SendMessage purchasedPaidMedia(PaidMediaPurchased purchased) {
        return SendMessage.of(
            ChatId.of(purchased.from().id()),
            "Paid media payload received: <code>" + purchased.paidMediaPayload() + "</code>"
        );
    }

    @OnPoll
    public void pollUpdate(Poll poll) {
        log.info("Poll {} '{}' has {} voters", poll.id(), poll.question(), poll.totalVoterCount());
    }

    @OnPollAnswer
    public void pollAnswer(PollAnswer answer) {
        long userId = answer.user() == null ? 0 : answer.user().id();
        log.info("Poll {} answer from {}: {}", answer.pollId(), userId, answer.optionIds());
    }

    @OnMyChatMember
    public void myChatMember(ChatMemberUpdated update) {
        log.info(
            "Bot membership changed in chat {} by user {}",
            update.chat().id(),
            update.from().id()
        );
    }

    @OnChatMember
    public void chatMember(ChatMemberUpdated update) {
        log.info(
            "Chat member changed in chat {} by user {}",
            update.chat().id(),
            update.from().id()
        );
    }

    @OnChatJoinRequest
    public Mono<Void> chatJoinRequest(ChatJoinRequest request, Bot bot) {
        return bot.execute(SendMessage.of(
            ChatId.of(request.userChatId()),
            "Your join request for chat <code>" + request.chat().id() + "</code> was received."
        )).then();
    }

    @OnChatBoost
    public void chatBoost(ChatBoostUpdated boost) {
        log.info("Chat {} received a boost {}", boost.chat().id(), boost.boost().boostId());
    }

    @OnRemovedChatBoost
    public void removedChatBoost(ChatBoostRemoved boost) {
        log.info("Chat {} lost boost {}", boost.chat().id(), boost.boostId());
    }

    @OnManagedBot
    public void managedBot(ManagedBotUpdated managedBot) {
        log.info(
            "User {} updated managed bot {}",
            managedBot.user().id(),
            managedBot.bot().id()
        );
    }
}
