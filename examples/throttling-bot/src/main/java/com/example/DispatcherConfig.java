package com.example;

import io.jiogram.dispatcher.Dispatcher;
import io.jiogram.middleware.ErrorMiddleware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DispatcherConfig {

    @Bean
    public Dispatcher dispatcher(AntifloodMiddleware antifloodMiddleware) {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.addOuterMiddleware(new ErrorMiddleware());
        dispatcher.addOuterMiddleware(antifloodMiddleware);
        return dispatcher;
    }
}
