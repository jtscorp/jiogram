[O'zbekcha](configuration.md) · [English](../configuration.md)

# Konfiguratsiya ma'lumotnomasi

Jiogram'ning barcha property'lari `application.yml` yoki `application.properties` ichida `telegram` prefiksi ostida turadi.

## To'liq YAML namunasi

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

## Property'lar tafsiloti

### telegram.token

**Majburiy.** [@BotFather](https://t.me/BotFather)'dan olingan bot API token'i. Bu property bo'lmasa, Jiogram auto-configuration'i ishga tushmaydi.

Environment variable'dan qiymat olish ham mumkin:

```yaml
telegram:
  token: ${BOT_TOKEN}
```

Bot API token'ni request URL'ining ichiga qo'yadi (`/bot<token>/sendMessage`). Jiogram uni o'z log
xabarlariga ham, `JiogramProperties.toString()` natijasiga ham chiqarmaydi, lekin HTTP client'ning DEBUG
logging'i request URL'larini to'liq chiqaradi. Production'da
`org.springframework.web.reactive.function.client.ExchangeFunctions` yoki `reactor.netty.http.client`
uchun DEBUG'ni yoqmang.

### telegram.mode

Bot Telegram'dan update'larni qanday olishini belgilaydi.

| Qiymat | Tavsif |
|---|---|
| `POLLING` | `getUpdates` orqali long-polling. Default. Public URL kerak emas. |
| `WEBHOOK` | Telegram update'larni o'zi sizning server'ingizga yuboradi. Public HTTPS URL kerak. |

Starter ichida web server yo'q, shuning uchun polling rejimidagi bot hech qanday HTTP port ochmaydi. Webhook
rejimiga esa web server kerak: ilovaga `spring-boot-starter-webflux` (yoki `spring-boot-starter-web`) qo'shing,
aks holda ilova ishga tushmaydi va buni aytib beradigan xabar chiqaradi.

### telegram.api

Chiquvchi request'lar yuboriladigan Bot API server endpoint'ini sozlaydi.

| Property | Tur | Default | Tavsif |
|---|---|---|---|
| `base-url` | `String` | `https://api.telegram.org` | Telegram Bot API server'ining base URL'i. Bot API'ni o'zingiz host qilsangiz, local server URL'ini qo'ying, masalan `http://localhost:8081`. |
| `request-timeout` | `Duration` | `60s` | Javob qancha kutilishi; bu vaqt o'tsa request `TimeoutException` bilan fail bo'ladi. `getUpdates` uchun bunga long-polling `timeout`'i qo'shiladi. Sekin internetda katta fayllarni upload qilish uchun oshiring. Faqat auto-configured session'ga ta'sir qiladi. |

### telegram.polling

Faqat `mode=POLLING` bo'lganda ishlaydi.

| Property | Tur | Default | Tavsif |
|---|---|---|---|
| `timeout` | `int` | `30` | Long-polling timeout'i, sekundlarda. Telegram connection'ni shuncha vaqt ochiq ushlab turadi. |
| `backoff` | `long` | `1000` | Polling'da xato bo'lganda boshlang'ich backoff kechikishi, ms'da. Exponential backoff 30s gacha oshadi. |
| `limit` | `int` | `100` | Bitta `getUpdates` chaqiruvida qaytadigan update'larning maksimal soni. Oraliq: 1-100. |
| `allowed-updates` | `List<UpdateType>` | `null` | Qaysi turdagi update'lar qabul qilinishini cheklaydi. Hammasini olish uchun yozmang. |
| `concurrency` | `int` | `32` | Bitta batch'dagi nechta chat parallel qayta ishlanishi. Bitta chat'ning (inline query va shunga o'xshashlarda esa bitta user'ning) update'lari doim ketma-ket, tartib bilan ishlaydi. Keyingi `getUpdates` chaqiruvi batch tugashini kutadi. |
| `shutdown-timeout` | `Duration` | `10s` | Shutdown paytida qayta ishlanayotgan batch qancha kutilishi. Kutilayotgan `getUpdates` chaqiruvi darhol bekor qilinadi. Keyin qayta ishlangan update'lar Telegram'ga tasdiqlanadi, shuning uchun restart'dan keyin ular qayta kelmaydi; vaqtida tugamagan batch bekor qilinadi va restart'dan keyin qayta yetkaziladi. Buni `spring.lifecycle.timeout-per-shutdown-phase`'dan (default 30s) kichik qiling. |

### telegram.webhook

Faqat `mode=WEBHOOK` bo'lganda ishlaydi.

| Property | Tur | Default | Tavsif |
|---|---|---|---|
| `url` | `String` | `null` | Telegram update'larni POST qiladigan public HTTPS URL. |
| `path` | `String` | `/bot/webhook` | Webhook POST'larini qabul qiladigan local endpoint path'i. |
| `secret-token` | `String` | `null` | Telegram `X-Telegram-Bot-Api-Secret-Token` header'ida yuborishi shart bo'lgan qiymat; usiz kelgan request'lar 401 bilan rad etiladi. Agar bu berilmagan, lekin `url` berilgan bo'lsa, tasodifiy token generate qilinadi va `setWebhook` orqali ro'yxatdan o'tkaziladi; ikkalasi ham berilmagan bo'lsa, ilova ishga tushmaydi. |
| `max-connections` | `int` | `40` | Telegram update'larni yetkazish uchun bir vaqtda ochadigan connection'larning maksimal soni. |

### telegram.defaults

Chiquvchi bot API request'lariga qo'llanadigan default qiymatlar.

| Property | Tur | Default | Tavsif |
|---|---|---|---|
| `parse-mode` | `ParseMode` | `null` | Default parse mode (`HTML`, `MARKDOWN`, `MARKDOWN_V2` yoki `null`). Request'dagi qiymati berilmagan har bir `parse_mode` / `*_parse_mode` field'iga yoziladi, ichki obyektlar ham shunga kiradi: media group caption'lari, inline query natijalari va ularning message content'i, poll savollari va variantlari, reply quote'lar. Mos `entities` / `caption_entities` field'i berilgan joyda yozilmaydi, chunki entity'lar parse mode o'rnini bosadi. |
| `protect-content` | `boolean` | `false` | Default holatda xabarlarni forward qilish va saqlashdan himoya qiladi (yuboruvchi method'larda `protect_content` berilmagan bo'lsa, uni o'rnatadi). |
| `link-preview` | `boolean` | `true` | `false` bo'lsa, berilmagan `link_preview_options` (`sendMessage`, `editMessageText` va inline `InputTextMessageContent`'da) preview o'chirilgan holda yuboriladi. |

### telegram.fsm

Finite State Machine qismining konfiguratsiyasi.

| Property | Tur | Default | Tavsif |
|---|---|---|---|
| `enabled` | `boolean` | `true` | `true` bo'lsa, `FSMMiddleware` dispatcher'da ro'yxatdan o'tkaziladi. FSM'ni o'chirish uchun `false` qiling. |
| `strategy` | `String` | `USER_IN_CHAT` | Storage key qanday aniqlanishi. Quyidagilardan biri: `USER_IN_CHAT`, `CHAT`, `USER`, `USER_IN_TOPIC`, `CHAT_TOPIC`. [Asosiy tushunchalar](core-concepts.md#4-fsm-strategiyasi)'ga qarang. |
| `storage` | `String` | `memory` | Storage backend. `memory` xotiradagi `ConcurrentHashMap`'dan foydalanadi. `redis` Spring Data Redis'dan foydalanadi (classpath'da `spring-boot-starter-data-redis` bo'lishi kerak). |
| `redis.key-prefix` | `String` | `jiogram:fsm` | Har bir Redis key'ining birinchi segment(lar)i, masalan bitta Redis database'da bir nechta bot'ni bir-biridan ajratish uchun. Key'lar `{prefix}:{botId}:{chatId}:{userId}:{threadId}:{destiny}:state` (yoki `:data`) ko'rinishida bo'ladi. |
| `redis.state-ttl` | `Duration` | yo'q | aiogram'dagi `state_ttl` kabi: state key oxirgi marta yozilganidan shuncha vaqt o'tgach expire bo'ladi. Berilmasa, state'lar tozalanmaguncha saqlanadi. |
| `redis.data-ttl` | `Duration` | yo'q | aiogram'dagi `data_ttl` kabi, data key uchun. Har bir yozishda (`setData`, `updateData`) TTL qaytadan o'rnatiladi. |

### telegram.handlers

| Property | Tur | Default | Tavsif |
|---|---|---|---|
| `virtual-threads` | `boolean` | `true` | Har bir annotatsiyali handler method'ini (`@OnMessage`, ...) event loop'dan tashqarida ishga tushiradi: Java 21+'da virtual thread'da, Java 17'da bounded elastic pool'da, shuning uchun u blocking code chaqirishi mumkin (JDBC, blocking HTTP client'lar, `Mono.block()`). `false` bo'lsa, handler'lar Netty event loop'ida ishlaydi va block qilmasligi kerak. `router.onMessage().handle(...)` orqali kod bilan ro'yxatdan o'tkazilgan handler'larga ta'sir qilmaydi. |

## Environment variable'lar

Spring Boot environment variable binding'ni qo'llab-quvvatlaydi. Property nomi environment variable'ga shunday o'giriladi: harflar katta qilinadi, nuqta va chiziqchalar underscore bilan almashtiriladi:

| Property | Environment variable |
|---|---|
| `telegram.token` | `TELEGRAM_TOKEN` |
| `telegram.mode` | `TELEGRAM_MODE` |
| `telegram.api.base-url` | `TELEGRAM_API_BASE_URL` |
| `telegram.polling.timeout` | `TELEGRAM_POLLING_TIMEOUT` |
| `telegram.fsm.strategy` | `TELEGRAM_FSM_STRATEGY` |
| `telegram.webhook.secret-token` | `TELEGRAM_WEBHOOK_SECRET_TOKEN` |

## Minimal konfiguratsiya

Bot ishga tushishi uchun eng kami:

```yaml
telegram:
  token: ${BOT_TOKEN}
```

Qolgan hammasining o'rinli default qiymatlari bor: polling rejimi, 30s timeout, xotirada saqlanadigan FSM yoqilgan.
