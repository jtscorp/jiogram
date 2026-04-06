package io.jiogram.filter;

import io.jiogram.dispatcher.UpdateContext;
import io.jiogram.types.Message;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Set;

/**
 * Filter that matches messages starting with a bot command (e.g., /start, /help).
 * <p>
 * Extracts the command name (without @botname suffix) and any arguments,
 * passing them as "command" and "command_args" in the filter result data map.
 */
public class CommandFilter implements Filter<Message> {

    private final Set<String> commands;

    /**
     * Creates a command filter matching the specified commands.
     * Commands should be provided without the leading slash, e.g., "start", "help".
     * If no commands are specified, any command will match.
     *
     * @param commands the command names to match (without leading slash)
     */
    public CommandFilter(String... commands) {
        this.commands = Set.of(commands);
    }

    @Override
    public Mono<FilterResult> apply(Message event, UpdateContext context) {
        String text = event.text();
        if (text == null || !text.startsWith("/")) {
            return Mono.just(FilterResult.failed());
        }

        // Extract command: "/start@botname args" -> command = "start", args = "args"
        String withoutSlash = text.substring(1);
        String[] parts = withoutSlash.split("\\s+", 2);
        String fullCommand = parts[0]; // "start@botname" or "start"
        String args = parts.length > 1 ? parts[1] : "";

        // Strip @botname suffix if present
        int atIndex = fullCommand.indexOf('@');
        String command = atIndex >= 0 ? fullCommand.substring(0, atIndex) : fullCommand;

        // If specific commands were given, check for match
        if (!commands.isEmpty() && !commands.contains(command)) {
            return Mono.just(FilterResult.failed());
        }

        return Mono.just(FilterResult.passed(Map.of(
                "command", command,
                "command_args", args
        )));
    }
}
