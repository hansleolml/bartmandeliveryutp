package pe.edu.utp.barmandelivery.models;

public class Barman {  // holaaaaaaa
    private int id;
// BARMAN DELIVERY HOLA NO SOY JAVIER
    //HOLA MUNDO SOY JAVIER EL UNICO
    //HOLA MUNDO VERSION II SOY JAVIER
    // HOLA MUNDO VERSION TRES AHORA SI SOY JAVIER EL UNICO
    private String name;
//BARMAN CLASE
    //barman
    public Barman(int id, String name) {
        this.id=id;
        this.name=name;
    }

    public Barman() {
    }

    public int getId() {
        return id;
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
