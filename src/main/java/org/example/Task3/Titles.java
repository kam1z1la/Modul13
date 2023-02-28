package org.example.Task3;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Titles {
    public static final HttpClient CLIENT = java.net.http.HttpClient.newHttpClient();
    public static final Gson GSON = new Gson();
    public static List<UserWithTask> userTitle = new LinkedList<>();

    public static List<UserWithTask> setUser(URI uri) throws IOException, InterruptedException {
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(new GsonParseTask().parse().toString()))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        return  userTitle;
    }

    public static List<UserWithTask> allOpenTask(URI uri, Integer userId) throws IOException, InterruptedException {
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());

        return  userTitle.stream()
                .filter(us->userId.equals(us.getUserId()) & !us.getCompleted())
                .collect(Collectors.toList());
    }
}
