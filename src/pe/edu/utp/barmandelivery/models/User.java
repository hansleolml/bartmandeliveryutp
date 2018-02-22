package pe.edu.utp.barmandelivery.models;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }
}
