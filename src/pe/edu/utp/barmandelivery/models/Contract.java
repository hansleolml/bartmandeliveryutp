package pe.edu.utp.barmandelivery.models;

public class Contract {
    private int id;
    private String name;
    private String place;
    private int order;
    private int time;
    private double confirmation;

    public Contract(int id, String name, String place, int order, int time, double confirmation) { //uno
        this.id=id;
        this.name=name;
        this.place=place;
        this.order=order;
        this.time=time;
        this.confirmation=confirmation;

    }

    public Contract() {//esto es para cliente
    }

    public int getId() {
        return id;
    }

    public Contract setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Contract setName(String name) {
        this.name = name;
        return this;
    }
}
