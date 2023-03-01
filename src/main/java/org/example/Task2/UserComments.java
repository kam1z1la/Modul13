package org.example.Task2;

public class UserComments {
    private int userId;
    private int id;
    private String title;
    private String body;

    public UserComments(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "{\n" +
                "userId: " + userId +",\n" +
                "id=" + id +",\n" +
                "title='" + title +",\n" +
                "body='" + body +",\n" +
                "}";
    }
}
