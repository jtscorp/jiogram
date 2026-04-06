package com.example.fsmbot;

import io.jiogram.fsm.BotState;

/**
 * FSM states for the registration form.
 * Each constant produces a fullName() like "Form.WAITING_FOR_NAME".
 */
public enum Form implements BotState {
    WAITING_FOR_NAME,
    WAITING_FOR_AGE,
    CONFIRM
}
