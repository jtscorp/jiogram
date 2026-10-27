[O'zbekcha](getting-started.md) · [English](../getting-started.md)

# Ishni boshlash

Bu qo'llanmada Jiogram bilan birinchi Telegram botingizni qadamma-qadam yaratamiz.

## Talablar

- Java 11 yoki undan yangi
- Gradle 7.5 – 8.x (Spring Boot 2.7 Gradle plugini Gradle 9da ishlamaydi)
- [@BotFather](https://t.me/BotFather)dan olingan bot token

## 1. Spring Boot loyihasini yaratish

Yangi papka yarating va unga `build.gradle` qo'shing:

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.18'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'uz.example'
version = '1.0.0'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.1'
}
```

> **Eslatma:** Agar Jiogramni sourcedan build qilayotgan bo'lsangiz, o'rniga project dependency ishlating:
> ```groovy
> dependencies {
>     implementation project(':jiogram-spring-boot-starter')
> }
> ```

## 2. Bot tokenini sozlash

`src/main/resources/application.yml` faylini yarating:

```yaml
telegram:
  token: ${BOT_TOKEN}
```

Ishga tushirishdan oldin `BOT_TOKEN` environment variableini o'rnating yoki tokenni to'g'ridan-to'g'ri yozib qo'ying (production uchun tavsiya etilmaydi).

## 3. Ilovaning entry pointini yozish

`src/main/java/uz/example/Application.java` faylini yarating:

```java
package uz.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

## 4. Birinchi bot handlerini yozish

`src/main/java/uz/example/MyBot.java` faylini yarating:

```java
package uz.example;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.Message;

@TelegramController
public class MyBot {

    // Handles /start command
    @OnMessage
    @Command("start")
    public SendMessage start(Message message) {
        return SendMessage.answer(
            message,
            "Hello! I am your first Jiogram bot."
        );
    }

    // Handles /help command
    @OnMessage
    @Command("help")
    public SendMessage help(Message message) {
        return SendMessage.answer(
            message,
            "Available commands:\n/start - Start the bot\n/help - Show this help"
        );
    }

    // Handles all other text messages (no filter = catches everything not matched above)
    @OnMessage
    public SendMessage echo(Message message) {
        String text = message.text();
        if (text == null) {
            return null; // Ignore non-text messages
        }
        return SendMessage.answer(
            message,
            "You said: " + text
        );
    }
}
```

### Bu qanday ishlaydi

- `@TelegramController` classni Spring component sifatida belgilaydi, Jiogram undan handler methodlarni qidiradi.
- `@OnMessage` methodni kiruvchi xabarlar uchun handler sifatida belgilaydi.
- `@Command("start")` filter: handler faqat `/start` commandiga ishlaydi.
- Method parametr sifatida `Message`, `Bot` va `UpdateContext` qabul qila oladi -- ular avtomatik inject qilinadi.
- `SendMessage` (yoki istalgan `TelegramMethod`) qaytarilsa, u avtomatik execute qilinadi. `bot.execute(...)`ni o'zingiz chaqirmoqchi bo'lsangiz, `Mono<Void>` yoki `void` qaytarishingiz ham mumkin.

## 5. Ishga tushirish va tekshirish

```bash
BOT_TOKEN=123456:ABC-DEF ./gradlew bootRun
```

Telegramda botingizni oching va `/start` yuboring. Javobga "Hello! I am your first Jiogram bot." kelishi kerak.

## Keyingi qadamlar

- Router, filter, middleware va FSM haqida bilish uchun [Asosiy tushunchalar](core-concepts.md)ni o'qing.
- Barcha mavjud propertylar uchun [Konfiguratsiya ma'lumotnomasi](configuration.md)ga qarang.
- To'liq ishlaydigan botlar uchun [examples](../../examples/)ni ko'rib chiqing.
