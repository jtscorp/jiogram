package io.jiogram.filter;

/**
 * Naming rule for FSM state enums: the name a constant is stored under and matched against
 * by {@code @StateFilter}.
 * <p>
 * The default name is the enum's type name relative to its package, enclosing types included,
 * followed by the constant: {@code Form.WAITING_FOR_NAME} for a top-level {@code Form} enum and
 * {@code OrderFlow.State.CONFIRM} for a {@code State} enum nested in {@code OrderFlow}, so two
 * nested {@code State} enums no longer share names. Enums implementing this interface (or
 * {@code io.jiogram.fsm.BotState}) may override {@link #fullName()}.
 */
public interface NamedState {

    /**
     * Returns the stored state name; defaults to {@link #qualifiedName(Enum)}.
     */
    default String fullName() {
        return qualifiedName((Enum<?>) this);
    }

    /**
     * Returns the name used for any enum state: {@link #fullName()} for a {@code NamedState},
     * otherwise {@link #qualifiedName(Enum)}.
     */
    static String nameOf(Enum<?> state) {
        return state instanceof NamedState named ? named.fullName() : qualifiedName(state);
    }

    /**
     * Returns the default name: package-relative type name plus constant name.
     */
    static String qualifiedName(Enum<?> state) {
        Class<?> type = state.getDeclaringClass();
        String canonical = type.getCanonicalName();
        if (canonical == null) {
            // Local enums have no canonical name.
            return type.getSimpleName() + "." + state.name();
        }
        String packageName = type.getPackageName();
        String relative = packageName.isEmpty() ? canonical : canonical.substring(packageName.length() + 1);
        return relative + "." + state.name();
    }
}
