package com.demowechat.util;

import java.net.http.HttpClient;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.StringJoiner;


@Component
public class HttpClientUtil {

    private static final HttpClient CLIENT = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    public String get(String url, Map<String, String> params)
            throws IOException, InterruptedException {

        String fullUrl = buildUrl(url, params);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fullUrl))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }

    /**
     * 拼接QueryString
     */
    private static String buildUrl(String url, Map<String, String> params) {

        if (params == null || params.isEmpty()) {
            return url;
        }

        StringJoiner joiner = new StringJoiner("&");

        params.forEach((key, value) -> {
            joiner.add(
                    URLEncoder.encode(key, StandardCharsets.UTF_8)
                            + "=" +
                            URLEncoder.encode(value, StandardCharsets.UTF_8)
            );
        });

        return url + (url.contains("?") ? "&" : "?") + joiner;
    }
}
