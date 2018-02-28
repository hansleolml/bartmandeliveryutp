package pe.edu.utp.barmandelivery.models;

public class Barman {
    private int id;
    private String name;
    private String sur_names;
    private float calificacion;


    public Barman(int id, String name,String sur_names,float calificacion) {
        this.id=id;
        this.name = name;
        this.sur_names = sur_names;
        this.calificacion = calificacion;
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

    public float getCalificacion() {
        return calificacion;
    }

    public Barman setCalificacion(float calificacion) {
        this.calificacion = calificacion;
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
