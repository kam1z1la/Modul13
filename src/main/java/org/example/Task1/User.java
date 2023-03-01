package org.example.Task1;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Company company;
    private Address  address;

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

    public String getUsername() {
        return username;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return   "\n" + "{\n" +
                "id: " + id + ",\n" +
                "name: " + name + ",\n" +
                "username: " + username + ",\n" +
                "email: " + email + ",\n" +
                "address: " + "{\n" +
                "street: "  + address.street + ",\n" +
                "suite: " + address.suite + ",\n" +
                "city: " + address.city + ",\n" +
                "zipcode" + address.zipcode + ",\n" +
                "geo: " + "{\n" +
                "lat" + address.geo.lat + ",\n" +
                "lng" + address.geo.lng + ",\n" +
                " }\n" +
                "},\n"+
                "phone:" + phone + ",\n" +
                "website: " + website + "\n" +
                "company: " + "{\n" +
                "name: " + company.name + ",\n" +
                "catchPhrase: " + company.catchPhrase + ",\n" +
                "bs: " + company.bs + ",\n" +
                "}";
    }
}