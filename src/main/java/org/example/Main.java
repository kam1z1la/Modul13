package org.example;

import org.example.Task1.InformationAboutUsers;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        File json = new File("users.json");
        if(!json.exists())
            json.createNewFile();



        final String URL0 = "https://jsonplaceholder.typicode.com/users";
        System.out.println(InformationAboutUsers.setUser(URI.create(URL0)));

    }
}