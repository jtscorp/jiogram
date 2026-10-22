package uz.example;

import io.jiogram.session.TelegramSession;
import io.jiogram.session.WebClientTelegramSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;

import java.net.URI;

/**
 * Routes Telegram API calls through a proxy by providing the {@link TelegramSession} bean;
 * the auto-configured session then backs off. Other WebClients in the app are unaffected.
 */
@Configuration
public class ProxyConfig {

    @Bean
    public TelegramSession telegramSession(
            @Value("${telegram.proxy.url:}") String proxyUrl,
            @Value("${telegram.api.base-url:" + WebClientTelegramSession.DEFAULT_BASE_URL + "}") String baseUrl) {
        return new WebClientTelegramSession(proxiedWebClient(proxyUrl), baseUrl);
    }

    private static WebClient proxiedWebClient(String proxyUrl) {
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
