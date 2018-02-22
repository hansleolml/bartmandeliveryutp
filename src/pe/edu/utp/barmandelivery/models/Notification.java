package pe.edu.utp.barmandelivery.models;

public class Notification {
    private String id;
    private String name;
    private String customer;
    public Notification() {
    }
    public Notification(String id, String name, String customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }
    public String getId() {
        return id;
    }

    public Notification setid(String id) {
        this.id = id;
        return this;
    }

    public String getName() {return name;}

    public Notification setName(String name) {
        this.name = name;
        return this;
    }

    public String getCustomer() { return customer; }

    public Notification setCustomer (String customer){
        this.customer = customer;
        return this;
    }

}




