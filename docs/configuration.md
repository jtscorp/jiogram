# Configuration Reference

All Jiogram properties are under the `telegram` prefix in `application.yml` or `application.properties`.

## Full YAML Reference

```yaml
telegram:
  # (Required) Bot API token from @BotFather
  token: "123456789:ABCDEFghijklmnop"

  # Operating mode: POLLING or WEBHOOK (default: POLLING)
  mode: POLLING

  # Telegram Bot API endpoint configuration
  api:
    # Base URL for the Bot API server (default: https://api.telegram.org)
    # Use http://localhost:8081 when running a local Bot API server.
    base-url: https://api.telegram.org
    # How long to wait for a response; getUpdates adds its polling timeout (default: 60s)
    request-timeout: 60s

  # Polling configuration (only used when mode=POLLING)
  polling:
    # Long-polling timeout in seconds (default: 30)
    timeout: 30
    # Error backoff delay in milliseconds (default: 1000)
    backoff: 1000
    # Maximum number of updates per poll request (default: 100)
    limit: 100
    # List of update types to receive. If omitted, all types are received.
    allowed-updates:
      - message
      - callback_query
      - inline_query
    # Chats processed in parallel per batch; one chat's updates stay in order (default: 32)
    concurrency: 32
    # How long shutdown waits for the batch being processed (default: 10s)
    shutdown-timeout: 10s

  # Webhook configuration (only used when mode=WEBHOOK)
  webhook:
    # Public URL where Telegram will send updates (required for webhook mode)
    url: "https://example.com/bot/webhook"
    # Local endpoint path (default: /bot/webhook)
    path: /bot/webhook
    # Secret token Telegram sends with every update; required unless `url` is set
    # (then a random one is generated and registered via setWebhook)
    secret-token: "your-secret-token"
    # Maximum number of concurrent webhook connections (default: 40)
    max-connections: 40

  # Default properties applied to all outgoing bot requests
  defaults:
    # Default parse mode: HTML, MARKDOWN, MARKDOWN_V2, or null for plain text (default: null)
    parse-mode: HTML
    # Whether to protect content from forwarding by default (default: false)
    protect-content: false
    # Whether to enable link previews by default (default: true)
    link-preview: true

  # FSM (Finite State Machine) configuration
  fsm:
    # Enable or disable FSM support (default: true)
    enabled: true
    # Key resolution strategy: USER_IN_CHAT, CHAT, USER, USER_IN_TOPIC, CHAT_TOPIC (default: USER_IN_CHAT)
    strategy: USER_IN_CHAT
    # Storage backend: memory or redis (default: memory)
    storage: memory
    # Redis storage only
    redis:
      # First segment(s) of every key (default: jiogram:fsm)
      key-prefix: jiogram:fsm
      # Expire a state / data this long after it last changed (default: no expiry)
      state-ttl: 7d
      data-ttl: 7d

  # Handler execution
  handlers:
    # Run annotated handler methods off the event loop, so they may block (default: true)
    virtual-threads: true
```

## Property Details

### telegram.token

