package org.example;

import org.example.Task1.InformationAboutUsers;
import org.example.Task2.Comments;
import org.example.Task3.Titles;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("==============================Task1=====================================");

        File json = new File("users.json");
        if(!json.exists())
            json.createNewFile();

        final String URL0 = "https://jsonplaceholder.typicode.com/users";
        System.out.println("SetUser: " + InformationAboutUsers.setUser(URI.create(URL0)) + "\n");
        System.out.println("GetUser: " + InformationAboutUsers.getUser(URI.create(URL0))+ "\n");
        System.out.println("Delete: " + InformationAboutUsers.delete(URI.create(URL0))+ "\n");
        System.out.println("AllUsers: " + InformationAboutUsers.allUsers(URI.create(URL0))+ "\n");

//        final String URL1 = "https://jsonplaceholder.typicode.com/users/%7Bid%7D"; WRONG LINK
        System.out.println("FindUser: " + InformationAboutUsers.findUserByID(URI.create(URL0),2)+ "\n");
        final String URL2 = "https://jsonplaceholder.typicode.com/users?username=%7Busername%7D";
        System.out.println("FindUsername: " + InformationAboutUsers.findUsername(URI.create(URL2),"Antonette")+ "\n");

        System.out.println("==============================Task2=====================================");

        File body = new File("userComments.json");
        if(!body.exists())
            body.createNewFile();

        final String URL3 = "https://jsonplaceholder.typicode.com/users/1/posts";
        System.out.println(("SetUser: " + Comments.setUser(URI.create(URL3))+"\n"));
        System.out.println("GetAllUser: " + Comments.getUser(URI.create(URL3),1)+"\n");
        Comments.fileUser(1);

        System.out.println("==============================Task3=====================================");

        File title = new File("usersTitle.json");
        if(!title.exists())
            title.createNewFile();

        final String URL4 =  "https://jsonplaceholder.typicode.com/users/1/todos";
        System.out.println(("SetUser: " + Titles.setUser(URI.create(URL4))+"\n"));
        System.out.println("AllOpenTask: " + Titles.allOpenTask(URI.create(URL4), 1)+"\n");
    }
}