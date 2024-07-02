package com.kbnproject.moneycast.Service;

import com.kbnproject.moneycast.Config.ConfigLoader;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class HttpService {

    private final String apiKey;
    private final HttpClient client;

    public HttpService(String apiKey){
        this.client = HttpClient.newHttpClient();
        this.apiKey = apiKey;
    }

    public String httpReq(String moneyCast) throws IOException, InterruptedException {
        String encodedMoney = URLEncoder.encode(moneyCast, StandardCharsets.UTF_8);
        String uri = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + encodedMoney;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
