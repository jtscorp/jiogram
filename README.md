# Jiogram

A Java Spring Boot framework for building Telegram bots, inspired by Python's [aiogram](https://github.com/aiogram/aiogram).

Jiogram brings the ergonomic, annotation-driven handler model of aiogram to the Java/Spring ecosystem with full reactive support via Project Reactor.

> **This branch (`main`) targets Spring Boot 4.0.x.**
> For Spring Boot 3.5.x see the [`sb3.x` branch](https://github.com/jaxongir/jiogram/tree/sb3.x).
> For Spring Boot 2.7.x see the [`sb2.x` branch](https://github.com/jaxongir/jiogram/tree/sb2.x).
>
> **Maven coordinates:**
> ```
> implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0-SNAPSHOT'
> ```

## Quick Start

**1. build.gradle**

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '4.0.5'
    id 'io.spring.dependency-management' version '1.1.7'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

dependencies {
    implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0-SNAPSHOT'
}
```

**2. application.yml**

```yaml
telegram:
  token: ${BOT_TOKEN}
```

**3. EchoBot.java**

```java
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.TelegramController;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.ChatId;
import io.jiogram.types.Message;

@TelegramController
public class EchoBot {

    @OnMessage
    public SendMessage echo(Message message) {
        return SendMessage.of(
            ChatId.of(message.chat().id()),
            message.text()
        );
    }
}
```

That's it. Run your Spring Boot app and the bot starts polling for updates automatically.

## Features

- **Annotation-driven handlers** -- `@OnMessage`, `@OnCallbackQuery`, `@OnInlineQuery`, `@Command`, `@StateFilter`
- **Programmatic handler API** -- `router.onMessage().filter(Filters.command("start")).handle(...)`
- **Hierarchical routing** -- compose routers with `router.includeRouter(childRouter)`
- **Built-in filters** -- `Filters.command()`, `Filters.text()`, `Filters.regex()`, `Filters.callbackData()`, `Filters.state()`
- **Composable filters** -- `.and()`, `.or()`, `.negate()` on any filter
- **Middleware pipeline** -- intercept and transform updates before they reach handlers
- **Finite State Machine (FSM)** -- enum states, generated `@StateFilter` constants, and `FSMContext` for multi-step conversations
- **Pluggable FSM storage** -- in-memory (default) or Redis for distributed deployments
- **Reactive throughout** -- built on Project Reactor (`Mono`/`Flux`), fully non-blocking
- **Auto-return-value handling** -- return `SendMessage` from a handler and it gets executed automatically
- **Long-polling and webhook modes** -- switch with a single config property
- **Spring Boot auto-configuration** -- just add the starter dependency and a token

## Module Structure

| Module | Description |
|---|---|
| `jiogram-types` | Generated Java records for all Telegram Bot API types (`Message`, `Update`, `Chat`, etc.) |
| `jiogram-methods` | Generated Java records for all Telegram Bot API methods (`SendMessage`, `GetUpdates`, etc.) |
| `jiogram-core` | Dispatcher, Router, Filters, Middleware, Handler infrastructure, `Bot` class |
| `jiogram-fsm` | Finite State Machine: `@FSMStates`, `BotState`, `FSMContext`, `StateStorage`, `FSMMiddleware` |
| `jiogram-fsm-processor` | Annotation processor generating `<Enum>States` constants for `@FSMStates` enums (use as `annotationProcessor`) |
| `jiogram-spring-boot-starter` | Spring Boot auto-configuration, polling runner, webhook controller |
| `jiogram-codegen` | Code generator that produces `jiogram-types` and `jiogram-methods` from the Bot API schema |

## Requirements

- **Java 25** or newer
- **Spring Boot 4.0.x** (this branch)
- **Project Reactor** (comes with Spring Boot WebFlux)

For other Spring Boot versions, see [`docs/spring-boot-versions.md`](docs/spring-boot-versions.md).

## Configuration Reference

All properties live under the `telegram` prefix. See [docs/configuration.md](docs/configuration.md) for the full reference.

| Property | Default | Description |
|---|---|---|
| `telegram.token` | *(required)* | Bot API token from @BotFather |
| `telegram.mode` | `POLLING` | `POLLING` or `WEBHOOK` |
| `telegram.api.base-url` | `https://api.telegram.org` | Telegram Bot API endpoint; set to a local Bot API server URL when self-hosting |
| `telegram.polling.timeout` | `30` | Long-polling timeout in seconds |
| `telegram.polling.limit` | `100` | Max updates per poll |
| `telegram.polling.backoff` | `1000` | Error backoff in ms |
| `telegram.defaults.parse-mode` | `null` | Default parse mode (`HTML`, `MARKDOWN`, `MARKDOWN_V2`) |
| `telegram.fsm.enabled` | `true` | Enable FSM middleware |
| `telegram.fsm.strategy` | `USER_IN_CHAT` | FSM key strategy |
| `telegram.fsm.storage` | `memory` | `memory` or `redis` |

## Documentation

- [Getting Started](docs/getting-started.md)
- [Core Concepts](docs/core-concepts.md)
- [Configuration Reference](docs/configuration.md)

## Examples

| Example | Description |
|---|---|
| [Echo Bot](examples/echo-bot/) | Simplest bot: echoes back any text message |
| [Command Bot](examples/command-bot/) | Handles commands, inline keyboards, callback queries |
| [FSM Bot](examples/fsm-bot/) | Multi-step registration form using FSM |
| [Multi-Router Bot](examples/multi-router-bot/) | Splitting handlers across multiple controller classes |
| [Programmatic Bot](examples/programmatic-bot/) | Using the programmatic (non-annotation) router API |
| [Inline Bot](examples/inline-bot/) | Answers inline queries with article results |
| [Webhook Bot](examples/webhook-bot/) | Runs the same echo handler in webhook mode |
| [Broadcast Bot](examples/broadcast-bot/) | Sends a message to a configured list of users with basic error handling |
| [Media Group Bot](examples/media-group-bot/) | Sends a photo album with `sendMediaGroup` |
| [Regexp Bot](examples/regexp-bot/) | Uses regex filters for item commands and deep-link payloads |
| [Language Bot](examples/language-bot/) | Reads the user's Telegram language code |
| [Proxy Bot](examples/proxy-bot/) | Provides a `TelegramSession` bean that uses an HTTP/SOCKS5 proxy |
| [I18n Bot](examples/i18n-bot/) | Uses Spring `MessageSource` for localized replies |
| [Throttling Bot](examples/throttling-bot/) | Adds antiflood behavior through middleware |
| [Payments Bot](examples/payments-bot/) | Sends invoices and handles shipping/pre-checkout updates |
| [Local Server Bot](examples/local-server-bot/) | Uses a configurable Bot API base URL for a local Bot API server |
| [Updates Bot](examples/updates-bot/) | Demonstrates update-specific handlers for polls, reactions, chat members, business events, boosts, paid media, and managed bots |

## License

TBD
