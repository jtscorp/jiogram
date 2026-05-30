package com.example;

import io.jiogram.annotation.OnInlineQuery;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.AnswerInlineQuery;
import io.jiogram.types.InlineQuery;
import io.jiogram.types.InlineQueryResult;
import io.jiogram.types.InlineQueryResultArticle;
import io.jiogram.types.InlineQueryResultType;
import io.jiogram.types.InputTextMessageContent;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;

@TelegramController
public class InlineBot {

    @OnInlineQuery
    public Mono<Void> inlineEcho(InlineQuery inlineQuery, Bot bot) {
        String text = inlineQuery.query() == null || inlineQuery.query().isBlank()
            ? "echo"
            : inlineQuery.query();

        var content = new InputTextMessageContent(text, null, null, null);
        InlineQueryResult item = new InlineQueryResultArticle(
            InlineQueryResultType.ARTICLE,
            stableId(text),
            "Result: " + text,
            content,
            null,
            null,
            "Send this text to the chat",
            null,
            null,
            null
        );

        var answer = new AnswerInlineQuery(
            inlineQuery.id(),
            List.of(item),
            1L,
            true,
            null,
            null
        );

        return bot.execute(answer).then();
    }

    private static String stableId(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return HexFormat.of().formatHex(digest.digest(text.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 digest is unavailable", e);
        }
    }
}
