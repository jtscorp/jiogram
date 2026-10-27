[O'zbekcha](uz/getting-started.md) · [English](getting-started.md)

# Getting Started

This guide walks you through creating your first Telegram bot with Jiogram.

## Prerequisites

- Java 17 or newer
- Gradle 8.x or newer
- A bot token from [@BotFather](https://t.me/BotFather)

## 1. Create a Spring Boot project

Create a new directory and add a `build.gradle`:

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.5.3'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'uz.example'
version = '1.0.0'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.1'
}
```

> **Note:** If you are building from the Jiogram source tree, use a project dependency instead:
> ```groovy
> dependencies {
>     implementation project(':jiogram-spring-boot-starter')
> }
> ```

## 2. Configure the bot token

Create `src/main/resources/application.yml`:

```yaml
telegram:
  token: ${BOT_TOKEN}
```

Set the `BOT_TOKEN` environment variable before running, or paste your token directly (not recommended for production).

## 3. Write the application entry point

Create `src/main/java/uz/example/Application.java`:

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

## 4. Write your first bot handler

Create `src/main/java/uz/example/MyBot.java`:

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

### How it works

- `@TelegramController` marks the class as a Spring component that Jiogram scans for handler methods.
- `@OnMessage` marks a method as a handler for incoming messages.
- `@Command("start")` is a filter that restricts the handler to `/start` commands only.
- The method can accept `Message`, `Bot`, and `UpdateContext` as parameters -- they are injected automatically.
- Returning a `SendMessage` (or any `TelegramMethod`) causes it to be executed automatically. You can also return `Mono<Void>` or `void` if you want to call `bot.execute(...)` yourself.

## 5. Run and test

```bash
BOT_TOKEN=123456:ABC-DEF ./gradlew bootRun
```

Open your bot in Telegram and send `/start`. You should get "Hello! I am your first Jiogram bot." back.

## Next steps

- Read [Core Concepts](core-concepts.md) to learn about routers, filters, middleware, and FSM.
- See the [Configuration Reference](configuration.md) for all available properties.
- Browse the [examples](../examples/) for complete working bots.
