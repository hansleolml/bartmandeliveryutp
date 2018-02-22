package pe.edu.utp.barmandelivery.models;
public class Customer {
    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public Customer setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }
}
