package uz.example.fsmbot;

import io.jiogram.fsm.FSMStates;

/**
 * FSM states for the registration form.
 * @FSMStates generates FormStates constants for annotation filters.
 */
@FSMStates
public enum Form {
    WAITING_FOR_NAME,
    WAITING_FOR_AGE,
    CONFIRM
}
