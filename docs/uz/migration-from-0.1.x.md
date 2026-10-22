[O'zbekcha](migration-from-0.1.x.md) · [English](../migration-from-0.1.x.md)

# jiogram 0.1.0 dan 0.2.0 ga o'tish

`jiogram` 0.2.0 0.1.0 bilan to'liq mos emas (hard break). Yagona `uz.jtscorp.jiogram:jiogram-spring-boot-starter` artifact'i **muzlatilgan**: u 0.2.0 ni ham, undan keyingi yangilanishlarni ham olmaydi. Yangilash uchun dependency'ni Spring Boot versiyangizga mos keladigan yangi, branch'ga xos starter'ga almashtiring.

## Nimalar o'zgardi

| Nima | 0.1.0 (muzlatilgan) | 0.2.0 |
|---|---|---|
| GroupId | `uz.jtscorp.jiogram` | `uz.jtscorp.jiogram` (o'zgarmagan) |
| Yagona starter artifact | `jiogram-spring-boot-starter` | uchta starter: `jiogram-spring-boot-{2,3,4}-starter` |
| Modul artifact'lari | `jiogram-core`, `jiogram-fsm` va h.k. | `jiogram-core-sb{2,3,4}`, `jiogram-fsm-sb{2,3,4}` va h.k. |
| Qo'llab-quvvatlanadigan Spring Boot | faqat 3.5 | 2.7, 3.5 va 4.0 |
| Java baseline | 25 (preview features kerak) | sb2.x'da 11, sb3.x'da 17, main'da 25 |

Handler, filter, FSM va middleware kodining ko'p qismi o'zgarishsiz ishlayveradi, lekin 0.2.0
0.1.0 dagi noto'g'ri ishlashlarni ham tuzatadi va bir nechta API'ni o'zgartiradi. Yangilashdan
oldin [Ishlash tartibi va API o'zgarishlari](#ishlash-tartibi-va-api-ozgarishlari) bo'limini o'qing.

## Bosqichma-bosqich yangilash

### 1. Spring Boot versiyangizni aniqlang

```bash
./gradlew dependencyInsight --dependency org.springframework.boot:spring-boot --configuration runtimeClasspath
```

Natijada loyihangiz ishlatadigan Spring Boot versiyasi ko'rinadi.

### 2. Mos starter'ni tanlang

| Spring Boot | Yangi starter coordinate'i |
|---|---|
| 2.7.x | `uz.jtscorp.jiogram:jiogram-spring-boot-2-starter:0.2.0` |
| 3.5.x | `uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0` |
| 4.0.x | `uz.jtscorp.jiogram:jiogram-spring-boot-4-starter:0.2.0` |

### 3. `build.gradle` faylini yangilang

Buni:

```groovy
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-starter:0.1.0'
```

Bunga almashtiring (masalan, Spring Boot 3.5 uchun):

```groovy
implementation 'uz.jtscorp.jiogram:jiogram-spring-boot-3-starter:0.2.0'
```

### 4. Tanlangan branch uchun Java toolchain'ni sozlang

`main` branch'idagi Spring Boot 4 starter'i Java 25 uchun mo'ljallangan:

```groovy
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}
```

Spring Boot 2.7 va 3.5 branch'lari o'zining pastroq Java baseline'ida qoladi; siz ishlatayotgan branch'da ko'rsatilgan versiyani oling.

### 5. Build va test qiling

```bash
./gradlew clean build
```

Compile xatolari chiqsa, quyidagi ro'yxatni tekshiring. U yerda yo'q narsa biz hujjatlashtirmagan
API farqi bo'ladi, shuning uchun iltimos issue oching.

## Ishlash tartibi va API o'zgarishlari

### Ilovani buzishi mumkin bo'lgan o'zgarishlar

| Soha | 0.1.0 | 0.2.0 | Nima qilish kerak |
|---|---|---|---|
| Webhook secret | ixtiyoriy | majburiy: `telegram.webhook.secret-token`, yoki `telegram.webhook.url` berilgan bo'lsa avtomatik generate qilinadi; secret'siz request'lar `401` oladi | secret belgilang yoki webhook'ni starter o'zi ro'yxatdan o'tkazsin |
| Web server | starter WebFlux'ni olib kirardi, shuning uchun har bir bot HTTP port ochardi | starter'da web server yo'q; polling bot'lar port ochmaydi | webhook rejimi uchun `spring-boot-starter-webflux` (yoki `-web`) qo'shing |
| HTTP client | Telegram chaqiruvlari uchun ilovaning `WebClient` bean'i ishlatilardi | Telegram session o'z client'ini yaratadi (Boot'ning `WebClient.Builder` customizer'lari bilan) | sozlash uchun o'zingizning `TelegramSession` bean'ingizni e'lon qiling |
| `InputMedia*.media` | `String` | `InputFileOrString` | `InputFileOrString.of(...)` bilan o'rang; endi lokal faylni ham upload qilish mumkin |
| `InlineQueryResultType` | `CACHED_*` konstantalari bor edi | olib tashlandi; cached result oddiy result bilan bir xil `type` yuboradi | `PHOTO`, `GIF`, ... ishlating |
| Union'lar va enum'lar | noma'lum qiymat butun update'ning parse qilinishini buzardi | `XxxUnknown` / `UNKNOWN` sifatida parse qilinadi | union bo'yicha exhaustive `switch`'larga uning `Unknown` varianti uchun case kerak |
| `FSMStrategy.CHAT_TOPIC` | topic ichida har bir user uchun bitta state | har bir topic uchun bitta state, uning user'lari uchun umumiy (aiogram'dagidek) | eski xatti-harakat kerak bo'lsa, yangi `USER_IN_TOPIC`'ni ishlating |
| Nested state enum'lar | simple name bo'yicha nomlanardi, shuning uchun bir xil nomlar to'qnashardi | package ichidagi nested class zanjiri bo'yicha nomlanadi | eski nomlar bilan saqlangan state'lar yangilangandan keyin mos kelmaydi |
| Per-user FSM strategiyalari | user'siz update'lar (channel post'lar, reaction count'lar) user 0 bilan key olardi | ular uchun FSM o'tkazib yuboriladi; context'da `state` bo'lmaydi | hech narsa, agar handler'lar o'sha umumiy key'ga tayanmagan bo'lsa |
| FSM annotation processor | `jiogram-fsm` ichida edi | alohida artifact | `annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb4:<version>'` |
| Default parse mode | faqat top-level `parse_mode`'ga qo'shilardi, hatto `entities` yonida ham | barcha `parse_mode` / `*_parse_mode`'larga, nested object'larnikiga ham qo'shiladi, lekin entities berilgan joyga qo'shilmaydi | hech narsa; faqat caption'larga yetkazish uchun qo'lda qo'ygan `parse_mode`'ingizni olib tashlang |

### Ishlash tartibidagi boshqa o'zgarishlar

- Handler'lar tartibi: avval `@Order`, keyin `@Command` handler'lar, keyin filter'li boshqa handler'lar,
  oxirida catch-all'lar. Endi `/cancel` kabi command'ni state handler yutib yubormaydi.
- Group'da `/start@OtherBot` e'tiborsiz qoldiriladi; media caption'dagi command esa match qiladi.
- Polling bitta batch'dagi chat'larni parallel qayta ishlaydi (`telegram.polling.concurrency`, 32);
  bitta chat'ning update'lari esa avvalgidek tartib bilan ishlaydi. Annotation'li handler'lar virtual
  thread'larda ishlaydi (`telegram.handlers.virtual-threads`).
- Ilova to'xtatilganda ishlayotgan batch oxirigacha bajariladi (`telegram.polling.shutdown-timeout`)
  va Telegram'ga tasdiqlanadi, shuning uchun restart'dan keyin u qayta kelmaydi.
- Request'lar cheksiz kutib qolmaydi, `telegram.api.request-timeout` (60s) dan keyin timeout bo'ladi.
- "Message or True" qaytaradigan method'lar (`editMessageText`, ...) inline message'lar uchun xato
  bermaydi, bo'sh complete bo'ladi.
- Business message'larning Redis FSM key'lariga `bc=<connection id>` segmenti qo'shiladi; boshqa
  key'larning formati o'zgarmaydi.

## 0.2.0 versiyadagi yangiliklar

- `SendMessage.answer(message, text)` / `reply(...)` (har bir yuborish method'ida) javobni
  message'ning chat'iga, forum topic'iga, business connection'iga yoki direct messages topic'iga yuboradi.
- Har bir method va type'da majburiy qiymatlar uchun `of(...)` va qolganlari uchun `withX(...)`:
  `SendDocument.answer(message, file).withCaption("<b>Report</b>")`.
- `InputFile.fromPath(...)` / `fromBytes(...)` bilan file upload, request'ning istalgan joyida.
- Redis storage sozlamalari `telegram.fsm.redis.key-prefix`, `state-ttl`, `data-ttl`.
- Generate qilingan type va method'larda Bot API hujjatidan olingan Javadoc.

## Nega eski versiya bilan moslik uzildi

`jiogram` 0.1.0 bitta artifact'dan iborat preview edi va Spring Boot 3.5 hamda preview features yoqilgan Java 25 talab qilardi. Eskiroq Spring Boot versiyalarini qo'llab-quvvatlash uchun yo runtime'da aniqlash (mo'rt yo'l), yo yangi nomlash sxemasi bilan qayta publish qilish (toza yo'l) kerak edi. Biz ikkinchisini tanladik va eski artifact'ni joyida rivojlantirish o'rniga uni muzlatdik.

0.2.0 release line bug fix'lar va Telegram Bot API yangilanishlarini lockstep release orqali uchala branch'da bir vaqtda oladi.
