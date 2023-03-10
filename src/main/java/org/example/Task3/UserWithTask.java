package org.example.Task3;

public class UserWithTask {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public UserWithTask(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return  "\n" + "{\n" +
                "userId: " + userId + ",\n" +
                "id: " + id + ",\n" +
                "title: " + title + ",\n" +
                "completed: " + completed + "\n" +
                "}";
    }
}
