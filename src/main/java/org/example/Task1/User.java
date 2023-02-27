package org.example.Task1;

public class User {
    private final int id;
    private final String name;
    private final String username;
    private final String email;
    private final String phone;
    private final String website;

    public User(int id, String name, String username, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        return   "\n" + "{\n" +
                "id=" + id + ",\n" +
                "name='" + name + ",\n" +
                "username='" + username + ",\n" +
                "email='" + email + ",\n" +
                "phone='" + phone + ",\n" +
                "website='" + website + "\n" +
                "}";
    }
}