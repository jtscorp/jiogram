package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

import java.net.URI;

@Configuration
public class ProxyConfig {

    @Bean
    public WebClient telegramWebClient(@Value("${telegram.proxy.url:}") String proxyUrl) {
        if (proxyUrl == null || proxyUrl.isBlank()) {
            return WebClient.builder().build();
        }

        URI uri = URI.create(proxyUrl);
        ProxyProvider.Proxy type = "socks5".equalsIgnoreCase(uri.getScheme())
            ? ProxyProvider.Proxy.SOCKS5
            : ProxyProvider.Proxy.HTTP;

        HttpClient httpClient = HttpClient.create()
            .proxy(proxy -> proxy
                .type(type)
                .host(uri.getHost())
                .port(resolvePort(uri)));

        return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();
    }

    private static int resolvePort(URI uri) {
        if (uri.getPort() > 0) {
            return uri.getPort();
        }
        return "https".equalsIgnoreCase(uri.getScheme()) ? 443 : 80;
    }
}
