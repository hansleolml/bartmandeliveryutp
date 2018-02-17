package pe.edu.utp.barmandelivery.models;

public class Cliente {
    private int id;
    private String name;

    public Cliente(int id, String name) { //clase clientessssssssssssss
        this.id=id;
        this.name=name;
    }

    public Cliente() {//esto es para cliente
    }

    public int getId() {
        return id;
    }

    public Cliente setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Cliente setName(String name) {
        this.name = name;
        return this;
    }
}
