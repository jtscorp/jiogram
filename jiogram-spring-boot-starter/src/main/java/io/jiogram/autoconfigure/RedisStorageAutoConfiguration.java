package io.jiogram.autoconfigure;

import io.jiogram.fsm.storage.RedisStateStorage;
import io.jiogram.fsm.storage.StateStorage;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

/**
 * Auto-configuration for Redis-backed FSM state storage.
 * Active when {@code telegram.fsm.storage=redis} and Redis classes are on the classpath.
 * When active, this replaces the default {@link io.jiogram.fsm.storage.MemoryStateStorage}
 * from {@link FSMAutoConfiguration}.
 */
@AutoConfiguration(before = FSMAutoConfiguration.class)
@ConditionalOnProperty(prefix = "telegram.fsm", name = "storage", havingValue = "redis")
@ConditionalOnClass(ReactiveStringRedisTemplate.class)
@EnableConfigurationProperties(JiogramProperties.class)
public class RedisStorageAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public StateStorage stateStorage(ReactiveStringRedisTemplate redisTemplate, JiogramProperties properties) {
        JiogramProperties.RedisProperties redis = properties.fsm().redis();
        return new RedisStateStorage(redisTemplate,
            new RedisStateStorage.Settings(redis.keyPrefix(), redis.stateTtl(), redis.dataTtl()));
    }
}
