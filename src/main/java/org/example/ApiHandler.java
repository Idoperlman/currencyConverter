package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiHandler {
    private String baseURL;
    private String key;

    public ApiHandler(String baseURL, String key){
        this.baseURL = baseURL;
        this.key = key;
    }

    public double exchangeRateCalc(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        String url = this.baseURL + "/exchange?from=" + fromCurrency + "&to=" + toCurrency + "&q=1.0";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("x-rapidapi-key", this.key)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return Double.parseDouble(response.body());
    }

}
