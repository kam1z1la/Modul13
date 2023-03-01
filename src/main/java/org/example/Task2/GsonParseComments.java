package org.example.Task2;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.example.Task2.Comments.GSON;
import static org.example.Task2.Comments.listComments;
import static org.example.Task2.Comments.userComments;


public class GsonParseComments {
    public List<UserComments> parse() {
        try (BufferedReader br = new BufferedReader(new FileReader("userComments.json"))) {
            JsonArray array = GSON.fromJson(br, JsonArray.class);
            for (JsonElement element : array) {
                userComments = GSON.fromJson(element, UserComments.class);
                listComments.add(userComments);
            }
            return listComments;
        } catch (IOException e) {
            System.out.println("Problem reading file!");
        }
        return null;
    }
}