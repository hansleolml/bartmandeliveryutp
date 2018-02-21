package pe.edu.utp.barmandelivery.models;

public class Usuario {
    private int id;
    private String name;

    public Usuario(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public Usuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Usuario setName(String name) {
        this.name = name;
        return this;
    }
}
