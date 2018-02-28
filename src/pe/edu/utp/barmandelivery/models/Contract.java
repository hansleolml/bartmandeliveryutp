package pe.edu.utp.barmandelivery.models;

public class Contract {
    private int id;
    private int bartenderId;
    private int clienteId;
    private String cliente;

    public Contract(int id, int bartenderId, int clienteId,String cliente) {
        this.id = id;
        this.bartenderId = bartenderId;
        this.clienteId = clienteId;
        this.cliente=cliente;
    }

    public Contract(){

    }

    public String getCliente() {
        return cliente;
    }

    public Contract setCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public int getId() {
        return id;
    }

    public Contract setId(int id) {
        this.id = id;
        return this;
    }

    public int getBartenderId() {
        return bartenderId;
    }

    public Contract setBartenderId(int bartenderId) {
        this.bartenderId = bartenderId;
        return this;
    }

    public int getClienteId() {
        return clienteId;
    }

    public Contract setClienteId(int clienteId) {
        this.clienteId = clienteId;
        return this;
    }
}
