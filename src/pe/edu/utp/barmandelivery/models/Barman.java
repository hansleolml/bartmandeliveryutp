package pe.edu.utp.barmandelivery.models;

public class Barman {
    private int id;
    private String name;
    private String sur_names;


    public Barman(int id, String name,String sur_names) {
        this.id=id;
        this.name = name;
        this.sur_names = sur_names;
    }

    public Barman() {
    }

    public int getId() {
        return id;
    }

    public String getSur_names() {
        return sur_names;
    }

    public Barman setSur_names(String sur_names) {
        this.sur_names = sur_names;
        return this;
    }

    public Barman setId(int id) {
        this.id = id;
        return this;

    }

    public String getName() {
        return name;
    }

    public Barman setName(String name) {
        this.name = name;
        return this;
    }

}
