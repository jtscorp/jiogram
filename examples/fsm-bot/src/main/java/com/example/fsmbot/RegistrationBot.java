package com.example.fsmbot;

import io.jiogram.annotation.Command;
import io.jiogram.annotation.OnMessage;
import io.jiogram.annotation.StateFilter;
import io.jiogram.annotation.TelegramController;
import io.jiogram.bot.Bot;
import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.fsm.FSMContext;
import io.jiogram.methods.SendMessage;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

/**
 * Multi-step registration form using FSM.
 *
 * Flow: /register -> enter name -> enter age -> confirm (yes/no)
 */
@TelegramController
public class RegistrationBot {

    @OnMessage
    @Command("start")
    public SendMessage onStart(Message message) {
        return SendMessage.answer(
            message,
            "Welcome! Use /register to start the registration form."
        );
    }

    @OnMessage
    @Command("cancel")
    public Mono<Void> onCancel(Message message, Bot bot, UpdateContext context) {
        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm.clear()
            .then(bot.execute(SendMessage.answer(
                message,
                "Registration cancelled. Use /register to start over."
            )))
            .then();
    }

    @OnMessage
    @Command("register")
    public Mono<Void> startRegistration(Message message, Bot bot, UpdateContext context) {
        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm.setState(Form.WAITING_FOR_NAME)
            .then(bot.execute(SendMessage.answer(
                message,
                "Let's start registration.\n\nWhat is your name?"
            )))
            .then();
    }

    @OnMessage
    @StateFilter(FormStates.WAITING_FOR_NAME)
    public Mono<Void> processName(Message message, Bot bot, UpdateContext context) {
        String name = message.text();
        if (name == null || name.isBlank()) {
            return bot.execute(SendMessage.answer(
                message,
                "Please enter a valid name."
            )).then();
        }

        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm.updateData("name", name)
            .then(fsm.setState(Form.WAITING_FOR_AGE))
            .then(bot.execute(SendMessage.answer(
                message,
                "Nice to meet you, " + name + "!\n\nHow old are you?"
            )))
            .then();
    }

    @OnMessage
    @StateFilter(FormStates.WAITING_FOR_AGE)
    public Mono<Void> processAge(Message message, Bot bot, UpdateContext context) {
        String ageText = message.text();
        if (ageText == null || ageText.isBlank()) {
            return bot.execute(SendMessage.answer(
                message,
                "Please enter a valid age (a number)."
            )).then();
        }

        int age;
        try {
            age = Integer.parseInt(ageText.trim());
        } catch (NumberFormatException e) {
            return bot.execute(SendMessage.answer(
                message,
                "That doesn't look like a number. Please enter your age."
            )).then();
        }

        if (age < 1 || age > 150) {
            return bot.execute(SendMessage.answer(
                message,
                "Please enter a realistic age (1-150)."
            )).then();
        }

        FSMContext fsm = context.get("state", FSMContext.class);
        return fsm.updateData("age", age)
            .then(fsm.setState(Form.CONFIRM))
            .then(fsm.getData().flatMap(data -> {
                String summary = "Please confirm your registration:\n\n"
                    + "Name: " + data.get("name") + "\n"
                    + "Age: " + data.get("age") + "\n\n"
                    + "Is this correct? (yes/no)";
                return bot.execute(SendMessage.answer(
                    message,
                    summary
                ));
            }))
            .then();
    }

    @OnMessage
    @StateFilter(FormStates.CONFIRM)
    public Mono<Void> processConfirmation(Message message, Bot bot, UpdateContext context) {
        String answer = message.text();
        FSMContext fsm = context.get("state", FSMContext.class);

        if ("yes".equalsIgnoreCase(answer)) {
            return fsm.getData().flatMap(data -> {
                String result = "Registration complete!\n\n"
                    + "Name: " + data.get("name") + "\n"
                    + "Age: " + data.get("age");
                return fsm.clear()
                    .then(bot.execute(SendMessage.answer(
                        message,
                        result
                    )));
            }).then();
        } else if ("no".equalsIgnoreCase(answer)) {
            return fsm.clear()
                .then(bot.execute(SendMessage.answer(
                    message,
                    "Registration cancelled. Use /register to start over."
                )))
                .then();
        } else {
            return bot.execute(SendMessage.answer(
                message,
                "Please answer 'yes' or 'no'."
            )).then();
        }
    }
}
