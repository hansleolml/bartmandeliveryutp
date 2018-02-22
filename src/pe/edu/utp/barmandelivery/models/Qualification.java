package pe.edu.utp.barmandelivery.models;

    public class Qualification {
    private String id;
    private String barman;
    private String customer;
    public Qualification() {
    }

    public Qualification(String id, String barman, String customer) {
        this.id = id;
        this.barman = barman;
        this.customer = customer;
    }

        public Qualification(int maxId, String name) {
        }

        public String getId() {
            return id;
        }

        public Qualification setid(String id) {
            this.id = id;
            return this;
        }

        public String getBarman() {return barman;}

        public Qualification setBarman(String barman) {
            this.barman = barman;
            return this;
        }
        public String getCustomer() { return customer; }

        public Qualification setCustomer (String customer){
            this.customer = customer;
            return this;
        }

        public Qualification setId(int qualification_id) {
            this.id = id;
            return this;
        }
    }