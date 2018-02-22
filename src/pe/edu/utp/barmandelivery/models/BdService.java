package pe.edu.utp.barmandelivery.models;

import java.sql.Connection;
import java.util.List;

public class BdService {
    private Connection connection;
    private BarmansEntity barmansEntity;//debe retornar una instancia de region entity, pero no es necesario visualizarlo
    private CustomerEntity customerEntity;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public BarmansEntity getBarmansEntity() {
        if (getConnection()!=null){
            if (barmansEntity==null){
                barmansEntity=new BarmansEntity();
                barmansEntity.setConnection(getConnection());
            }
        }
        return barmansEntity;
    }
    public CustomerEntity getCustomerEntity() {
        if (getConnection()!=null){
            if (customerEntity==null){
                customerEntity=new CustomerEntity();
                customerEntity.setConnection(getConnection());
            }
        }
        return customerEntity;
    }





    public List<Barman> findAllBarman(){
        return getBarmansEntity() !=null ?
                getBarmansEntity().findAll():null;
    }

    public Barman findBarmanById(int id){
        return getBarmansEntity()!=null ?
                getBarmansEntity().findById(id):null;
    }

    public Barman findBarmanByName(String name) {
        return getBarmansEntity() != null ?
                getBarmansEntity().findByName(name) : null;
    }

    public Barman createBarman(String name){
        return getBarmansEntity()!=null?
                getBarmansEntity().create(name):null;
    }

    public boolean deleteBarman(int id){
        return getBarmansEntity()!= null ?
                getBarmansEntity().delete(id):false;
    }
    public  boolean updateBarman(Barman barman){
        return getBarmansEntity() != null ?
                getBarmansEntity().update(barman) : false;
    }


    public List<Customer> findAllCustomer(){
        return getCustomerEntity() !=null ?
                getCustomerEntity().findAll():null;
    }

    public Customer findCustomerById(int id){
        return getCustomerEntity()!=null ?
                getCustomerEntity().findById(id):null;
    }

    public Customer findCustomerByName(String name) {
        return getCustomerEntity() != null ?
                getCustomerEntity().findByName(name) : null;
    }


    public boolean deleteCustomer(int id){
        return getCustomerEntity()!= null ?
                getCustomerEntity().delete(id):false;
    }
    public  boolean updateCustomer(Customer customer){
        return getCustomerEntity() != null ?
                getCustomerEntity().update(customer) : false;
    }




}
