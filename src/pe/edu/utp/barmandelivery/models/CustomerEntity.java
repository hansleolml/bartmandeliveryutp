package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM hr.barmans";

    private List<Customer> findByCriteria(String sql) {
        List<Customer> customers;
        if (getConnection() != null) {
            customers = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Customer customer = new Customer()
                            .setId(resultSet.getInt("customer id"))
                            .setName(resultSet.getString("cliente_name"));
                    customers.add(customer);
                }
                return customers;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Customer> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Customer findById(int id) {
        List<Customer> customers = findByCriteria(
                "WHERE cliente_id =" +
                        String.valueOf(id));
        return (customers != null ? customers.get(0) : null);
    }

    public Customer findByName(String name) {
        List<Customer> customers = findByCriteria(
                "WHERE cliente_name =" + name + "'");
        return (customers != null ? customers.get(0) : null);
    }

    private int getMaxId() {
        String sql = "SELECT MAX(cliente_id) AS max_id FROM clientes";
        if(getConnection()!=null){
            try {
                ResultSet resultSet = getConnection()
                        .createStatement()
                        .executeQuery(sql);
                return resultSet.next() ? resultSet.getInt("max_id") : 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    private int updatebyCriteria (String sql){
        if (getConnection() != null){
            try {
                return getConnection()
                        .createStatement()
                        .executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public Customer create (String name){
        if (findByName(name) == null) {
            if (getConnection() != null) {
                String sql = "INSER INTO clientes(cliente_id,cliente_name)" + "VALUES(" + String.valueOf(getMaxId() + 1) + ",'"
                        + name + "')";
                int results = updatebyCriteria(sql);
                if (results > 0) {
                    Customer customer = new Customer(getMaxId(), name);
                    return customer;
                }
            }
        }
        return null;
    }
    public boolean delete(int id){
        return updatebyCriteria("DELETE FROM clientes WHERE cliente_id ="+String.valueOf(id)) > 0;

    }

    public boolean delete(String name){
        return updatebyCriteria("DELETE FROM clientes WHERE cliente_name ='"+name+"'")>0;
    }

    public boolean update(Customer customer){
        return updatebyCriteria("UPDATE clientes SET cliente_name ='"+ customer.getName()+"'WHERE cliente_id="+
                String.valueOf(customer.getId()))>0;
    }

}

