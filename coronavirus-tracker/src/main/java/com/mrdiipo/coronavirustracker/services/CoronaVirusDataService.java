package com.mrdiipo.coronavirustracker.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class CoronaVirusDataService {

    private static String VIRUS_DATA_URL = "";

    @PostConstruct
    public void fetchVirusData() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.body());
    }
}
