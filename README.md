# Jiogram

[O'zbekcha](#-ozbekcha) · [English](#-english)

[![Buy Me a Coffee](https://img.shields.io/badge/Buy%20Me%20a%20Coffee-support-yellow?logo=buymeacoffee&logoColor=black)](https://buymeacoffee.com/jtscorp)

***

## 🇺🇿 O'zbekcha

Jiogram — Telegram bot'lar yozish uchun Java Spring Boot framework'i. Python'dagi [aiogram](https://github.com/aiogram/aiogram)'dan ilhomlangan.

U aiogram'ning qulay, annotation'larga asoslangan handler modelini Java/Spring dunyosiga olib keladi va to'liq Project Reactor ustida ishlaydi.

> **Bu branch (`sb2.x`) Spring Boot 2.7.x uchun.**
> Spring Boot 4.x uchun [`main` branch](https://github.com/jtscorp/jiogram/tree/main)'ga qarang.
> Spring Boot 3.5.x uchun [`sb3.x` branch](https://github.com/jtscorp/jiogram/tree/sb3.x)'ga qarang.
>
> **Maven koordinatalari:**
> ```
> implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0'
> ```

### Tez boshlash

**1. build.gradle**

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.18'
    id 'io.spring.dependency-management' version '1.1.7'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

dependencies {
    implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0'
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

Shu bilan tamom. Spring Boot ilovani ishga tushirsangiz, bot update'larni o'zi polling qila boshlaydi.

### Imkoniyatlar

- **Annotation'li handler'lar:** `@OnMessage`, `@OnCallbackQuery`, `@OnInlineQuery`, `@Command`, `@StateFilter`.
- **Kod orqali handler API:** `router.onMessage().filter(Filters.command("start")).handle(...)`.
- **Ierarxik routing:** router'larni `router.includeRouter(childRouter)` bilan birlashtirish mumkin.
- **Tayyor filter'lar:** `Filters.command()`, `Filters.text()`, `Filters.regex()`, `Filters.callbackData()`, `Filters.state()`.
- **Filter'larni birlashtirish:** istalgan filter'da `.and()`, `.or()`, `.negate()`.
- **Middleware pipeline:** update'lar handler'ga yetib borguncha ularni ushlab, o'zgartirish mumkin.
- **FSM (Finite State Machine):** enum state'lar, generate qilingan `@StateFilter` konstantalari va ko'p bosqichli suhbatlar uchun `FSMContext`.
- **FSM storage tanlovi:** xotirada (default) yoki bir nechta instance uchun Redis'da.
- **To'liq reaktiv:** Project Reactor (`Mono`/`Flux`) ustida qurilgan; annotation'li handler'lar virtual thread'larda (Java 21+) yoki bounded elastic pool'da (eskiroq Java) ishlaydi, shuning uchun ular ichida blocking kod yozish mumkin.
- **Qaytarilgan qiymatni bajarish:** handler `SendMessage` qaytarsa, u avtomatik yuboriladi.
- **So'rov yasash:** `SendMessage.answer(message, text)` / `reply(...)` javobni to'g'ri chat va forum topic'ka yuboradi; uzun constructor o'rniga `of(...)` va `withX(...)`.
- **Fayl yuklash:** `InputFile.fromPath(...)` / `fromBytes(...)` so'rovning istalgan joyida; so'rov avtomatik multipart bo'lib ketadi.
- **Bot default'lari:** parse mode, link preview va content protection har bir so'rovga, ichki obyektlarga ham qo'yiladi.
- **Long polling va webhook:** bitta sozlama bilan almashtiriladi; polling chat'larni parallel, har bir chat ichida esa tartib bilan qayta ishlaydi.
- **Ehtiyotkor to'xtash:** ilova to'xtashdan oldin ishlayotgan batch tugaydi va Telegram'ga tasdiqlanadi.
- **Kelajakka mos:** Bot API'ning yangi versiyalaridagi noma'lum enum qiymatlari va union variant'lari parsing'ni buzmaydi.
- **Spring Boot auto-configuration:** starter dependency va token qo'shish kifoya.

### Modullar

| Modul | Vazifasi |
|---|---|
| `jiogram-types` | Telegram Bot API'ning barcha type'lari uchun generate qilingan Java class'lar, record kabi accessor'lar bilan (`Message`, `Update`, `Chat` va h.k.) |
| `jiogram-methods` | Telegram Bot API'ning barcha method'lari uchun generate qilingan Java class'lar, record kabi accessor'lar bilan (`SendMessage`, `GetUpdates` va h.k.) |
| `jiogram-core` | Dispatcher, Router, Filter'lar, Middleware, handler infratuzilmasi, `Bot` klassi |
| `jiogram-fsm` | Finite State Machine: `@FSMStates`, `BotState`, `FSMContext`, `StateStorage`, `FSMMiddleware` |
| `jiogram-fsm-processor` | `@FSMStates` enum'lari uchun `<Enum>States` konstantalarini generate qiladigan annotation processor (`annotationProcessor` sifatida ulanadi) |
| `jiogram-spring-boot-starter` | Spring Boot auto-configuration, polling runner, webhook controller |
| `jiogram-codegen` | Bot API schema'sidan `jiogram-types` va `jiogram-methods`ni yasaydigan kod generatori |

### Talablar

- **Java 11** yoki yangiroq (Java 21+'da handler'lar virtual thread'larda ishlaydi)
- **Spring Boot 2.7.x** (shu branch); uning Gradle plugin'i Gradle 7.5 – 8.x'ni talab qiladi
- Faqat webhook rejimi uchun: web server, masalan `spring-boot-starter-webflux` (polling bot'larga kerak emas)

Boshqa Spring Boot versiyalari uchun [`docs/uz/spring-boot-versions.md`](docs/uz/spring-boot-versions.md)'ga qarang.

### Sozlamalar

Barcha sozlamalar `telegram` prefiksi ostida. To'liq ro'yxat: [docs/uz/configuration.md](docs/uz/configuration.md).

| Sozlama | Default | Tavsif |
|---|---|---|
| `telegram.token` | *(majburiy)* | @BotFather'dan olingan Bot API token |
| `telegram.mode` | `POLLING` | `POLLING` yoki `WEBHOOK` |
| `telegram.api.base-url` | `https://api.telegram.org` | Bot API manzili; o'zingizning Bot API server'ingiz bo'lsa, uning URL'ini qo'ying |
| `telegram.api.request-timeout` | `60s` | Javobni kutish vaqti; `getUpdates`'ga polling timeout'i qo'shiladi |
| `telegram.polling.timeout` | `30` | Long polling timeout'i, soniyada |
| `telegram.polling.limit` | `100` | Bitta poll'dagi eng ko'p update soni |
| `telegram.polling.backoff` | `1000` | Xatodan keyingi kutish, ms |
| `telegram.polling.concurrency` | `32` | Bitta batch'da parallel qayta ishlanadigan chat'lar soni |
| `telegram.polling.shutdown-timeout` | `10s` | To'xtashda ishlayotgan batch qancha kutiladi |
| `telegram.webhook.secret-token` | *(generate qilinadi)* | Har bir webhook so'rovida tekshiriladi; `webhook.url` berilsa, o'zi generate qilinadi |
| `telegram.defaults.parse-mode` | `null` | Default parse mode (`HTML`, `MARKDOWN`, `MARKDOWN_V2`) |
| `telegram.handlers.virtual-threads` | `true` | Annotation'li handler'larni event loop'dan tashqarida ishlatish: Java 21+'da virtual thread'larda, eskiroq Java'da bounded elastic pool'da |
| `telegram.fsm.enabled` | `true` | FSM middleware'ni yoqish |
| `telegram.fsm.strategy` | `USER_IN_CHAT` | FSM key strategiyasi |
| `telegram.fsm.storage` | `memory` | `memory` yoki `redis` |
| `telegram.fsm.redis.key-prefix` | `jiogram:fsm` | Redis key prefiksi |
| `telegram.fsm.redis.state-ttl` / `data-ttl` | yo'q | FSM state / data oxirgi o'zgarishdan shuncha vaqt o'tib o'chadi |

### Hujjatlar

- [Ishni boshlash](docs/uz/getting-started.md)
- [Asosiy tushunchalar](docs/uz/core-concepts.md)
- [Konfiguratsiya ma'lumotnomasi](docs/uz/configuration.md)
- [0.1.x'dan o'tish](docs/uz/migration-from-0.1.x.md)

### Misollar

| Misol | Tavsif |
|---|---|
| [Echo Bot](examples/echo-bot/) | Eng oddiy bot: har qanday matnni qaytaradi |
| [Command Bot](examples/command-bot/) | Command'lar, inline keyboard va callback query'lar |
| [FSM Bot](examples/fsm-bot/) | FSM bilan ko'p bosqichli ro'yxatdan o'tish formasi |
| [Multi-Router Bot](examples/multi-router-bot/) | Handler'larni bir nechta controller klasslariga bo'lish |
| [Programmatic Bot](examples/programmatic-bot/) | Annotation'siz, kod orqali router API |
| [Inline Bot](examples/inline-bot/) | Inline query'larga article natijalari bilan javob beradi |
| [Webhook Bot](examples/webhook-bot/) | Xuddi shu echo handler webhook rejimida |
| [Broadcast Bot](examples/broadcast-bot/) | Berilgan user'lar ro'yxatiga xabar yuboradi, xatolarni sodda qayta ishlaydi |
| [Media Group Bot](examples/media-group-bot/) | URL'lardan foto albom (`/start`) va xotira hamda diskdan fayl yuklash (`/upload`) |
| [Regexp Bot](examples/regexp-bot/) | Item command'lari va deep-link payload'lari uchun regex filter'lar |
| [Language Bot](examples/language-bot/) | User'ning Telegram til kodini o'qiydi |
| [Proxy Bot](examples/proxy-bot/) | HTTP/SOCKS5 proxy orqali ishlaydigan `TelegramSession` bean |
| [I18n Bot](examples/i18n-bot/) | Lokalizatsiya qilingan javoblar uchun Spring `MessageSource` |
| [Throttling Bot](examples/throttling-bot/) | Middleware orqali antiflood |
| [Payments Bot](examples/payments-bot/) | Invoice yuboradi, shipping va pre-checkout update'larini qayta ishlaydi |
| [Local Server Bot](examples/local-server-bot/) | Lokal Bot API server uchun sozlanadigan base URL |
| [Updates Bot](examples/updates-bot/) | Poll, reaction, chat member, business, boost, paid media va managed bot update'lari uchun handler'lar |

### Litsenziya

[MIT](LICENSE)

***

## 🇺🇸 English

A Java Spring Boot framework for building Telegram bots, inspired by Python's [aiogram](https://github.com/aiogram/aiogram).

Jiogram brings the ergonomic, annotation-driven handler model of aiogram to the Java/Spring ecosystem with full reactive support via Project Reactor.

> **This branch (`sb2.x`) targets Spring Boot 2.7.x.**
> For Spring Boot 4.x see the [`main` branch](https://github.com/jtscorp/jiogram/tree/main).
> For Spring Boot 3.5.x see the [`sb3.x` branch](https://github.com/jtscorp/jiogram/tree/sb3.x).
>
> **Maven coordinates:**
> ```
> implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0'
> ```

### Quick Start

**1. build.gradle**

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '2.7.18'
    id 'io.spring.dependency-management' version '1.1.7'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

dependencies {
    implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0'
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

- **Annotation-driven handlers** -- `@OnMessage`, `@OnCallbackQuery`, `@OnInlineQuery`, `@Command`, `@StateFilter`
- **Programmatic handler API** -- `router.onMessage().filter(Filters.command("start")).handle(...)`
- **Hierarchical routing** -- compose routers with `router.includeRouter(childRouter)`
- **Built-in filters** -- `Filters.command()`, `Filters.text()`, `Filters.regex()`, `Filters.callbackData()`, `Filters.state()`
- **Composable filters** -- `.and()`, `.or()`, `.negate()` on any filter
- **Middleware pipeline** -- intercept and transform updates before they reach handlers
- **Finite State Machine (FSM)** -- enum states, generated `@StateFilter` constants, and `FSMContext` for multi-step conversations
- **Pluggable FSM storage** -- in-memory (default) or Redis for distributed deployments
- **Reactive throughout** -- built on Project Reactor (`Mono`/`Flux`); annotated handlers run on virtual threads (Java 21+) or a bounded elastic pool (older Java), so they may block
- **Auto-return-value handling** -- return `SendMessage` from a handler and it gets executed automatically
- **Request builders** -- `SendMessage.answer(message, text)` / `reply(...)` answer into the right chat and forum topic; `of(...)` and `withX(...)` instead of long constructors
- **File uploads** -- `InputFile.fromPath(...)` / `fromBytes(...)` anywhere in a request, sent as multipart automatically
- **Bot defaults** -- parse mode, link previews and content protection filled into every request, nested objects included
- **Long-polling and webhook modes** -- switch with a single config property; polling processes chats in parallel and keeps each chat in order
- **Graceful shutdown** -- a running batch finishes and is confirmed to Telegram before the app stops
- **Forward compatible** -- unknown enum values and union variants from newer Bot API versions do not break parsing
- **Spring Boot auto-configuration** -- just add the starter dependency and a token

### Module Structure

| Module | Description |
|---|---|
| `jiogram-types` | Generated Java classes (record-style accessors) for all Telegram Bot API types (`Message`, `Update`, `Chat`, etc.) |
| `jiogram-methods` | Generated Java classes (record-style accessors) for all Telegram Bot API methods (`SendMessage`, `GetUpdates`, etc.) |
| `jiogram-core` | Dispatcher, Router, Filters, Middleware, Handler infrastructure, `Bot` class |
| `jiogram-fsm` | Finite State Machine: `@FSMStates`, `BotState`, `FSMContext`, `StateStorage`, `FSMMiddleware` |
| `jiogram-fsm-processor` | Annotation processor generating `<Enum>States` constants for `@FSMStates` enums (use as `annotationProcessor`) |
| `jiogram-spring-boot-starter` | Spring Boot auto-configuration, polling runner, webhook controller |
| `jiogram-codegen` | Code generator that produces `jiogram-types` and `jiogram-methods` from the Bot API schema |

### Requirements

- **Java 11** or newer (handlers use virtual threads on Java 21+)
- **Spring Boot 2.7.x** (this branch); its Gradle plugin needs Gradle 7.5 to 8.x
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
| `telegram.polling.timeout` | `30` | Long-polling timeout in seconds |
| `telegram.polling.limit` | `100` | Max updates per poll |
| `telegram.polling.backoff` | `1000` | Error backoff in ms |
| `telegram.polling.concurrency` | `32` | Chats of one batch processed in parallel |
| `telegram.polling.shutdown-timeout` | `10s` | How long shutdown waits for the running batch |
| `telegram.webhook.secret-token` | *(generated)* | Checked on every webhook request; generated when `webhook.url` is set |
| `telegram.defaults.parse-mode` | `null` | Default parse mode (`HTML`, `MARKDOWN`, `MARKDOWN_V2`) |
| `telegram.handlers.virtual-threads` | `true` | Run annotated handlers off the event loop: virtual threads on Java 21+, a bounded elastic pool on older Java |
| `telegram.fsm.enabled` | `true` | Enable FSM middleware |
| `telegram.fsm.strategy` | `USER_IN_CHAT` | FSM key strategy |
| `telegram.fsm.storage` | `memory` | `memory` or `redis` |
| `telegram.fsm.redis.key-prefix` | `jiogram:fsm` | Redis key prefix |
| `telegram.fsm.redis.state-ttl` / `data-ttl` | none | Expire FSM state / data after the last change |

### Documentation

- [Getting Started](docs/getting-started.md)
- [Core Concepts](docs/core-concepts.md)
- [Configuration Reference](docs/configuration.md)
- [Migrating from 0.1.x](docs/migration-from-0.1.x.md)

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
