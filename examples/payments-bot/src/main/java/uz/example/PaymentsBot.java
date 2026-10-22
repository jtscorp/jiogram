package uz.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.OnPreCheckoutQuery;
import io.jiogram.annotation.OnShippingQuery;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.AnswerPreCheckoutQuery;
import io.jiogram.methods.AnswerShippingQuery;
import io.jiogram.methods.SendInvoice;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.LabeledPrice;
import io.jiogram.types.Message;
import io.jiogram.types.PreCheckoutQuery;
import io.jiogram.types.ShippingOption;
import io.jiogram.types.ShippingQuery;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;

import java.util.List;

@TelegramController
public class PaymentsBot {

    private final String providerToken;
    private final String payload;

    public PaymentsBot(
            @Value("${payment.provider-token:}") String providerToken,
            @Value("${payment.payload:jiogram-demo-invoice}") String payload) {
        this.providerToken = providerToken;
        this.payload = payload;
    }

    @OnMessage
    @Command("start")
    public SendMessage start(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "Use /buy to receive a demo invoice."
        );
    }

    @OnMessage
    @Command("buy")
    public SendInvoice buy(Message message) {
        List<LabeledPrice> prices = List.of(
            new LabeledPrice("Demo item", 500),
            new LabeledPrice("Tax", 100)
        );

        return new SendInvoice(
            ChatId.of(message.chat().id()),
            null,
            null,
            "Jiogram demo invoice",
            "A small invoice example with shipping and pre-checkout handlers.",
            payload,
            providerToken,
            "USD",
            prices,
            null,
            null,
            "demo",
            null,
            null,
            null,
            null,
            null,
            true,
            true,
            true,
            true,
            null,
            null,
            true,
            null,
            null,
            null,
            null,
            null,
            null,
            null
        );
    }

    @OnShippingQuery
    public Mono<Void> shipping(ShippingQuery query, Bot bot) {
        List<ShippingOption> options = List.of(
            new ShippingOption("regular", "Regular shipping", List.of(new LabeledPrice("Regular", 300))),
            new ShippingOption("fast", "Fast shipping", List.of(new LabeledPrice("Fast", 700)))
        );
        return bot.execute(new AnswerShippingQuery(query.id(), true, options, null)).then();
    }

    @OnPreCheckoutQuery
    public Mono<Void> preCheckout(PreCheckoutQuery query, Bot bot) {
        if (!payload.equals(query.invoicePayload())) {
            var answer = new AnswerPreCheckoutQuery(
                query.id(),
                false,
                "Wrong invoice payload."
            );
            return bot.execute(answer).then();
        }
        return bot.execute(AnswerPreCheckoutQuery.of(query.id(), true)).then();
    }

    @OnMessage
    public SendMessage successfulPayment(Message message) {
        if (message.successfulPayment() == null) {
            return null;
        }
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            "Payment received. Thank you!"
        );
    }
}
