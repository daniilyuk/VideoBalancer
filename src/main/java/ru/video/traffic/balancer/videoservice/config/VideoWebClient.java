package ru.video.traffic.balancer.videoservice.config;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.HashMap;
import java.util.Map;

public class VideoWebClient {

    private static final String BASE_URL = "http://localhost:8080/api/v1";

    private final WebClient webClient;

    public VideoWebClient() {
        this.webClient = WebClient.create(BASE_URL);
    }

    public String balanceTraffic(String url) {
        try {
            Map<String, String> requestBody = new HashMap<>();
            requestBody.put("url", url);
            return webClient.post()
                    .uri("/links")
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientResponseException e) {
            // handle exception
        }
        return null;
    }
}
