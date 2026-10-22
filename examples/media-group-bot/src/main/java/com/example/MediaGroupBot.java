package com.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.methods.SendChatAction;
import io.jiogram.methods.SendDocument;
import io.jiogram.methods.SendMediaGroup;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatAction;
import io.jiogram.types.ChatId;
import io.jiogram.types.InputFile;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMedia;
import io.jiogram.types.InputMediaPhoto;
import io.jiogram.types.InputMediaType;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;

@TelegramController
public class MediaGroupBot {

    @OnMessage
    @Command("start")
    public Mono<Void> start(Message message, Bot bot) {
        ChatId chatId = ChatId.of(message.chat().id());
        List<InputMedia> media = List.of(
            new InputMediaPhoto(
                InputMediaType.PHOTO,
                InputFileOrString.of("https://picsum.photos/id/1025/800/500"),
                "Photo from URL",
                null,
                null,
                null,
                null
            ),
            new InputMediaPhoto(
                InputMediaType.PHOTO,
                InputFileOrString.of("https://picsum.photos/id/1062/800/500"),
                "Another photo",
                null,
                null,
                null,
                null
            )
        );

        return bot.execute(SendMessage.of(chatId, "Sending a media group..."))
            .then(bot.execute(SendChatAction.of(chatId, ChatAction.UPLOAD_PHOTO)))
            .then(Mono.delay(Duration.ofSeconds(1)))
            .then(bot.execute(SendMediaGroup.of(chatId, media)))
            .then();
    }

    /**
     * Uploads files from the application instead of pointing Telegram at URLs: an album of two
     * images made in memory, then a document from a file on disk. Requests carrying files are
     * sent as multipart/form-data automatically. The captions use HTML; the default parse mode
     * from application.yml reaches each photo of the album too.
     */
    @OnMessage
    @Command("upload")
    public Mono<Void> upload(Message message, Bot bot) throws IOException {
        ChatId chatId = ChatId.of(message.chat().id());
        List<InputMedia> album = List.of(
            new InputMediaPhoto(InputMediaType.PHOTO,
                InputFileOrString.of(InputFile.fromBytes("red.png", square(new Color(0xE5, 0x39, 0x35)))),
                "<b>Red</b>, uploaded from memory", null, null, null, null),
            new InputMediaPhoto(InputMediaType.PHOTO,
                InputFileOrString.of(InputFile.fromBytes("blue.png", square(new Color(0x1E, 0x88, 0xE5)))),
                "<i>Blue</i>, uploaded from memory", null, null, null, null)
        );

        Path report = Files.createTempFile("jiogram-report-", ".txt");
        Files.writeString(report, "Uploaded by jiogram from " + report.getFileName() + "\n");
        SendDocument document = new SendDocument(null, chatId, null, null,
            InputFileOrString.of(InputFile.fromPath(report)), null, "<b>A file from disk</b>",
            null, null, null, null, null, null, null, null, null, null);

        return bot.execute(SendMediaGroup.of(chatId, album))
            .then(bot.execute(document))
            .doFinally(signal -> report.toFile().delete())
            .then();
    }

    private static byte[] square(Color color) throws IOException {
        BufferedImage image = new BufferedImage(320, 320, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, 320, 320);
        graphics.dispose();
        ByteArrayOutputStream png = new ByteArrayOutputStream();
        ImageIO.write(image, "png", png);
        return png.toByteArray();
    }
}
