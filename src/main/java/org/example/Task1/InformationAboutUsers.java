package org.example.Task1;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class InformationAboutUsers {
    public static final HttpClient CLIENT = java.net.http.HttpClient.newHttpClient();
    public static final Gson GSON = new Gson();
    public static User user;
    public static List<User> users = new LinkedList<>();

    public static User setUser(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(new GsonParse().parse().toString()))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        user = users.get(0);
        return user;
    }

    public static User getUser(URI uri, File file) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(file.getPath())))
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        return user;
    }

    public static User delete(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        users.remove(user);
        return user;
    }

    public static List<User> allUsers(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        return users;
    }

    public static List<User> findUserByID(URI uri,Integer id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                 .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());

        return  users.stream()
                .filter(us-> id.equals(us.getId()))
                .collect(toList());
    }

    public static List<User> findUsername(URI uri,String username) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());

        return  users.stream()
                .filter(us-> username.equals(us.getUsername()))
                .collect(toList());
    }

    @Override
    public String toString() {
        return "users=" + users ;
    }
}