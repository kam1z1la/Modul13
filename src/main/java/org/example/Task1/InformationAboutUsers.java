package org.example.Task1;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.LinkedList;
import java.util.List;

public class InformationAboutUsers {
    public static final HttpClient CLIENT = java.net.http.HttpClient.newHttpClient();
    public static final Gson GSON = new Gson();
    public static List<User> users = new LinkedList<>();

    public static User setUser(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(new GsonParse().parse().get(0).toString()))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        return GSON.fromJson(response.body(), User.class);
    }

    @Override
    public String toString() {
        return "users=" + users ;
    }
}