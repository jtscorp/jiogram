[O'zbekcha](uz/core-concepts.md) · [English](core-concepts.md)

# Core Concepts

## Bot

The `Bot` class wraps a Telegram bot token and a `TelegramSession` for making API calls.

```java
import io.jiogram.bot.Bot;
import io.jiogram.methods.SendMessage;

// In a handler, Bot is injected automatically:
@OnMessage
public Mono<Void> greet(Message message, Bot bot) {
    return bot.execute(SendMessage.answer(message, "Hello!")).then();
}
```

### Answering a message

Every method that sends into a chat (`SendMessage`, `SendPhoto`, `SendMediaGroup`, `SendPoll`,
`CopyMessage`, `SendChatAction`, ...) has two factories that work out where the answer goes from
the received message, like aiogram's `message.answer()` and `message.reply()`:

```java
SendMessage.answer(message, "Hi");       // to the message's chat
SendPhoto.reply(message, photo);         // the same, as a reply to the message
```

They fill in the chat, the forum topic (only when the message is a topic message), the business
connection and the direct messages topic. With `SendMessage.of(ChatId.of(chatId), text)` instead,
an answer in a forum group lands in the General topic.

### Building requests

Methods and types are records with a canonical constructor of every Bot API field. For the
optional ones there are shorter ways: `of(...)` takes only the required values, and every record
has a `withX(...)` per field that returns a copy with that value set.

```java
var keyboard = new InlineKeyboardMarkup(List.of(List.of(
    InlineKeyboardButton.of("About").withCallbackData("about"),
    InlineKeyboardButton.of("Docs").withUrl("https://core.telegram.org/bots/api"))));

bot.execute(SendDocument.answer(message, InputFileOrString.of(InputFile.fromPath(report)))
    .withCaption("<b>Report</b>")
    .withReplyMarkup(keyboard));
```

`InputFile.fromPath(...)` and `InputFile.fromBytes(name, bytes)` upload a file from the
application; they can stand wherever the Bot API accepts a file, also inside a media group, and
the request is then sent as `multipart/form-data`. Union subtypes fill in their `type`
themselves: `InputMediaPhoto.of(media)` is already a photo.

With Spring Boot auto-configuration, the `Bot` bean is created from your `telegram.token` property. You can also inject it anywhere:

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

Configure default parse mode, content protection, and link preview behavior:

```yaml
telegram:
  defaults:
    parse-mode: HTML
    protect-content: false
    link-preview: true
```

They are filled into every request field you leave unset, including nested ones such as media
group captions or inline query results; a field you set yourself is never changed, and a text that
comes with entities gets no default parse mode. They are available via `bot.defaults()`.

---

## Router

The `Router` provides hierarchical event routing. The `Dispatcher` is a special Router that serves as the root and adds middleware support.

### Hierarchical routing

```java
Router adminRouter = new Router("admin");
Router userRouter = new Router("user");

// The dispatcher tries its own handlers first,
// then propagates unhandled events to sub-routers in order.
dispatcher.includeRouter(adminRouter);
dispatcher.includeRouter(userRouter);
```

Events propagate depth-first: the dispatcher's own handlers are checked first. If none match, sub-routers are tried in registration order.

### With annotations

When you use `@TelegramController`, handlers are registered on the root `Dispatcher` (which is also a `Router`). Handler methods are tried in the order they appear in each class. If you need multiple controller classes, they all register on the same dispatcher:

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

## Handlers

### Annotation-based handlers

Use `@OnMessage`, `@OnCallbackQuery`, or `@OnInlineQuery` on methods inside a `@TelegramController` class.

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

#### Method parameter injection

Handler methods can declare these parameter types in any order:

| Type | What gets injected |
|---|---|
| `Message` | The incoming message (for `@OnMessage`) |
| `CallbackQuery` | The callback query (for `@OnCallbackQuery`) |
| `InlineQuery` | The inline query (for `@OnInlineQuery`) |
| `Bot` | The bot instance |
| `UpdateContext` | The context map for this update |

#### Return value handling

| Return type | Behavior |
|---|---|
| `SendMessage`, `AnswerCallbackQuery`, or any `TelegramMethod<?>` | Auto-executed via `bot.execute()` |
| `Mono<TelegramMethod<?>>` | Unwrapped and auto-executed |
| `Mono<Void>` | Subscribed directly |
| `void` or `null` | Treated as no-op |

### Programmatic handlers

Use the fluent builder API on `Router` for handlers defined in code:

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

## Filters

Filters decide whether a handler should process a given event. They return `FilterResult.passed()` or `FilterResult.failed()`.

### Built-in filters

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

### Composing filters

Filters support `.and()`, `.or()`, and `.negate()`:

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

### Custom filters

Implement the `Filter<E>` functional interface:

```java
Filter<Message> photoFilter = (message, context) -> {
    if (message.photo() != null && !message.photo().isEmpty()) {
        return Mono.just(FilterResult.passed());
    }
    return Mono.just(FilterResult.failed());
};
```

Filters can also attach data that gets merged into the `UpdateContext`:

```java
Filter<Message> extractEmail = (message, context) -> {
    String text = message.text();
    if (text != null && text.contains("@")) {
        return Mono.just(FilterResult.passed(Map.of("email", text)));
    }
    return Mono.just(FilterResult.failed());
};
```

Use custom filters with the programmatic API:

```java
router.onMessage()
    .filter(photoFilter)
    .handle((message, context) -> {
        // This only runs for messages with photos
        return Mono.empty();
    });
```

### Annotation filters

`@Command` and `@StateFilter` are annotation-based wrappers around `Filters.command()` and `Filters.state()`:

```java
@OnMessage
@Command("start")              // same as Filters.command("start")
@StateFilter("Form.IDLE")      // same as Filters.state("Form.IDLE")
public SendMessage handler(Message message) { /* ... */ }
```

For enum-based FSM states without generated constants, use `enumClass` so the enum type stays visible at the call site:

```java
@OnMessage
@StateFilter(enumClass = FormState.class, value = "IDLE")
public SendMessage handler(Message message) { /* ... */ }
```

`@OnCallbackQuery` has built-in `data` and `prefix` attributes:

```java
@OnCallbackQuery(data = "confirm")      // same as Filters.callbackData("confirm")
@OnCallbackQuery(prefix = "page_")      // same as Filters.callbackDataPrefix("page_")
```

---

## Middleware

Middleware wraps the entire event processing pipeline. Each middleware receives the event, context, and a chain to call the next middleware (or the final handler).

### Writing custom middleware

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

### Registering middleware

```java
@Bean
public Dispatcher dispatcher() {
    Dispatcher dispatcher = new Dispatcher();
    dispatcher.addOuterMiddleware(new ErrorMiddleware());   // built-in error handler
    dispatcher.addOuterMiddleware(new LoggingMiddleware()); // your custom middleware
    return dispatcher;
}
```

Middleware executes in registration order. The built-in `ErrorMiddleware` catches exceptions and logs them so that one failing update does not crash the polling loop.

### Built-in middleware

| Middleware | Description |
|---|---|
| `ErrorMiddleware` | Catches and logs handler exceptions (added by default) |
| `FSMMiddleware` | Resolves FSM state and injects `FSMContext` into the `UpdateContext` (added when FSM is enabled) |

---

## FSM (Finite State Machine)

FSM lets you build multi-step conversations where the bot remembers what step each user is on.

### 1. Define states

Create an enum and mark it with `@FSMStates`:

```java
import io.jiogram.fsm.FSMStates;

@FSMStates
public enum FormState {
    WAITING_FOR_NAME,
    WAITING_FOR_AGE,
    CONFIRM
}
```

Each constant is stored and matched as a state name like `"FormState.WAITING_FOR_NAME"`.
`@FSMStates` also generates `FormStateStates` constants for annotation use.

Enable the processor in Gradle. It is a separate artifact without dependencies (`@FSMStates`
itself comes with `jiogram-fsm`):

```groovy
dependencies {
    annotationProcessor 'uz.jtscorp.jiogram:jiogram-fsm-processor-sb3:0.2.0'
}
```

### 2. Use @StateFilter in handlers

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

The `FSMContext` is injected into the `UpdateContext` by the `FSMMiddleware` under the key `"state"`:

```java
FSMContext fsm = context.get("state", FSMContext.class);
```

| Method | Description |
|---|---|
| `fsm.setState(Enum<?> state)` | Set the current state using an enum constant |
| `fsm.setState(String state)` | Set the current state using a raw string |
| `fsm.getState()` | Get the current state name as `Mono<String>` |
| `fsm.updateData(String field, Object value)` | Merge a key-value pair into stored data |
| `fsm.setData(Map<String, Object> data)` | Replace all stored data |
| `fsm.getData()` | Get all stored data as `Mono<Map<String, Object>>` |
| `fsm.getValue(String field, Class<T> type)` | Get a single value by key |
| `fsm.clear()` | Clear both state and data |

### 4. FSM Strategy

The `FSMStrategy` determines how the storage key is resolved:

| Strategy | Isolation |
|---|---|
| `USER_IN_CHAT` (default) | Each user has their own state per chat |
| `CHAT` | All users in a chat share the same state |
| `USER` | User has the same state across all chats |
| `USER_IN_TOPIC` | Each user has their own state per forum topic |
| `CHAT_TOPIC` | All users in a forum topic share the same state |

Outside forum topics the topic strategies behave like `USER_IN_CHAT` / `CHAT`. Per-user strategies
skip FSM for updates that have no user (channel posts, reaction counts, boosts): `context.get("state")`
is then `null`. Updates sent through a business connection get a separate state per connection.

Configure in `application.yml`:

```yaml
telegram:
  fsm:
    strategy: USER_IN_CHAT
```

### 5. Storage backends

| Backend | Config | Description |
|---|---|---|
| Memory | `telegram.fsm.storage: memory` | In-memory `ConcurrentHashMap`. Default. Lost on restart. |
| Redis | `telegram.fsm.storage: redis` | Distributed storage via Spring Data Redis. Requires `spring-boot-starter-data-redis` on the classpath. |

---

## Return Values

Jiogram automatically handles the return value of handler methods:

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
