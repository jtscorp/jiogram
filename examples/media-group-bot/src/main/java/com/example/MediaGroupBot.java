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
import io.jiogram.types.InputFile;
import io.jiogram.types.InputFileOrString;
import io.jiogram.types.InputMedia;
import io.jiogram.types.InputMediaPhoto;
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
        List<InputMedia> media = List.of(
            InputMediaPhoto.of(InputFileOrString.of("https://picsum.photos/id/1025/800/500"))
                .withCaption("Photo from URL"),
            InputMediaPhoto.of(InputFileOrString.of("https://picsum.photos/id/1062/800/500"))
                .withCaption("Another photo")
        );

        // answer(message, ...) sends to the message's chat, and into its forum topic in a group.
        return bot.execute(SendMessage.answer(message, "Sending a media group..."))
            .then(bot.execute(SendChatAction.answer(message, ChatAction.UPLOAD_PHOTO)))
            .then(Mono.delay(Duration.ofSeconds(1)))
            .then(bot.execute(SendMediaGroup.answer(message, media)))
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
        List<InputMedia> album = List.of(
            InputMediaPhoto.of(InputFileOrString.of(InputFile.fromBytes("red.png", square(new Color(0xE5, 0x39, 0x35)))))
                .withCaption("<b>Red</b>, uploaded from memory"),
            InputMediaPhoto.of(InputFileOrString.of(InputFile.fromBytes("blue.png", square(new Color(0x1E, 0x88, 0xE5)))))
                .withCaption("<i>Blue</i>, uploaded from memory")
        );

        Path report = Files.createTempFile("jiogram-report-", ".txt");
        Files.writeString(report, "Uploaded by jiogram from " + report.getFileName() + "\n");
        SendDocument document = SendDocument.answer(message, InputFileOrString.of(InputFile.fromPath(report)))
            .withCaption("<b>A file from disk</b>");

        return bot.execute(SendMediaGroup.answer(message, album))
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
