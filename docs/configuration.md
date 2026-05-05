# Configuration Reference

All Jiogram properties are under the `telegram` prefix in `application.yml` or `application.properties`.

## Full YAML Reference

```yaml
telegram:
  # (Required) Bot API token from @BotFather
  token: "123456789:ABCDEFghijklmnop"

  # Operating mode: POLLING or WEBHOOK (default: POLLING)
  mode: POLLING

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

  # Webhook configuration (only used when mode=WEBHOOK)
  webhook:
    # Public URL where Telegram will send updates (required for webhook mode)
    url: "https://example.com/bot/webhook"
    # Local endpoint path (default: /bot/webhook)
    path: /bot/webhook
    # Secret token for validating incoming requests (optional but recommended)
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
    # Key resolution strategy: USER_IN_CHAT, CHAT, USER, CHAT_TOPIC (default: USER_IN_CHAT)
    strategy: USER_IN_CHAT
    # Storage backend: memory or redis (default: memory)
    storage: memory
```

## Property Details

### telegram.token

**Required.** The bot API token obtained from [@BotFather](https://t.me/BotFather). Without this property, Jiogram auto-configuration will not activate.

You can use environment variable substitution:

```yaml
telegram:
  token: ${BOT_TOKEN}
```

### telegram.mode

Controls how the bot receives updates from Telegram.

| Value | Description |
|---|---|
| `POLLING` | Long-polling via `getUpdates`. Default. No public URL needed. |
| `WEBHOOK` | Telegram pushes updates to your server. Requires a public HTTPS URL. |

### telegram.polling

Only applies when `mode=POLLING`.

| Property | Type | Default | Description |
|---|---|---|---|
| `timeout` | `int` | `30` | Long-polling timeout in seconds. Telegram holds the connection open for this long. |
| `backoff` | `long` | `1000` | Initial backoff delay in ms when a polling error occurs. Exponential backoff up to 30s. |
| `limit` | `int` | `100` | Maximum updates returned per `getUpdates` call. Range: 1-100. |
| `allowed-updates` | `List<UpdateType>` | `null` | Restrict which update types are received. Omit to receive all. |

### telegram.webhook

Only applies when `mode=WEBHOOK`.

| Property | Type | Default | Description |
|---|---|---|---|
| `url` | `String` | `null` | The public HTTPS URL Telegram will POST updates to. |
| `path` | `String` | `/bot/webhook` | The local endpoint path that receives webhook POSTs. |
| `secret-token` | `String` | `null` | If set, Jiogram validates the `X-Telegram-Bot-Api-Secret-Token` header on incoming requests. |
| `max-connections` | `int` | `40` | Max simultaneous connections Telegram will use to deliver updates. |

### telegram.defaults

Default values applied to outgoing bot API requests.

| Property | Type | Default | Description |
|---|---|---|---|
| `parse-mode` | `ParseMode` | `null` | Default parse mode for all outgoing messages (`HTML`, `MARKDOWN`, `MARKDOWN_V2`, or `null`). |
| `protect-content` | `boolean` | `false` | Protect messages from forwarding and saving by default. |
| `link-preview` | `boolean` | `true` | Enable link previews in messages by default. |

### telegram.fsm

Configuration for the Finite State Machine subsystem.

| Property | Type | Default | Description |
|---|---|---|---|
| `enabled` | `boolean` | `true` | When `true`, the `FSMMiddleware` is registered on the dispatcher. Set to `false` to disable FSM. |
| `strategy` | `String` | `USER_IN_CHAT` | How the storage key is resolved. One of: `USER_IN_CHAT`, `CHAT`, `USER`, `CHAT_TOPIC`. |
| `storage` | `String` | `memory` | Storage backend. `memory` uses an in-memory `ConcurrentHashMap`. `redis` uses Spring Data Redis (requires `spring-boot-starter-data-redis` on classpath). |

## Environment Variables

Spring Boot supports environment variable binding. Property names map to environment variables by uppercasing and replacing dots/dashes with underscores:

| Property | Environment Variable |
|---|---|
| `telegram.token` | `TELEGRAM_TOKEN` |
| `telegram.mode` | `TELEGRAM_MODE` |
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
