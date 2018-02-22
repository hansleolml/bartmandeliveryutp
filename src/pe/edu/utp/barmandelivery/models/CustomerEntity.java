package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM bar.customers";

    private List<Customer> findByCriteria(String sql) {
        List<Customer> customers;
        if (getConnection() != null) {
            customers = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Customer customer = new Customer()
                            .setId(resultSet.getInt("customer_id"))
                            .setName(resultSet.getString("customer_name"));
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
                "WHERE customer_id =" +
                        String.valueOf(id));
        return (customers != null ? customers.get(0) : null);
    }

    public Customer findByName(String name) {
        List<Customer> customers = findByCriteria(
                "WHERE customer_name =" + name + "'");
        return (customers != null ? customers.get(0) : null);
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


    public boolean delete(int id){
        return updatebyCriteria("DELETE FROM customers WHERE customer_id ="+String.valueOf(id)) > 0;

    }

    public boolean delete(String name){
        return updatebyCriteria("DELETE FROM customers WHERE customer_name ='"+name+"'")>0;
    }

    public boolean update(Customer customer){
        return updatebyCriteria("UPDATE customers SET customer_name ='"+ customer.getName()+"'WHERE customer_id="+
                String.valueOf(customer.getId()))>0;
    }

}

