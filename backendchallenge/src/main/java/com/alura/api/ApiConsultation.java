package com.alura.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ApiConsultation {

    protected static String apiRequest(String currency) {

        String currencyUrl = currency;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/fac1e82614017b9c24813485/latest/" + currencyUrl))
                .build();
            HttpResponse<String> response = client
                .send(request, BodyHandlers.ofString());
            /* System.out.println(response.body()); */
            return response.body();
        } catch (IllegalStateException e) {
            e.getMessage();
            return null;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }
}
