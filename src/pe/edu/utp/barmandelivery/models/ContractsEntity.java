package pe.edu.utp.barmandelivery.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractsEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT bar.contracts.*,bar.users.name as cliente FROM bar.contracts LEFT JOIN bar.users on bar.contracts.users_id = bar.users.ID";

    private List<Contract> findByCriteria(String sql) {
        List<Contract> contracts;
        if (getConnection() != null) {
            contracts = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while (resultSet.next()) {
                    Contract contract = new Contract()
                            .setId(resultSet.getInt("id"))
                            .setBartenderId(resultSet.getInt("bartenders_id"))
                            .setCliente(resultSet.getString("cliente"));
                    contracts.add(contract);
                }
                return contracts;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Contract> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Contract findById(int id) {
        List<Contract> contracts = findByCriteria(
                "WHERE contract_id =" +
                        String.valueOf(id));
        return (contracts != null ? contracts.get(0) : null);
    }

    public Contract findByName(String name) {
        List<Contract> contracts = findByCriteria(
                "WHERE contract_name =" + name + "'");
        return (contracts != null ? contracts.get(0) : null);
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
        return updatebyCriteria("DELETE FROM contracts WHERE customer_id ="+String.valueOf(id)) > 0;

    }

    public boolean delete(String name){
        return updatebyCriteria("DELETE FROM contracts WHERE contract_name ='"+name+"'")>0;
    }
/*
    public boolean update(Contract contract){
        return updatebyCriteria("UPDATE customers SET contract_name ='"+ contract.getName()+"'WHERE contract_id="+
                String.valueOf(contract.getId()))>0;
    }*/

}
