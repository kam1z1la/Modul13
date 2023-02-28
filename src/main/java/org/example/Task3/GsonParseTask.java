package org.example.Task3;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.example.Task3.Titles.GSON;
import static org.example.Task3.Titles.userTitle;


public class GsonParseTask {
        public List<UserWithTask> parse() {
            try (BufferedReader br = new BufferedReader(new FileReader("usersTitle.json"))) {
                JsonArray array = GSON.fromJson(br, JsonArray.class);
                for (JsonElement element : array) {
                    UserWithTask uwt = GSON.fromJson(element, UserWithTask.class);
                    userTitle.add(uwt);
                }
                return userTitle;
            } catch (IOException e) {
                System.out.println("Problem reading file!");
            }
            return null;
        }
}