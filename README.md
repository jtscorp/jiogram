# Jiogram

[O'zbekcha](#-ozbekcha) · [English](#-english)

[![Maven Central](https://img.shields.io/maven-central/v/uz.jtscorp.jiogram/jiogram-spring-boot-4-starter)](https://central.sonatype.com/artifact/uz.jtscorp.jiogram/jiogram-spring-boot-4-starter) [![Buy Me a Coffee](https://img.shields.io/badge/Buy%20Me%20a%20Coffee-support-yellow?logo=buymeacoffee&logoColor=black)](https://buymeacoffee.com/jtscorp)

***

## 🇺🇿 O'zbekcha

Jiogram — Telegram botlar yozish uchun Java Spring Boot frameworki. Pythondagi [aiogram](https://github.com/aiogram/aiogram)dan ilhomlanganman.

U Pythondagi qulay aiogram libini, annotationlarga asoslangan handler modelini Java/Springga moslab yozdim va to'liq Project Reactor ustida ishlaydi.

> **Bu branch (`main`) Spring Boot 4.0.x uchun.**
> Spring Boot 3.5.x uchun [`sb3.x` branch](https://github.com/jtscorp/jiogram/tree/sb3.x) ishlatishiz mumkin..
> Spring Boot 2.7.x uchun [`sb2.x` branch](https://github.com/jtscorp/jiogram/tree/sb2.x) ishlatishiz mumkin.
>
> **Maven koordinatalari:**
> ```
> implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0'
> ```

### Ishlatish bo'yicha yo'riqnoma:

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
    implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0'
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
import io.jiogram.types.Message;

@TelegramController
public class EchoBot {

    @OnMessage
    public SendMessage echo(Message message) {
        return SendMessage.answer(message, message.text());
    }
}
```

Shunday osongina ishga tushira olasiz. Spring Boot ilovani ishga tushirsangiz, bot updatelarni o'zi polling qila boshlaydi.

### Imkoniyatlar

- **Annotationli handlerlar:** `@OnMessage`, `@OnCallbackQuery`, `@OnInlineQuery`, `@Command`, `@StateFilter`.
- **Kod orqali handler API:** `router.onMessage().filter(Filters.command("start")).handle(...)`.
- **Ierarxik routing:** routerlarni `router.includeRouter(childRouter)` bilan birlashtirish mumkin.
- **Tayyor filterlar:** `Filters.command()`, `Filters.text()`, `Filters.regex()`, `Filters.callbackData()`, `Filters.state()`.
- **Filterlarni birlashtirish:** istalgan filterda `.and()`, `.or()`, `.negate()`.
- **Middleware pipeline:** updatelar handlerga yetib borguncha ularni ushlab, o'zgartirish mumkin.
- **FSM (Finite State Machine):** enum statelar, generate qilingan `@StateFilter` konstantalari va ko'p bosqichli suhbatlar uchun `FSMContext`.
- **FSM storage tanlovi:** xotirada (default) yoki bir nechta instance uchun Redisda.
- **To'liq reaktiv:** Project Reactor (`Mono`/`Flux`) ustida qurilgan; annotationli handlerlar virtual threadlarda ishlaydi, shuning uchun ular ichida blocking kod yozish mumkin.
- **Qaytarilgan qiymatni bajarish:** handler `SendMessage` qaytarsa, u avtomatik yuboriladi.
- **So'rov yasash:** `SendMessage.answer(message, text)` / `reply(...)` javobni to'g'ri chat va forum topicka yuboradi; uzun constructor o'rniga `of(...)` va `withX(...)`.
- **Fayl yuklash:** `InputFile.fromPath(...)` / `fromBytes(...)` so'rovning istalgan joyida; so'rov avtomatik multipart bo'lib ketadi.
- **Bot defaultlari:** parse mode, link preview va content protection har bir so'rovga, ichki obyektlarga ham qo'yiladi.
- **Long polling va webhook:** bitta sozlama bilan almashtiriladi; polling chatlarni parallel, har bir chat ichida esa tartib bilan qayta ishlaydi.
- **Xavfsiz dasturni tugatish:** ilova to'xtashdan oldin ishlayotgan batch tugaydi va Telegramda tasdiqlanadi.
- **Kelajak uchun:** Bot APIning yangi versiyalaridagi noma'lum enum qiymatlari va union variantlari parsingni buzmaydi.
- **Spring Boot auto-configuration:** starter dependency va token qo'shish kifoya.

### Modullar

| Modul | Vazifasi |
|---|---|
| `jiogram-types` | Telegram Bot APIning barcha typelari uchun generate qilingan Java recordlar (`Message`, `Update`, `Chat` va h.k.) |
| `jiogram-methods` | Telegram Bot APIning barcha methodlari uchun generate qilingan Java recordlar (`SendMessage`, `GetUpdates` va h.k.) |
| `jiogram-core` | Dispatcher, Router, Filterlar, Middleware, handler infratuzilmasi, `Bot` klassi |
| `jiogram-fsm` | Finite State Machine: `@FSMStates`, `BotState`, `FSMContext`, `StateStorage`, `FSMMiddleware` |
| `jiogram-fsm-processor` | `@FSMStates` enumlari uchun `<Enum>States` konstantalarini generate qiladigan annotation processor (`annotationProcessor` sifatida ulanadi) |
| `jiogram-spring-boot-starter` | Spring Boot auto-configuration, polling runner, webhook controller |
| `jiogram-codegen` | Bot API schemasidan `jiogram-types` va `jiogram-methods`ni yasaydigan kod generatori |

### Talablar

- **Java 25+** 
- **Spring Boot 4.0.x** (shu branch)
- Faqat webhook rejimi uchun: web server, masalan `spring-boot-starter-webflux` (polling botlarga kerak emas)

Boshqa Spring Boot versiyalari uchun [`docs/uz/spring-boot-versions.md`](docs/uz/spring-boot-versions.md)ni o'qib chiqing.

### Sozlamalar

Barcha sozlamalar `telegram` prefiksi ostida. To'liq ro'yxat: [docs/uz/configuration.md](docs/uz/configuration.md).

| Sozlama | Default | Tavsif |
|---|---|---|
| `telegram.token` | *(majburiy)* | @BotFatherdan olingan Bot API token |
| `telegram.mode` | `POLLING` | `POLLING` yoki `WEBHOOK` |
| `telegram.api.base-url` | `https://api.telegram.org` | Bot API manzili; o'zingizning Bot API serveringiz bo'lsa, uning URLini qo'ying |
| `telegram.api.request-timeout` | `60s` | Javobni kutish vaqti; `getUpdates`ga polling timeouti qo'shiladi |
| `telegram.api.max-response-size` | `16MB` | O'qiladigan javobning eng katta hajmi |
| `telegram.polling.timeout` | `30` | Long polling timeouti, soniyada |
| `telegram.polling.limit` | `100` | Bitta polldagi eng ko'p update soni |
| `telegram.polling.backoff` | `1000` | Xatodan keyingi kutish, ms |
| `telegram.polling.concurrency` | `32` | Bitta batchda parallel qayta ishlanadigan chatlar soni |
| `telegram.polling.shutdown-timeout` | `10s` | To'xtashda ishlayotgan batch qancha kutiladi |
| `telegram.webhook.secret-token` | *(bot tokendan)* | Har bir webhook so'rovida tekshiriladi; `webhook.url` berilsa, bot tokendan hosil qilinadi |
| `telegram.defaults.parse-mode` | `null` | Default parse mode (`HTML`, `MARKDOWN`, `MARKDOWN_V2`) |
| `telegram.handlers.virtual-threads` | `true` | Annotationli handlerlarni virtual threadlarda ishlatish |
| `telegram.fsm.enabled` | `true` | FSM middlewareni yoqish |
| `telegram.fsm.strategy` | `USER_IN_CHAT` | FSM key strategiyasi |
| `telegram.fsm.storage` | `memory` | `memory` yoki `redis` |
| `telegram.fsm.redis.key-prefix` | `jiogram:fsm` | Redis key prefiksi |
| `telegram.fsm.redis.state-ttl` / `data-ttl` | yo'q | FSM state / data oxirgi o'zgarishdan shuncha vaqt o'tib o'chadi |

### Hujjatlar

- [Ishni boshlash](docs/uz/getting-started.md)
- [Asosiy tushunchalar](docs/uz/core-concepts.md)
- [Konfiguratsiya ma'lumotnomasi](docs/uz/configuration.md)

### Misollar

| Misol | Tavsif |
|---|---|
| [Echo Bot](examples/echo-bot/) | Eng oddiy bot: har qanday matnni qaytaradi |
| [Command Bot](examples/command-bot/) | Commandlar, inline keyboard va callback querylar |
| [FSM Bot](examples/fsm-bot/) | FSM bilan ko'p bosqichli ro'yxatdan o'tish formasi |
| [Multi-Router Bot](examples/multi-router-bot/) | Handlerlarni bir nechta controller klasslariga bo'lish |
| [Programmatic Bot](examples/programmatic-bot/) | Annotationsiz, kod orqali router API |
| [Inline Bot](examples/inline-bot/) | Inline querylarga article natijalari bilan javob beradi |
| [Webhook Bot](examples/webhook-bot/) | Xuddi shu echo handler webhook rejimida |
| [Broadcast Bot](examples/broadcast-bot/) | Berilgan userlar ro'yxatiga xabar yuboradi, xatolarni sodda qayta ishlaydi |
| [Media Group Bot](examples/media-group-bot/) | URLlardan foto albom (`/start`) va xotira hamda diskdan fayl yuklash (`/upload`) |
| [Regexp Bot](examples/regexp-bot/) | Item commandlari va deep-link payloadlari uchun regex filterlar |
| [Language Bot](examples/language-bot/) | Userning Telegram til kodini o'qiydi |
| [Proxy Bot](examples/proxy-bot/) | HTTP/SOCKS5 proxy orqali ishlaydigan `TelegramSession` bean |
| [I18n Bot](examples/i18n-bot/) | Lokalizatsiya qilingan javoblar uchun Spring `MessageSource` |
| [Throttling Bot](examples/throttling-bot/) | Middleware orqali antiflood |
| [Payments Bot](examples/payments-bot/) | Invoice yuboradi, shipping va pre-checkout updatelarini qayta ishlaydi |
| [Local Server Bot](examples/local-server-bot/) | Lokal Bot API server uchun sozlanadigan base URL |
| [Updates Bot](examples/updates-bot/) | Poll, reaction, chat member, business, boost, paid media va managed bot updatelari uchun handlerlar |

### Litsenziya

[MIT](LICENSE)

***

## 🇺🇸 English

Jiogram is a Java Spring Boot framework for building Telegram bots. I took the inspiration from Python's [aiogram](https://github.com/aiogram/aiogram).

I adapted aiogram's convenient, annotation-driven handler model to Java/Spring; it runs fully on Project Reactor.

> **This branch (`main`) targets Spring Boot 4.0.x.**
> For Spring Boot 3.5.x see the [`sb3.x` branch](https://github.com/jtscorp/jiogram/tree/sb3.x).
> For Spring Boot 2.7.x see the [`sb2.x` branch](https://github.com/jtscorp/jiogram/tree/sb2.x).
>
> **Maven coordinates:**
> ```
> implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0'
> ```

### Quick Start

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
    implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0'
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
import io.jiogram.types.Message;

@TelegramController
public class EchoBot {

    @OnMessage
    public SendMessage echo(Message message) {
        return SendMessage.answer(message, message.text());
    }
}
```

That's it. Run your Spring Boot app and the bot starts polling for updates automatically.

### Features

- **Annotation-driven handlers:** `@OnMessage`, `@OnCallbackQuery`, `@OnInlineQuery`, `@Command`, `@StateFilter`.
- **Programmatic handler API:** `router.onMessage().filter(Filters.command("start")).handle(...)`.
- **Hierarchical routing:** compose routers with `router.includeRouter(childRouter)`.
- **Built-in filters:** `Filters.command()`, `Filters.text()`, `Filters.regex()`, `Filters.callbackData()`, `Filters.state()`.
- **Composable filters:** `.and()`, `.or()`, `.negate()` on any filter.
- **Middleware pipeline:** intercept and transform updates before they reach handlers.
- **Finite State Machine (FSM):** enum states, generated `@StateFilter` constants, and `FSMContext` for multi-step conversations.
- **Pluggable FSM storage:** in-memory (default) or Redis for distributed deployments.
- **Reactive throughout:** built on Project Reactor (`Mono`/`Flux`); annotated handlers run on virtual threads, so they may block.
- **Auto-return-value handling:** return `SendMessage` from a handler and it gets executed automatically.
- **Request builders:** `SendMessage.answer(message, text)` / `reply(...)` answer into the right chat and forum topic; `of(...)` and `withX(...)` instead of long constructors.
- **File uploads:** `InputFile.fromPath(...)` / `fromBytes(...)` anywhere in a request, sent as multipart automatically.
- **Bot defaults:** parse mode, link previews and content protection filled into every request, nested objects included.
- **Long-polling and webhook modes:** switch with a single config property; polling processes chats in parallel and keeps each chat in order.
- **Graceful shutdown:** a running batch finishes and is confirmed to Telegram before the app stops.
- **Forward compatible:** unknown enum values and union variants from newer Bot API versions do not break parsing.
- **Spring Boot auto-configuration:** just add the starter dependency and a token.

### Module Structure

| Module | Description |
|---|---|
| `jiogram-types` | Generated Java records for all Telegram Bot API types (`Message`, `Update`, `Chat`, etc.) |
| `jiogram-methods` | Generated Java records for all Telegram Bot API methods (`SendMessage`, `GetUpdates`, etc.) |
| `jiogram-core` | Dispatcher, Router, Filters, Middleware, Handler infrastructure, `Bot` class |
| `jiogram-fsm` | Finite State Machine: `@FSMStates`, `BotState`, `FSMContext`, `StateStorage`, `FSMMiddleware` |
| `jiogram-fsm-processor` | Annotation processor generating `<Enum>States` constants for `@FSMStates` enums (use as `annotationProcessor`) |
| `jiogram-spring-boot-starter` | Spring Boot auto-configuration, polling runner, webhook controller |
| `jiogram-codegen` | Code generator that produces `jiogram-types` and `jiogram-methods` from the Bot API schema |

### Requirements

- **Java 25** or newer
- **Spring Boot 4.0.x** (this branch)
- Webhook mode only: a web server, e.g. `spring-boot-starter-webflux` (polling bots need none)

For other Spring Boot versions, see [`docs/spring-boot-versions.md`](docs/spring-boot-versions.md).

### Configuration Reference

All properties live under the `telegram` prefix. See [docs/configuration.md](docs/configuration.md) for the full reference.

| Property | Default | Description |
|---|---|---|
| `telegram.token` | *(required)* | Bot API token from @BotFather |
| `telegram.mode` | `POLLING` | `POLLING` or `WEBHOOK` |
| `telegram.api.base-url` | `https://api.telegram.org` | Telegram Bot API endpoint; set to a local Bot API server URL when self-hosting |
| `telegram.api.request-timeout` | `60s` | Time to wait for a response; `getUpdates` adds its polling timeout |
| `telegram.api.max-response-size` | `16MB` | Largest response that is read |
| `telegram.polling.timeout` | `30` | Long-polling timeout in seconds |
| `telegram.polling.limit` | `100` | Max updates per poll |
| `telegram.polling.backoff` | `1000` | Error backoff in ms |
| `telegram.polling.concurrency` | `32` | Chats of one batch processed in parallel |
| `telegram.polling.shutdown-timeout` | `10s` | How long shutdown waits for the running batch |
| `telegram.webhook.secret-token` | *(from the bot token)* | Checked on every webhook request; derived from the bot token when `webhook.url` is set |
| `telegram.defaults.parse-mode` | `null` | Default parse mode (`HTML`, `MARKDOWN`, `MARKDOWN_V2`) |
| `telegram.handlers.virtual-threads` | `true` | Run annotated handlers on virtual threads |
| `telegram.fsm.enabled` | `true` | Enable FSM middleware |
| `telegram.fsm.strategy` | `USER_IN_CHAT` | FSM key strategy |
| `telegram.fsm.storage` | `memory` | `memory` or `redis` |
| `telegram.fsm.redis.key-prefix` | `jiogram:fsm` | Redis key prefix |
| `telegram.fsm.redis.state-ttl` / `data-ttl` | none | Expire FSM state / data after the last change |

### Documentation

- [Getting Started](docs/getting-started.md)
- [Core Concepts](docs/core-concepts.md)
- [Configuration Reference](docs/configuration.md)

### Examples

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
| [Media Group Bot](examples/media-group-bot/) | Sends a photo album from URLs (`/start`) and uploads files from memory and disk (`/upload`) |
| [Regexp Bot](examples/regexp-bot/) | Uses regex filters for item commands and deep-link payloads |
| [Language Bot](examples/language-bot/) | Reads the user's Telegram language code |
| [Proxy Bot](examples/proxy-bot/) | Provides a `TelegramSession` bean that uses an HTTP/SOCKS5 proxy |
| [I18n Bot](examples/i18n-bot/) | Uses Spring `MessageSource` for localized replies |
| [Throttling Bot](examples/throttling-bot/) | Adds antiflood behavior through middleware |
| [Payments Bot](examples/payments-bot/) | Sends invoices and handles shipping/pre-checkout updates |
| [Local Server Bot](examples/local-server-bot/) | Uses a configurable Bot API base URL for a local Bot API server |
| [Updates Bot](examples/updates-bot/) | Demonstrates update-specific handlers for polls, reactions, chat members, business events, boosts, paid media, and managed bots |

### License

[MIT](LICENSE)