**Required.** The bot API token obtained from [@BotFather](https://t.me/BotFather). Without this property, Jiogram auto-configuration will not activate.

You can use environment variable substitution:

```yaml
telegram:
  token: ${BOT_TOKEN}
```

The Bot API puts the token in the request URL (`/bot<token>/sendMessage`). Jiogram keeps it out of
its own log messages and of `JiogramProperties.toString()`, but the HTTP client's DEBUG logging
prints full request URLs. Do not enable DEBUG for
`org.springframework.web.reactive.function.client.ExchangeFunctions` or `reactor.netty.http.client`
in production.

### telegram.mode

Controls how the bot receives updates from Telegram.

| Value | Description |
|---|---|
| `POLLING` | Long-polling via `getUpdates`. Default. No public URL needed. |
| `WEBHOOK` | Telegram pushes updates to your server. Requires a public HTTPS URL. |

The starter does not include a web server, so a polling bot opens no HTTP port. Webhook mode needs
one: add `spring-boot-starter-webflux` (or `spring-boot-starter-web`) to the application, otherwise
startup fails with a message saying so.

### telegram.api

Configures the Bot API server endpoint used for outgoing requests.

| Property | Type | Default | Description |
|---|---|---|---|
| `base-url` | `String` | `https://api.telegram.org` | Base URL of the Telegram Bot API server. Set to a local server URL such as `http://localhost:8081` for self-hosted Bot API deployments. |
| `request-timeout` | `Duration` | `60s` | How long to wait for a response before the request fails with a `TimeoutException`. `getUpdates` gets its long-polling `timeout` on top. Raise it for large uploads on slow links. Applies to the auto-configured session only. |

### telegram.polling

Only applies when `mode=POLLING`.

| Property | Type | Default | Description |
|---|---|---|---|
| `timeout` | `int` | `30` | Long-polling timeout in seconds. Telegram holds the connection open for this long. |
| `backoff` | `long` | `1000` | Initial backoff delay in ms when a polling error occurs. Exponential backoff up to 30s. |
| `limit` | `int` | `100` | Maximum updates returned per `getUpdates` call. Range: 1-100. |
| `allowed-updates` | `List<UpdateType>` | `null` | Restrict which update types are received. Omit to receive all. |
| `concurrency` | `int` | `32` | How many chats of one batch are processed in parallel. Updates of the same chat (or, for inline queries and similar, the same user) always run one after another, in order. The next `getUpdates` call waits for the batch to finish. |
| `shutdown-timeout` | `Duration` | `10s` | On shutdown, how long to wait for the batch being processed. A pending `getUpdates` call is cancelled at once. Processed updates are then confirmed to Telegram, so a restart does not receive them again; a batch that does not finish in time is cancelled and delivered again after the restart. Keep it below `spring.lifecycle.timeout-per-shutdown-phase` (30s by default). |

### telegram.webhook

Only applies when `mode=WEBHOOK`.

| Property | Type | Default | Description |
|---|---|---|---|
| `url` | `String` | `null` | The public HTTPS URL Telegram will POST updates to. |
| `path` | `String` | `/bot/webhook` | The local endpoint path that receives webhook POSTs. |
| `secret-token` | `String` | `null` | Value Telegram must send in the `X-Telegram-Bot-Api-Secret-Token` header; requests without it are rejected with 401. If unset and `url` is set, a random token is generated and registered via `setWebhook`; if both are unset, startup fails. |
| `max-connections` | `int` | `40` | Max simultaneous connections Telegram will use to deliver updates. |

### telegram.defaults

Default values applied to outgoing bot API requests.

| Property | Type | Default | Description |
|---|---|---|---|
| `parse-mode` | `ParseMode` | `null` | Default parse mode (`HTML`, `MARKDOWN`, `MARKDOWN_V2`, or `null`). Filled into every unset `parse_mode` / `*_parse_mode` field of a request, nested objects included: media group captions, inline query results and their message content, poll questions and options, reply quotes. Skipped where the matching `entities` / `caption_entities` field is set, since entities replace the parse mode. |
| `protect-content` | `boolean` | `false` | Protect messages from forwarding and saving by default (sets `protect_content` of sending methods when unset). |
| `link-preview` | `boolean` | `true` | When `false`, unset `link_preview_options` (of `sendMessage`, `editMessageText` and inline `InputTextMessageContent`) are sent with previews disabled. |

### telegram.fsm

Configuration for the Finite State Machine subsystem.

| Property | Type | Default | Description |
|---|---|---|---|
| `enabled` | `boolean` | `true` | When `true`, the `FSMMiddleware` is registered on the dispatcher. Set to `false` to disable FSM. |
| `strategy` | `String` | `USER_IN_CHAT` | How the storage key is resolved. One of: `USER_IN_CHAT`, `CHAT`, `USER`, `USER_IN_TOPIC`, `CHAT_TOPIC`. See [core concepts](core-concepts.md#4-fsm-strategy). |
| `storage` | `String` | `memory` | Storage backend. `memory` uses an in-memory `ConcurrentHashMap`. `redis` uses Spring Data Redis (requires `spring-boot-starter-data-redis` on classpath). |
| `redis.key-prefix` | `String` | `jiogram:fsm` | First segment(s) of every Redis key, e.g. to keep several bots apart in one Redis database. Keys look like `{prefix}:{botId}:{chatId}:{userId}:{threadId}:{destiny}:state` (or `:data`). |
| `redis.state-ttl` | `Duration` | none | Like aiogram's `state_ttl`: a state key expires this long after it was last written. Unset keeps states until cleared. |
| `redis.data-ttl` | `Duration` | none | Like aiogram's `data_ttl`, for the data key. Every write (`setData`, `updateData`) sets the TTL again. |

### telegram.handlers

| Property | Type | Default | Description |
|---|---|---|---|
| `virtual-threads` | `boolean` | `true` | Run each annotated handler method (`@OnMessage`, ...) off the event loop — on a virtual thread on Java 21+, on a bounded elastic pool on older Java — so it may call blocking code (JDBC, blocking HTTP clients, `Mono.block()`). When `false`, handlers run on the Netty event loop and must not block. Handlers registered programmatically with `router.onMessage().handle(...)` are not affected. |

## Environment Variables

Spring Boot supports environment variable binding. Property names map to environment variables by uppercasing and replacing dots/dashes with underscores:

| Property | Environment Variable |
|---|---|
| `telegram.token` | `TELEGRAM_TOKEN` |
| `telegram.mode` | `TELEGRAM_MODE` |
| `telegram.api.base-url` | `TELEGRAM_API_BASE_URL` |
| `telegram.polling.timeout` | `TELEGRAM_POLLING_TIMEOUT` |
| `telegram.fsm.strategy` | `TELEGRAM_FSM_STRATEGY` |
| `telegram.webhook.secret-token` | `TELEGRAM_WEBHOOK_SECRET_TOKEN` |

## Minimal Configuration

The absolute minimum to get a bot running:

```yaml
telegram:
  token: ${BOT_TOKEN}
```

Everything else has sensible defaults: polling mode, 30s timeout, FSM enabled with in-memory storage.
