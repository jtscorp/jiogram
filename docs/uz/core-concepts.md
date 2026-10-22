[O'zbekcha](core-concepts.md) · [English](../core-concepts.md)

# Asosiy tushunchalar

## Bot

`Bot` class Telegram bot token'i va API chaqiruvlari uchun `TelegramSession`'ni o'z ichiga oladi.

```java
import io.jiogram.bot.Bot;
import io.jiogram.methods.SendMessage;

// In a handler, Bot is injected automatically:
@OnMessage
public Mono<Void> greet(Message message, Bot bot) {
    return bot.execute(SendMessage.answer(message, "Hello!")).then();
}
```

### Xabarga javob berish

Chat'ga biror narsa yuboradigan har bir method'da (`SendMessage`, `SendPhoto`, `SendMediaGroup`,
`SendPoll`, `CopyMessage`, `SendChatAction`, ...) ikkita factory bor. Ular javob qayerga borishini
kelgan xabarning o'zidan aniqlaydi, xuddi aiogram'dagi `message.answer()` va `message.reply()` kabi:

```java
SendMessage.answer(message, "Hi");       // to the message's chat
SendPhoto.reply(message, photo);         // the same, as a reply to the message
```

Ular chat'ni, forum topic'ni (faqat xabar topic ichida bo'lsa), business connection'ni va direct
messages topic'ni o'zi to'ldiradi. Buning o'rniga `SendMessage.of(ChatId.of(chatId), text)`
ishlatilsa, forum guruhidagi javob General topic'ga tushadi.

### Request'larni tuzish

Method'lar va type'lar record'lar bo'lib, ularning canonical constructor'i Bot API'ning barcha
field'larini qabul qiladi. Optional field'lar uchun qisqaroq yo'llar bor: `of(...)` faqat majburiy
qiymatlarni oladi, har bir record'da esa har bir field uchun `withX(...)` bor. U shu qiymat
o'rnatilgan nusxani qaytaradi.

```java
var keyboard = new InlineKeyboardMarkup(List.of(List.of(
    InlineKeyboardButton.of("About").withCallbackData("about"),
    InlineKeyboardButton.of("Docs").withUrl("https://core.telegram.org/bots/api"))));

bot.execute(SendDocument.answer(message, InputFileOrString.of(InputFile.fromPath(report)))
    .withCaption("<b>Report</b>")
    .withReplyMarkup(keyboard));
```

`InputFile.fromPath(...)` va `InputFile.fromBytes(name, bytes)` ilovaning o'zidan fayl upload
qiladi. Ularni Bot API fayl qabul qiladigan istalgan joyda, jumladan media group ichida ham
ishlatish mumkin. Bunda request `multipart/form-data` sifatida yuboriladi. Union subtype'lar
o'zining `type`'ini o'zi to'ldiradi: `InputMediaPhoto.of(media)` allaqachon photo hisoblanadi.

Spring Boot auto-configuration bilan `Bot` bean'i `telegram.token` property'sidan yaratiladi. Uni istalgan joyga inject qilish ham mumkin:

```java
@Service
public class NotificationService {
    private final Bot bot;

    public NotificationService(Bot bot) {
        this.bot = bot;
    }

    public Mono<Void> notify(long chatId, String text) {
        return bot.execute(SendMessage.of(ChatId.of(chatId), text)).then();
    }
}
```

### DefaultBotProperties

Default parse mode, content protection va link preview xatti-harakatini sozlash:

```yaml
telegram:
  defaults:
    parse-mode: HTML
    protect-content: false
    link-preview: true
```

Ular request'dagi siz bo'sh qoldirgan har bir field'ga qo'yiladi, ichma-ich field'larga ham
(masalan, media group caption'lari yoki inline query natijalari). O'zingiz bergan field hech qachon
o'zgartirilmaydi, entity'lari bilan kelgan text'ga esa default parse mode qo'yilmaydi. Bu
qiymatlarni `bot.defaults()` orqali olish mumkin.

---

## Router

`Router` event'larni ierarxik tarzda yo'naltiradi. `Dispatcher` — bu root vazifasini bajaradigan va middleware qo'llab-quvvatlashini qo'shadigan maxsus Router.

### Ierarxik routing

```java
Router adminRouter = new Router("admin");
Router userRouter = new Router("user");

// The dispatcher tries its own handlers first,
// then propagates unhandled events to sub-routers in order.
dispatcher.includeRouter(adminRouter);
dispatcher.includeRouter(userRouter);
```

Event'lar depth-first tarqaladi: avval dispatcher'ning o'z handler'lari tekshiriladi. Ularning hech biri mos kelmasa, sub-router'lar ro'yxatdan o'tkazilgan tartibda sinab ko'riladi.

### Annotation'lar bilan

`@TelegramController` ishlatilganda handler'lar root `Dispatcher`'da ro'yxatdan o'tadi (u ham `Router`). Handler method'lar har bir class'da yozilgan tartibda sinab ko'riladi. Bir nechta controller class kerak bo'lsa, ularning hammasi bitta dispatcher'da ro'yxatdan o'tadi:

```java
@TelegramController
public class AdminHandlers {
    @OnMessage
    @Command("ban")
    public SendMessage ban(Message message) { /* ... */ }
}

@TelegramController
public class UserHandlers {
    @OnMessage
    @Command("start")
    public SendMessage start(Message message) { /* ... */ }
}
```

---

## Handler'lar

### Annotation asosidagi handler'lar

`@TelegramController` class ichidagi method'larga `@OnMessage`, `@OnCallbackQuery` yoki `@OnInlineQuery` qo'ying.

```java
@TelegramController
public class MyHandlers {

    @OnMessage
    @Command("start")
    public SendMessage onStart(Message message) {
        return SendMessage.answer(
            message,
            "Welcome!"
        );
    }

    @OnCallbackQuery(data = "confirm")
    public AnswerCallbackQuery onConfirm(CallbackQuery callback) {
        return AnswerCallbackQuery.of(callback.id());
    }

    @OnCallbackQuery(prefix = "page_")
    public AnswerCallbackQuery onPage(CallbackQuery callback, Bot bot) {
        String page = callback.data(); // e.g., "page_2"
        // ... handle pagination
        return AnswerCallbackQuery.of(callback.id());
    }

    @OnInlineQuery
    public Mono<Void> onInline(InlineQuery query, Bot bot) {
        // Handle inline query
        return Mono.empty();
    }
}
```

#### Method parametrlariga inject qilish

Handler method'lar quyidagi parametr type'larini istalgan tartibda e'lon qilishi mumkin:

| Type | Nima inject qilinadi |
|---|---|
| `Message` | Kelgan xabar (`@OnMessage` uchun) |
| `CallbackQuery` | Callback query (`@OnCallbackQuery` uchun) |
| `InlineQuery` | Inline query (`@OnInlineQuery` uchun) |
| `Bot` | Bot instance'i |
| `UpdateContext` | Shu update'ning context map'i |

#### Return qiymatini qayta ishlash

| Return type | Xatti-harakat |
|---|---|
| `SendMessage`, `AnswerCallbackQuery` yoki istalgan `TelegramMethod<?>` | `bot.execute()` orqali avtomatik bajariladi |
| `Mono<TelegramMethod<?>>` | Ochiladi va avtomatik bajariladi |
| `Mono<Void>` | To'g'ridan-to'g'ri subscribe qilinadi |
| `void` yoki `null` | Hech narsa qilinmaydi (no-op) |

### Programmatic handler'lar

Kodda e'lon qilinadigan handler'lar uchun `Router`'dagi fluent builder API'dan foydalaning:

```java
@Configuration
public class BotConfig {

    @Bean
    public Router customRouter(Dispatcher dispatcher) {
        Router router = new Router("custom");

        router.onMessage()
            .filter(Filters.command("ping"))
            .handle((message, context) -> {
                var reply = SendMessage.answer(
                    message,
                    "pong!"
                );
                return context.bot().execute(reply).then();
            });

        router.onCallbackQuery()
            .filter(Filters.callbackData("yes"))
            .handle((callback, context) -> {
                var answer = AnswerCallbackQuery.of(callback.id());
                return context.bot().execute(answer).then();
            });

        dispatcher.includeRouter(router);
        return router;
    }
}
```

---

## Filter'lar

Filter'lar handler berilgan event'ni qayta ishlashi kerakmi yoki yo'qligini hal qiladi. Ular `FilterResult.passed()` yoki `FilterResult.failed()` qaytaradi.

### Tayyor filter'lar

```java
// Match specific commands (without leading slash), in the text or a media caption
Filters.command("start", "help")

// Match exact text
Filters.text("Hello")

// Match text prefix
Filters.textStartsWith("/custom_")

// Match regex pattern
Filters.regex("\\d{4}-\\d{2}-\\d{2}")

// Match exact callback data
Filters.callbackData("confirm")

// Match callback data prefix
Filters.callbackDataPrefix("page_")

// Match FSM state
Filters.state("FormState.WAITING_FOR_NAME")
```

### Filter'larni birlashtirish

Filter'larda `.and()`, `.or()` va `.negate()` bor:

```java
// Match messages that are commands AND in a specific state
Filter<Message> filter = Filters.command("next")
    .and(Filters.state("FormState.WAITING_FOR_INPUT"));

// Match either of two callback data values
Filter<CallbackQuery> either = Filters.callbackData("yes")
    .or(Filters.callbackData("no"));

// Match anything that is NOT a command
Filter<Message> notCommand = Filters.command().negate();
```

### Custom filter'lar

`Filter<E>` functional interface'ini implement qiling:

```java
Filter<Message> photoFilter = (message, context) -> {
    if (message.photo() != null && !message.photo().isEmpty()) {
        return Mono.just(FilterResult.passed());
    }
    return Mono.just(FilterResult.failed());
};
```

Filter'lar `UpdateContext`'ga qo'shiladigan ma'lumot ham biriktirishi mumkin:

```java
Filter<Message> extractEmail = (message, context) -> {
    String text = message.text();
    if (text != null && text.contains("@")) {
        return Mono.just(FilterResult.passed(Map.of("email", text)));
    }
    return Mono.just(FilterResult.failed());
};
```

Custom filter'larni programmatic API bilan ishlating:

```java
router.onMessage()
    .filter(photoFilter)
    .handle((message, context) -> {
        // This only runs for messages with photos
        return Mono.empty();
    });
```

### Annotation filter'lar

`@Command` va `@StateFilter` — `Filters.command()` va `Filters.state()` ustidan yozilgan annotation'lar:

```java
@OnMessage
@Command("start")              // same as Filters.command("start")
@StateFilter("Form.IDLE")      // same as Filters.state("Form.IDLE")
public SendMessage handler(Message message) { /* ... */ }
```

Generate qilingan constant'lari bo'lmagan enum asosidagi FSM state'lar uchun `enumClass`'dan foydalaning, shunda enum type chaqiruv joyida ko'rinib turadi:

```java
@OnMessage
@StateFilter(enumClass = FormState.class, value = "IDLE")
public SendMessage handler(Message message) { /* ... */ }
```

`@OnCallbackQuery`'da tayyor `data` va `prefix` attribute'lari bor:

```java
@OnCallbackQuery(data = "confirm")      // same as Filters.callbackData("confirm")
@OnCallbackQuery(prefix = "page_")      // same as Filters.callbackDataPrefix("page_")
```

---

## Middleware

Middleware event'ni qayta ishlashning butun pipeline'ini o'rab oladi. Har bir middleware event'ni, context'ni va keyingi middleware'ni (yoki oxirgi handler'ni) chaqirish uchun chain'ni oladi.

### Custom middleware yozish

```java
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.middleware.Middleware;
import io.jiogram.middleware.MiddlewareChain;
import reactor.core.publisher.Mono;

public class LoggingMiddleware implements Middleware {

    @Override
    public Mono<Void> process(Object event, UpdateContext context, MiddlewareChain chain) {
        long start = System.currentTimeMillis();
        return chain.next(event, context)
            .doFinally(signal -> {
                long duration = System.currentTimeMillis() - start;
                System.out.println("Update " + context.update().updateId()
                    + " processed in " + duration + "ms");
            });
    }
}
```

### Middleware'ni ro'yxatdan o'tkazish

```java
@Bean
public Dispatcher dispatcher() {
    Dispatcher dispatcher = new Dispatcher();
    dispatcher.addOuterMiddleware(new ErrorMiddleware());   // built-in error handler
    dispatcher.addOuterMiddleware(new LoggingMiddleware()); // your custom middleware
    return dispatcher;
}
```

Middleware'lar ro'yxatdan o'tkazilgan tartibda bajariladi. Tayyor `ErrorMiddleware` exception'larni ushlab, log'ga yozadi, shunda bitta update'dagi xato polling loop'ni to'xtatib qo'ymaydi.

### Tayyor middleware'lar

| Middleware | Tavsif |
|---|---|
| `ErrorMiddleware` | Handler exception'larini ushlaydi va log'ga yozadi (default qo'shilgan) |
| `FSMMiddleware` | FSM state'ni aniqlaydi va `FSMContext`'ni `UpdateContext`'ga inject qiladi (FSM yoqilganda qo'shiladi) |

---

## FSM (Finite State Machine)

FSM bilan bir necha qadamli suhbatlar qurish mumkin: bot har bir user qaysi qadamda turganini eslab qoladi.

### 1. State'larni e'lon qilish

Enum yarating va unga `@FSMStates` qo'ying:

```java
import io.jiogram.fsm.FSMStates;

@FSMStates
public enum FormState {
    WAITING_FOR_NAME,
    WAITING_FOR_AGE,
    CONFIRM
}
```

Har bir constant `"FormState.WAITING_FOR_NAME"` kabi state nomi sifatida saqlanadi va solishtiriladi.
`@FSMStates` annotation'larda ishlatish uchun `FormStateStates` constant'larini ham generate qiladi.

Processor'ni Gradle'da yoqing. U dependency'larsiz alohida artifact (`@FSMStates`
annotation'ining o'zi `jiogram-fsm` bilan keladi):

```groovy
dependencies {
    annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb4:0.2.0-SNAPSHOT'
}
```

### 2. Handler'larda @StateFilter ishlatish

```java
@TelegramController
public class RegistrationBot {

    @OnMessage
    @Command("register")
    public Mono<Void> startRegistration(Message message, Bot bot, UpdateContext context) {
        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm.setState(FormState.WAITING_FOR_NAME)
            .then(bot.execute(SendMessage.answer(
                message,
                "What is your name?"
            )))
            .then();
    }

    @OnMessage
    @StateFilter(FormStateStates.WAITING_FOR_NAME)
    public Mono<Void> processName(Message message, Bot bot, UpdateContext context) {
        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm.updateData("name", message.text())
            .then(fsm.setState(FormState.WAITING_FOR_AGE))
            .then(bot.execute(SendMessage.answer(
                message,
                "How old are you?"
            )))
            .then();
    }

    @OnMessage
    @StateFilter(FormStateStates.WAITING_FOR_AGE)
    public Mono<Void> processAge(Message message, Bot bot, UpdateContext context) {
        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm.updateData("age", message.text())
            .then(fsm.setState(FormState.CONFIRM))
            .then(fsm.getData().flatMap(data -> {
                String summary = "Name: " + data.get("name") + "\nAge: " + data.get("age")
                    + "\n\nIs this correct? (yes/no)";
                return bot.execute(SendMessage.answer(
                    message,
                    summary
                ));
            }))
            .then();
    }

    @OnMessage
    @StateFilter(FormStateStates.CONFIRM)
    public Mono<Void> confirm(Message message, Bot bot, UpdateContext context) {
        FSMContext fsm = context.get("state", FSMContext.class);
        String text = "yes".equalsIgnoreCase(message.text()) ? "Registration complete!" : "Registration cancelled.";
        return fsm.clear()
            .then(bot.execute(SendMessage.answer(
                message,
                text
            )))
            .then();
    }
}
```

### 3. FSMContext API

`FSMContext`'ni `FSMMiddleware` `UpdateContext`'ga `"state"` key'i bilan inject qiladi:

```java
FSMContext fsm = context.get("state", FSMContext.class);
```

| Method | Tavsif |
|---|---|
| `fsm.setState(Enum<?> state)` | Joriy state'ni enum constant orqali o'rnatadi |
| `fsm.setState(String state)` | Joriy state'ni oddiy string orqali o'rnatadi |
| `fsm.getState()` | Joriy state nomini `Mono<String>` sifatida qaytaradi |
| `fsm.updateData(String field, Object value)` | Saqlangan ma'lumotga key-value juftligini qo'shadi |
| `fsm.setData(Map<String, Object> data)` | Saqlangan ma'lumotning hammasini almashtiradi |
| `fsm.getData()` | Saqlangan ma'lumotning hammasini `Mono<Map<String, Object>>` sifatida qaytaradi |
| `fsm.getValue(String field, Class<T> type)` | Key bo'yicha bitta qiymatni qaytaradi |
| `fsm.clear()` | State'ni ham, ma'lumotni ham tozalaydi |

### 4. FSM strategiyasi

`FSMStrategy` storage key qanday aniqlanishini belgilaydi:

| Strategiya | Ajratish |
|---|---|
| `USER_IN_CHAT` (default) | Har bir user'ning har bir chat'da o'z state'i bor |
| `CHAT` | Chat'dagi barcha user'lar bitta state'ni bo'lishadi |
| `USER` | User'ning barcha chat'larda bitta state'i bor |
| `USER_IN_TOPIC` | Har bir user'ning har bir forum topic'da o'z state'i bor |
| `CHAT_TOPIC` | Forum topic'dagi barcha user'lar bitta state'ni bo'lishadi |

Forum topic'lardan tashqarida topic strategiyalari `USER_IN_CHAT` / `CHAT` kabi ishlaydi. User'ga
bog'langan strategiyalar user'i yo'q update'lar uchun (channel post'lar, reaction count'lar,
boost'lar) FSM'ni o'tkazib yuboradi: bunda `context.get("state")` `null` bo'ladi. Business
connection orqali kelgan update'lar har bir connection uchun alohida state oladi.

`application.yml`'da sozlang:

```yaml
telegram:
  fsm:
    strategy: USER_IN_CHAT
```

### 5. Storage backend'lar

| Backend | Config | Tavsif |
|---|---|---|
| Memory | `telegram.fsm.storage: memory` | Xotiradagi `ConcurrentHashMap`. Default. Restart'da yo'qoladi. |
| Redis | `telegram.fsm.storage: redis` | Spring Data Redis orqali distributed storage. Classpath'da `spring-boot-starter-data-redis` bo'lishi kerak. |

---

## Return qiymatlar

Jiogram handler method'larning return qiymatini avtomatik qayta ishlaydi:

```java
// Return a TelegramMethod -> auto-executed via bot.execute()
@OnMessage
public SendMessage echo(Message message) {
    return SendMessage.answer(message, message.text());
}

// Return Mono<Void> -> subscribed directly
@OnMessage
public Mono<Void> manual(Message message, Bot bot) {
    return bot.execute(SendMessage.answer(message, "Hi")).then();
}

// Return void -> no-op
@OnMessage
public void logOnly(Message message) {
    System.out.println("Received: " + message.text());
}

// Return null -> treated as no-op (useful for conditional responses)
@OnMessage
public SendMessage conditional(Message message) {
    if (message.text() == null) return null;
    return SendMessage.answer(message, message.text());
}
```
