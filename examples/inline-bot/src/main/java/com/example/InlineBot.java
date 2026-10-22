package com.example;

import io.jiogram.annotation.OnInlineQuery;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.AnswerInlineQuery;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.InlineQueryResultArticle;
import io.jiogram.types.InputTextMessageContent;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@TelegramController
public class InlineBot {

    @OnInlineQuery
    public Mono<Void> inlineEcho(InlineQuery inlineQuery, Bot bot) {
        String text = inlineQuery.query() == null || inlineQuery.query().isBlank()
            ? "echo"
            : inlineQuery.query();

        InlineQueryResult item = InlineQueryResultArticle
            .of(stableId(text), "Result: " + text, InputTextMessageContent.of(text))
            .withDescription("Send this text to the chat");

        var answer = AnswerInlineQuery.of(inlineQuery.id(), List.of(item))
            .withCacheTime(1L)
            .withIsPersonal(true);

        return bot.execute(answer).then();
    }

    private static String stableId(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            StringBuilder hex = new StringBuilder();
            for (byte b : digest.digest(text.getBytes(StandardCharsets.UTF_8))) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 digest is unavailable", e);
        }
    }
}
