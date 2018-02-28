package pe.edu.utp.barmandelivery.models;

public class Drink {
    private int id;
    private String name;
    private String volume;
    private float cost;

    public Drink(int id, String name, String volume, float cost) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.cost = cost;
    }

    public Drink() {
    
    }

    public int getId() {
        return id;
    }

    public Drink setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Drink setName(String name) {
        this.name = name;
        return this;
    }

    public String getVolume() {
        return volume;
    }

    public Drink setVolume(String volume) {
        this.volume = volume;
        return this;
    }

    public float getCost() {
        return cost;
    }

    public Drink setCost(float cost) {
        this.cost = cost;
        return this;
    }
}
