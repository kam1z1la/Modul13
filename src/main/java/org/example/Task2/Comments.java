package org.example.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Comments {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    static final Gson GSON = new Gson();
    static UserComments userComments;
    public static List<UserComments> listComments = new ArrayList<>();
    public static List<UserComments> listFileComments;

    public static List<UserComments> setUser(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .POST(HttpRequest.BodyPublishers.ofString(new GsonParseComments().parse().toString()))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        return listComments;
    }

    public static List<UserComments> getUser(URI uri, Integer userId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        return listComments.stream()
                .filter(us -> userId.equals(us.getUserId()))
                .collect(toList());
    }

    public static void fileUser(Integer userId) throws IOException {
        listFileComments = new ArrayList<>();

        String nameFile = "user-" + userId + "-post-" + userComments.getId() + "-comments.json";

        File uic = new File(nameFile);
        if (!uic.exists())
            uic.createNewFile();

        try (FileWriter writer = new FileWriter(uic)) {
            Gson gs = new GsonBuilder().setPrettyPrinting()
                                      .create();
            for (UserComments listComment : listComments) {
                if (userId.equals(userComments.getUserId()))
                    listFileComments.add(listComment);
            }
            String stringGS = gs.toJson(listFileComments);
            writer.write(stringGS);
            writer.flush();
            System.out.println("File create!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "users=" + listComments;
    }
}