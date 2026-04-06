package io.jiogram.autoconfigure;

import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.fsm.FSMStrategy;
import io.jiogram.fsm.middleware.FSMMiddleware;
import io.jiogram.fsm.storage.MemoryStateStorage;
import io.jiogram.fsm.storage.StateStorage;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * Auto-configuration for FSM (Finite State Machine) support.
 * Creates a {@link StateStorage} (defaulting to {@link MemoryStateStorage}) and
 * registers an {@link FSMMiddleware} on the {@link Dispatcher}.
 * <p>
 * Enabled by default; disable with {@code telegram.fsm.enabled=false}.
 */
@AutoConfiguration(after = JiogramAutoConfiguration.class)
@ConditionalOnBean(Dispatcher.class)
@ConditionalOnProperty(prefix = "telegram.fsm", name = "enabled", havingValue = "true", matchIfMissing = true)
public class FSMAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StateStorage stateStorage() {
        return new MemoryStateStorage();
    }

    @Bean
    public FSMMiddleware fsmMiddleware(
            StateStorage stateStorage,
            Dispatcher dispatcher,
            JiogramProperties properties) {

        FSMStrategy strategy = FSMStrategy.USER_IN_CHAT;
        if (properties.fsm() != null && properties.fsm().strategy() != null) {
            try {
                strategy = FSMStrategy.valueOf(properties.fsm().strategy());
            } catch (IllegalArgumentException ignored) {
                // fall back to default
            }
        }

        FSMMiddleware middleware = new FSMMiddleware(stateStorage, strategy);
        dispatcher.addOuterMiddleware(middleware);
        return middleware;
    }
}
