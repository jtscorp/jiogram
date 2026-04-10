package io.jiogram.autoconfigure;

import io.jiogram.fsm.storage.RedisStateStorage;
import io.jiogram.fsm.storage.StateStorage;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

/**
 * Auto-configuration for Redis-backed FSM state storage.
 * Active when {@code telegram.fsm.storage=redis} and Redis classes are on the classpath.
 * When active, this replaces the default {@link io.jiogram.fsm.storage.MemoryStateStorage}
 * from {@link FSMAutoConfiguration}.
 */
@Configuration
@AutoConfigureBefore(FSMAutoConfiguration.class)
@ConditionalOnProperty(prefix = "telegram.fsm", name = "storage", havingValue = "redis")
@ConditionalOnClass(ReactiveStringRedisTemplate.class)
public class RedisStorageAutoConfiguration {

    @Bean
    public StateStorage stateStorage(ReactiveStringRedisTemplate redisTemplate) {
        return new RedisStateStorage(redisTemplate);
    }
}
