package pe.edu.utp.barmandelivery.models;

public class Barman {
    private int id;
    private int user_id;


    public Barman(int id, int user_id) {
        this.id=id;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
