package pe.edu.utp.barmandelivery.models;

public class Contracts {
    private int id;
    private String name;
    private String place;
    private int order;
    private int time;
    private double confirmation;

    public Contracts(int id, String name, String place, int order, int time, double confirmation) { //uno
        this.id=id;
        this.name=name;
        this.place=place;
        this.order=order;
        this.time=time;
        this.confirmation=confirmation;

    }

    public Contracts() {//esto es para cliente
    }

    public int getId() {
        return id;
    }

    public Contracts setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contracts setName(String name) {
        this.name = name;
        return this;
    }
}
