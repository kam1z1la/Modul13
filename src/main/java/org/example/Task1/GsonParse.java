package org.example.Task1;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.example.Task1.InformationAboutUsers.GSON;
import static org.example.Task1.InformationAboutUsers.users;


public class GsonParse {
        public List<User> parse() {
            try (BufferedReader br = new BufferedReader(new FileReader("users.json"))) {
                JsonArray array = GSON.fromJson(br, JsonArray.class);
                for (JsonElement element : array) {
                    User user = GSON.fromJson(element, User.class);
                    users.add(user);
                }
                return users;
            } catch (IOException e) {
                System.out.println("Problem reading file!");
            }
            return null;
        }

}