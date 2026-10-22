[O'zbekcha](uz/migration-from-0.1.x.md) · [English](migration-from-0.1.x.md)

# Migrating from jiogram 0.1.0 to 0.2.0

`jiogram` 0.2.0 is a hard break from 0.1.0. The single artifact `uz.jtscorp.jiogram:jiogram-spring-boot-starter` is **frozen**: it will not receive 0.2.0 or any later updates. To upgrade, switch your dependency to the new branch-specific starter that matches your Spring Boot version.

## What changed

| Concern | 0.1.0 (frozen) | 0.2.0 |
|---|---|---|
| GroupId | `uz.jtscorp.jiogram` | `uz.jtscorp.jiogram` (unchanged) |
| Single starter artifact | `jiogram-spring-boot-starter` | three starters: `jiogram-spring-boot-{2,3,4}-starter` |
| Module artifacts | `jiogram-core`, `jiogram-fsm`, etc. | `jiogram-core-sb{2,3,4}`, `jiogram-fsm-sb{2,3,4}`, etc. |
| Spring Boot supported | 3.5 only | 2.7, 3.5, and 4.0 |
| Java baseline | 25 (preview features required) | 11 on sb2.x, 17 on sb3.x, 25 on main |

Most handler, filter, FSM and middleware code carries over unchanged, but 0.2.0 also fixes
behaviour that was wrong in 0.1.0 and changes a few APIs. Read
[Behaviour and API changes](#behaviour-and-api-changes) before upgrading.

## Step-by-step upgrade

### 1. Identify your Spring Boot version

```bash
./gradlew dependencyInsight --dependency org.springframework.boot:spring-boot --configuration runtimeClasspath
```

The output shows the Spring Boot version your project resolves.

### 2. Pick the matching starter

| Spring Boot | New starter coordinate |
|---|---|
| 2.7.x | `uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0` |
| 3.5.x | `uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0` |
| 4.0.x | `uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0` |

### 3. Update your `build.gradle`

Replace:

```groovy
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-starter:0.1.0'
```

With (e.g. for Spring Boot 3.5):

```groovy
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0'
```

### 4. Set the Java toolchain for your target branch

The Spring Boot 4 starter on `main` targets Java 25:

```groovy
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
```

The Spring Boot 2.7 and 3.5 branches keep their lower Java baseline; use the version documented on the branch you consume.

### 5. Build and test

```bash
./gradlew clean build
```

If you see compile errors, check the list below; anything not listed there is an API drift we
did not document, so please open an issue.

## Behaviour and API changes

### Changes that can break an application

| Area | 0.1.0 | 0.2.0 | What to do |
|---|---|---|---|
| Webhook secret | optional | required: `telegram.webhook.secret-token`, or generated when `telegram.webhook.url` is set; requests without it get `401` | set a secret, or let the starter register the webhook |
| Web server | the starter pulled in WebFlux, so every bot opened an HTTP port | the starter has no web server; polling bots open no port | for webhook mode add `spring-boot-starter-webflux` (or `-web`) |
| HTTP client | a `WebClient` bean of the application was used for Telegram calls | the Telegram session builds its own client (with Boot's `WebClient.Builder` customizers) | customize by defining your own `TelegramSession` bean |
| `InputMedia*.media` | `String` | `InputFileOrString` | wrap with `InputFileOrString.of(...)`; a local file can now be uploaded |
| `InlineQueryResultType` | had `CACHED_*` constants | removed; a cached result sends the same `type` as the plain one | use `PHOTO`, `GIF`, ... |
| Unions and enums | an unknown value failed parsing of the whole update | parsed as `XxxUnknown` / `UNKNOWN` | exhaustive `switch`es over a union need a case for its `Unknown` variant |
| `FSMStrategy.CHAT_TOPIC` | one state per user in a topic | one state per topic, shared by its users (as in aiogram) | for the old behaviour use the new `USER_IN_TOPIC` |
| Nested state enums | named by simple name, so equal names collided | named by the nested class chain within the package | states stored under old names do not match after the upgrade |
| Per-user FSM strategies | updates without a user (channel posts, reaction counts) got a key with user 0 | FSM is skipped for them; `state` is absent from the context | none, unless handlers relied on that shared key |
| FSM annotation processor | part of `jiogram-fsm` | own artifact | `annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb4:<version>'` |
| Default parse mode | added to the top-level `parse_mode` only, even next to `entities` | added to every `parse_mode` / `*_parse_mode`, nested objects included, but not where entities are given | none; drop manual `parse_mode` you set only to reach captions |

### Other behaviour changes

- Handler order: `@Order`, then `@Command` handlers, then other filtered handlers, then
  catch-all ones. A command such as `/cancel` is no longer swallowed by a state handler.
- `/start@OtherBot` in a group is ignored; a command in a media caption matches.
- Polling processes the chats of one batch in parallel (`telegram.polling.concurrency`, 32);
  updates of one chat still run in order. Annotated handlers run on virtual threads
  (`telegram.handlers.virtual-threads`).
- Stopping the application lets the running batch finish (`telegram.polling.shutdown-timeout`)
  and confirms it to Telegram, so a restart does not receive it again.
- Requests time out after `telegram.api.request-timeout` (60s) instead of waiting forever.
- Methods that return "Message or True" (`editMessageText`, ...) complete empty for inline
  messages instead of failing.
- Redis FSM keys of business messages get a `bc=<connection id>` segment; other keys keep their
  format.

## New in 0.2.0

- `SendMessage.answer(message, text)` / `reply(...)` (on every sending method) answer into the
  message's chat, forum topic, business connection or direct messages topic.
- `of(...)` with the required values and `withX(...)` for the rest, on every method and type:
  `SendDocument.answer(message, file).withCaption("<b>Report</b>")`.
- File uploads with `InputFile.fromPath(...)` / `fromBytes(...)`, anywhere in a request.
- Redis storage settings `telegram.fsm.redis.key-prefix`, `state-ttl`, `data-ttl`.
- Javadoc from the Bot API documentation on generated types and methods.

## Why the hard break

`jiogram` 0.1.0 was a single-artifact preview that required Spring Boot 3.5 and Java 25 with preview features. Supporting older Spring Boot versions required either runtime detection (fragile) or republishing under a new naming scheme (clean). We chose the latter and froze the old artifact rather than evolve it in place.

The 0.2.0 release line will receive bug fixes and Telegram Bot API updates simultaneously across all three branches via a lockstep release.
